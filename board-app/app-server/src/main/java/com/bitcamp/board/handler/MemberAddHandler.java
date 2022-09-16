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

@WebServlet(value="/member/add")
public class MemberAddHandler implements Servlet {

  private MemberDao memberDao;

  public MemberAddHandler(MemberDao memberDao) {
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
    out.println("<h1>회원 입력</h1>");

    Member member = new Member();
    member.name = paramMap.get("name");
    member.email = paramMap.get("email");
    member.password = paramMap.get("password");

    if (memberDao.insert(member) == 0) {
      out.println("<p>회원을 등록할 수 없습니다!</p>");

    } else {
      out.println("<p>회원을 등록했습니다.</p>");
    }

    out.println("</body>");
    out.println("</html>");

  }
}




