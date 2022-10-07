package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.service.MemberService;

@WebServlet("/member/delete")
public class MemberDeleteController extends HttpServlet {
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
      int no = Integer.parseInt(request.getParameter("no"));

      if (!memberService.delete(no)) {
        throw new Exception("회원 삭제 오류입니다!");
      }

      request.setAttribute("viewName", "redirect:list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
    }
  }
}






