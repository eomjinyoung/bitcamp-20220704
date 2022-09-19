/*
 * 회원 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;
import com.bitcamp.servlet.Servlet;
import com.bitcamp.servlet.annotation.WebServlet;

@WebServlet(value="/member/list")
public class MemberListHandler implements Servlet {

  private MemberDao memberDao;

  public MemberListHandler(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Map<String,String> paramMap, PrintWriter out) throws Exception {

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
    out.println("<table border='1'>");
    out.println("  <tr>");
    out.println("    <th>번호</th>");
    out.println("    <th>이름</th>");
    out.println("    <th>이메일</th>");
    out.println("  </tr>");

    List<Member> members = memberDao.findAll();
    for (Member member : members) {
      out.println("<tr>");
      out.printf("  <td>%d</td>", member.no);
      out.printf("  <td><a href='detail?no=%d'>%s</a></td>", member.no, member.name);
      out.printf("  <td>%s</td>", member.email);
      out.println("</tr>");
    }

    out.println("</table>");
    out.println("<p><a href='/'>메인</a></p>");
    out.println("</body>");
    out.println("</html>");
  }

}




