package com.bitcamp.board.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.MemberService;

@Controller 
@RequestMapping("/auth/")
public class AuthController {

  MemberService memberService;

  public AuthController(MemberService memberService) {
    System.out.println("AuthController() 호출됨!");
    this.memberService = memberService;
  }

  @GetMapping("form") 
  public String form() throws Exception {
    return "auth/form";
  }

  @PostMapping("login") 
  public ModelAndView login(
      String email, 
      String password, 
      String saveEmail, 
      HttpServletResponse response,
      HttpSession session) throws Exception {

    Member member = memberService.get(email, password);

    if (member != null) {
      session.setAttribute("loginMember", member); 
    }

    Cookie cookie = new Cookie("email", email); 
    if (saveEmail == null) {
      cookie.setMaxAge(0); 
    } else {
      cookie.setMaxAge(60 * 60 * 24 * 7); // 7일
    }
    response.addCookie(cookie); 

    ModelAndView mv = new ModelAndView("auth/loginResult");
    mv.addObject("member", member);
    return mv;
  }

  @GetMapping("logout") 
  public String logout(HttpSession session) throws Exception {
    session.invalidate(); 
    return "redirect:../../"; 
  }
}






