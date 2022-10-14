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

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    // 서블릿 컨테이너에 직접 등록하지 않고 스프링을 통해 등록한 경우에는
    // 요청 URL에 따라 필터가 동작하도록 설정할 수 없다.
    // 필터 코드 안에서 URL을 제어해야 한다.
    // 그래서 다음 코드에 if() {} 문이 있는 것이다.
    //
    if (httpRequest.getPathInfo().startsWith("/member")) {
      System.out.println("AdminCheckFilter.doFilter() 실행!");
      Member loginMember = (Member) httpRequest.getSession().getAttribute("loginMember");
      if (loginMember == null || // 로그인이 안됐거나 
          !loginMember.getEmail().equals("admin@test.com")) { // 관리자가 아니라면
        httpResponse.sendRedirect(httpRequest.getContextPath() + "/");
        return;
      }
    }

    chain.doFilter(request, response);
  }

}








