package com.bitcamp.board.listener;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebListener;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.service.DefaultBoardService;
import com.bitcamp.board.service.DefaultMemberService;
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

      ctx.setAttribute("boardService", new DefaultBoardService(boardDao, txManager));
      ctx.setAttribute("memberService", new DefaultMemberService(memberDao));

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
