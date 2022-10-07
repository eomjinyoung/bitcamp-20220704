package com.bitcamp.board.listener;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebListener;
import com.bitcamp.board.controller.BoardAddController;
import com.bitcamp.board.controller.BoardDeleteController;
import com.bitcamp.board.controller.BoardDetailController;
import com.bitcamp.board.controller.BoardFileDeleteController;
import com.bitcamp.board.controller.BoardFormController;
import com.bitcamp.board.controller.BoardListController;
import com.bitcamp.board.controller.BoardUpdateController;
import com.bitcamp.board.controller.LoginController;
import com.bitcamp.board.controller.LoginFormController;
import com.bitcamp.board.controller.LogoutController;
import com.bitcamp.board.controller.MemberAddController;
import com.bitcamp.board.controller.MemberDeleteController;
import com.bitcamp.board.controller.MemberDetailController;
import com.bitcamp.board.controller.MemberFormController;
import com.bitcamp.board.controller.MemberListController;
import com.bitcamp.board.controller.MemberUpdateController;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.service.BoardService;
import com.bitcamp.board.service.DefaultBoardService;
import com.bitcamp.board.service.DefaultMemberService;
import com.bitcamp.board.service.MemberService;
import com.bitcamp.servlet.DispatcherServlet;
import com.bitcamp.sql.DataSource;
import com.bitcamp.transaction.TransactionManager;

// 웹애플리케이션이 시작되었을 때 공유할 자원을 준비시키거나 해제하는 일을 한다.
//
@MultipartConfig(maxFileSize = 1024 * 1024 * 10) 
@WebListener
public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("공유 자원을 준비 중!!");
    try {
      ServletContext ctx = sce.getServletContext();

      DataSource ds = new DataSource(
          "org.mariadb.jdbc.Driver", 
          "jdbc:mariadb://localhost:3306/studydb",
          "study",
          "1111");

      TransactionManager txManager = new TransactionManager(ds);

      BoardDao boardDao = new MariaDBBoardDao(ds);
      MemberDao memberDao = new MariaDBMemberDao(ds);

      BoardService boardService = new DefaultBoardService(boardDao, txManager);
      MemberService memberService = new DefaultMemberService(memberDao);

      ctx.setAttribute("/board/list", new BoardListController(boardService));
      ctx.setAttribute("/board/detail", new BoardDetailController(boardService));
      ctx.setAttribute("/board/form", new BoardFormController());
      ctx.setAttribute("/board/add", new BoardAddController(boardService));
      ctx.setAttribute("/board/fileDelete", new BoardFileDeleteController(boardService));
      ctx.setAttribute("/board/update", new BoardUpdateController(boardService));
      ctx.setAttribute("/board/delete", new BoardDeleteController(boardService));

      ctx.setAttribute("/member/list", new MemberListController(memberService));
      ctx.setAttribute("/member/detail", new MemberDetailController(memberService));
      ctx.setAttribute("/member/form", new MemberFormController());
      ctx.setAttribute("/member/add", new MemberAddController(memberService));
      ctx.setAttribute("/member/update", new MemberUpdateController(memberService));
      ctx.setAttribute("/member/delete", new MemberDeleteController(memberService));

      ctx.setAttribute("/auth/form", new LoginFormController());
      ctx.setAttribute("/auth/login", new LoginController(memberService));
      ctx.setAttribute("/auth/logout", new LogoutController());


      // 자바 코드로 서블릿 객체를 직접 생성하여 서버에 등록하기
      DispatcherServlet servlet = new DispatcherServlet();
      Dynamic config = ctx.addServlet("DispatcherServlet", servlet);
      config.addMapping("/service/*");
      config.setMultipartConfig(new MultipartConfigElement(
          this.getClass().getAnnotation(MultipartConfig.class)));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
