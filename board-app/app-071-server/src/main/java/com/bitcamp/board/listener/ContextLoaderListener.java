package com.bitcamp.board.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;

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
      ctx.setAttribute("boardDao", new MariaDBBoardDao(con));
      ctx.setAttribute("memberDao", new MariaDBMemberDao(con));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
