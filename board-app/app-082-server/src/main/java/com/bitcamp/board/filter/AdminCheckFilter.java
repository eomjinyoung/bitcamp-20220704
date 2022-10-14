package com.bitcamp.board.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.Member;

//@WebFilter("/service/member/*")
public class AdminCheckFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("AdminCheckFilter.init() 실행!");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    System.out.println("AdminCheckFilter.doFilter() 실행!");

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    Member loginMember = (Member) httpRequest.getSession().getAttribute("loginMember");
    if (loginMember == null || // 로그인이 안됐거나 
        !loginMember.getEmail().equals("admin@test.com")) { // 관리자가 아니라면
      httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
      return;
    }

    chain.doFilter(request, response);
  }

}








