package com.bitcamp.board.listener;

import java.sql.Connection;
import java.sql.DriverManager;
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

// 웹애플리케이션이 시작되었을 때 공유할 자원을 준비시키거나 해제하는 일을 한다.
//
@WebListener
public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("공유 자원을 준비 중!!");
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb","study","1111");
      ServletContext ctx = sce.getServletContext();

      BoardDao boardDao = new MariaDBBoardDao(con);
      MemberDao memberDao = new MariaDBMemberDao(con);

      ctx.setAttribute("boardService", new DefaultBoardService(boardDao));
      ctx.setAttribute("memberService", new DefaultMemberService(memberDao));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
