package com.bitcamp.board.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;

// 이 서블릿은 다른 서블릿이 사용할 객체를 준비하는 일을 한다.
//
@WebServlet(
    value="/init", 
    loadOnStartup=1)
public class AppInitServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  public void init() throws ServletException {
    // 톰캣서버 --> init(ServletConfig) --> init()
    System.out.println("공유 자원을 준비 중!");
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      Connection con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb","study","1111");

      // 생성자에서 getServletContext()를 호출하면 오류 발생!
      // 왜? 
      //  - ServletContext는 ServletConfig 객체를 통해 꺼낼 수 가 있는데,
      //  - ServletConfig는 아직 주입되지 않은 상태이다.
      // ServletConfig 객체가 언제 주입되는가?
      //  - 생성자 다음에 호출되는 init()가 호출될 때 ServletConfig 객체가 주입된다.
      // 
      ServletContext ctx = this.getServletContext();
      ctx.setAttribute("boardDao", new MariaDBBoardDao(con));
      ctx.setAttribute("memberDao", new MariaDBMemberDao(con));
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  // 이 서블릿의 역할은 다른 서블릿이 사용할 자원을 준비하는 것이기 때문에
  // 굳이 요청을 처리하는 메서드를 정의할 필요가 없다.
}






