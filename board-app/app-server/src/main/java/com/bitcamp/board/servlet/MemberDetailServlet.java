package com.bitcamp.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.Member;

@WebServlet(value="/member/detail")
public class MemberDetailServlet extends HttpServlet {
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
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 상세 정보</h1>");

    try {
      int no = Integer.parseInt(req.getParameter("no"));
      Member member = AppInitServlet.memberDao.findByNo(no);

      if (member == null) {
        out.println("<p>해당 번호의 회원이 없습니다.</p>");

      } else {
        out.println("<form action='update'>");
        out.println("<table border='1'>");
        out.println("  <tr>");
        out.printf("    <th>번호</th><td><input name='no' type='number' value='%d' readonly></td>", member.no);
        out.println("  </tr>");
        out.println("  <tr>");
        out.printf("    <th>이름</th><td><input name='name' type='text' value='%s' size='60'></td>", member.name);
        out.println("  </tr>");
        out.println("  <tr>");
        out.printf("    <th>이메일</th><td><input name='email' type='email' value='%s' size='60'></td>", member.email);
        out.println("  </tr>");
        out.println("  <tr>");
        out.println("    <th>암호</th><td><input name='password' type='password' size='10'></td>");
        out.println("  </tr>");
        out.println("  <tr>");
        out.printf("    <th>등록일</th><td>%s</td>", member.createdDate);
        out.println("  </tr>");
        out.println("</table>");
        out.println("<p>");
        out.println("  <button type='submit'>변경</button>");
        out.printf("  <a href='delete?no=%d'>삭제</a>", member.no);
        out.println("</p>");
        out.println("</form>");
      }
    } catch (Exception e) {
      out.println("<p>실행 중 오류 발생!</p>");
    }

    out.println("</body>");
    out.println("</html>");
  }

}




