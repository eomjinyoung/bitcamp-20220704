package com.bitcamp.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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

    // 프론트 컨트롤러를 경유해서 실행할 페이지 컨트롤러의 경로를 알아낸다.
    // - "/service" 다음에 오는 경로, 즉 * 에 해당하는 경로를 리턴한다.
    String pathInfo = req.getPathInfo();

    // 페이지 컨트롤러로 실행을 위임한다.
    resp.setContentType("text/html;charset=UTF-8");
    RequestDispatcher 요청배달자 = req.getRequestDispatcher(pathInfo);
    요청배달자.include(req, resp);

    // 페이지 컨트롤러를 실행한 후에 페이지 컨트롤러가 지정한 뷰 컴포넌트를 실행한다.
    String viewName = (String) req.getAttribute("viewName");

    if (viewName != null) { // 페이지 컨트롤러를 정상적으로 실행했다면,
      req.getRequestDispatcher(viewName).include(req, resp);

    } else { // 페이지 컨트롤러를 실행하다가 오류가 발생했다면
      req.getRequestDispatcher("/error.jsp").forward(req, resp);
    }
  }
}







