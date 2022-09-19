/*
 * 회원 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.io.PrintWriter;
import java.util.Map;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.servlet.Servlet;
import com.bitcamp.servlet.annotation.WebServlet;

@WebServlet(value="/member/delete")
public class MemberDeleteHandler implements Servlet {

  private MemberDao memberDao;

  public MemberDeleteHandler(MemberDao memberDao) {
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
    out.println("<h1>회원 삭제</h1>");

    int no = Integer.parseInt(paramMap.get("no"));

    if (memberDao.delete(no) == 0) {
      out.println("<p>해당 번호의 회원이 없습니다.</p>");

    } else {
      out.println("<p>해당 회원을 삭제했습니다.</p>");
    }

    out.println("</body>");
    out.println("</html>");

  }

}




