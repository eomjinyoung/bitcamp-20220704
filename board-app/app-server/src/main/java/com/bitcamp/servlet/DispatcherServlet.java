package com.bitcamp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 역할:
// - 페이지 컨트롤러의 앞쪽에서 클라이언트 요청을 받는 일을 한다.
// - 클라이언트가 요청한 경로에 따라 적절한 페이지 컨트롤러를 실행한다.
// - 페이지 컨트롤러의 공통 기능을 수행한다.
//
//@WebServlet(value = "/service/*")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("DispatcherServelt 실행!");
  }
}







