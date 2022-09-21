package com.bitcamp.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.Member;

@WebServlet(value="/member/list")
public class MemberListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html;charset=UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<style>");
    out.println("tr:hover {");
    out.println("  background-color: navy;");
    out.println("  color: white;");
    out.println("}");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");

    out.println("<a href='form'>새 회원</a>");

    try {
      out.println("<table border='1'>");
      out.println("  <tr>");
      out.println("    <th>번호</th>");
      out.println("    <th>이름</th>");
      out.println("    <th>이메일</th>");
      out.println("  </tr>");

      List<Member> members = AppInitServlet.memberDao.findAll();
      for (Member member : members) {
        out.println("<tr>");
        out.printf("  <td>%d</td>", member.no);
        out.printf("  <td><a href='detail?no=%d'>%s</a></td>", member.no, member.name);
        out.printf("  <td>%s</td>", member.email);
        out.println("</tr>");
      }
    } catch (Exception e) {
      out.println("<p>실행 중 오류 발생!</p>");
    }
    out.println("</table>");
    out.println("<p><a href='../welcome'>메인</a></p>");
    out.println("</body>");
    out.println("</html>");
  }

}




