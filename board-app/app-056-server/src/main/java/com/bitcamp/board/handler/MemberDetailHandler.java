/*
 * 회원 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.io.PrintWriter;
import java.util.Map;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;
import com.bitcamp.servlet.Servlet;
import com.bitcamp.servlet.annotation.WebServlet;

@WebServlet(value="/member/detail")
public class MemberDetailHandler implements Servlet {

  private MemberDao memberDao;

  public MemberDetailHandler(MemberDao memberDao) {
    this.memberDao = memberDao;
  }


  @Override
  public void service(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 상세 정보</h1>");

    int no = Integer.parseInt(paramMap.get("no"));
    Member member = memberDao.findByNo(no);

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

    out.println("</body>");
    out.println("</html>");
  }

}




