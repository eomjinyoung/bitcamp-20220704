package com.bitcamp.board.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.MemberService;
import com.bitcamp.servlet.Controller;

public class LoginController implements Controller {

  MemberService memberService;
  public LoginController(MemberService memberService) {
    this.memberService = memberService;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    Member member = memberService.get(email, password);

    if (member != null) {
      HttpSession session = request.getSession(); 
      session.setAttribute("loginMember", member); 
    }

    Cookie cookie = new Cookie("email", email); 
    if (request.getParameter("saveEmail") == null) {
      cookie.setMaxAge(0); 
    } else {
      cookie.setMaxAge(60 * 60 * 24 * 7); // 7일
    }
    response.addCookie(cookie); 

    request.setAttribute("member", member);
    return "/auth/loginResult.jsp";
  }
}






