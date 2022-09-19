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

@WebServlet(value="/member/update")
public class MemberUpdateHandler implements Servlet {

  private MemberDao memberDao;

  public MemberUpdateHandler(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<meta http-equiv='Refresh' content='1; url=list'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 변경</h1>");

    Member member = new Member();
    member.no = Integer.parseInt(paramMap.get("no"));
    member.name = paramMap.get("name");
    member.email = paramMap.get("email");
    member.password = paramMap.get("password");

    if (memberDao.update(member) == 0) {
      out.println("<p>해당 번호의 회원이 없습니다.</p>");

    } else {
      out.println("<p>해당 회원을 변경했습니다.</p>");
    }

    out.println("</body>");
    out.println("</html>");
  }

}




