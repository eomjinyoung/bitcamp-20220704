package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.service.MemberService;

@WebServlet("/member/list")
public class MemberListController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  MemberService memberService;

  @Override
  public void init() {
    memberService = (MemberService) this.getServletContext().getAttribute("memberService");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      request.setAttribute("members", memberService.list());

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/member/list.jsp").include(request, response);

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response); 
    }
  }
}






