package com.bitcamp.board.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.service.DefaultBoardService;
import com.bitcamp.board.service.DefaultMemberService;
import com.bitcamp.sql.DataSource;

// 웹애플리케이션이 시작되었을 때 공유할 자원을 준비시키거나 해제하는 일을 한다.
//
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

      BoardDao boardDao = new MariaDBBoardDao(ds);
      MemberDao memberDao = new MariaDBMemberDao(ds);

      ctx.setAttribute("boardService", new DefaultBoardService(boardDao, ds));
      ctx.setAttribute("memberService", new DefaultMemberService(memberDao));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
