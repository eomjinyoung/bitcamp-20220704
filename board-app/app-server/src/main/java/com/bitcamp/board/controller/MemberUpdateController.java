package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.MemberService;

@WebServlet("/member/update")
public class MemberUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  MemberService memberService;

  @Override
  public void init() {
    memberService = (MemberService) this.getServletContext().getAttribute("memberService");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      request.setCharacterEncoding("UTF-8");

      Member member = new Member();
      member.setNo(Integer.parseInt(request.getParameter("no")));
      member.setName(request.getParameter("name"));
      member.setEmail(request.getParameter("email"));
      member.setPassword(request.getParameter("password"));

      if (!memberService.update(member)) {
        throw new Exception("회원 변경 오류입니다!");
      }

      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response); 
    }
  }
}






