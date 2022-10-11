package com.bitcamp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

//@MultipartConfig(maxFileSize = 1024 * 1024 * 10) 
//@WebServlet(value = "/service/*")
public class DispatcherServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  ApplicationContext iocContext;

  public DispatcherServlet(ApplicationContext iocContainer) {
    // Spring IoC 컨테이너를 주입 받는다.
    this.iocContext = iocContainer;
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    try {
      // 프론트 컨트롤러를 경유해서 실행할 페이지 컨트롤러의 경로를 알아낸다.
      // - "/service" 다음에 오는 경로, 즉 * 에 해당하는 경로를 리턴한다.
      String pathInfo = req.getPathInfo();

      // 페이지 컨트롤러를 찾는다.
      Controller controller = (Controller) req.getServletContext().getAttribute(pathInfo);
      if (controller == null) {
        throw new Exception("페이지 컨트롤러가 없습니다!");
      }

      // 페이지 컨트롤러를 실행한다.
      resp.setContentType("text/html;charset=UTF-8");
      String viewName = controller.execute(req, resp);

      if (viewName.startsWith("redirect:")) { // 예) "redirect:list"
        resp.sendRedirect(viewName.substring(9)); // 예) "list" <-- 리다이렉트할 URL을 잘라낸다.

      } else {
        req.getRequestDispatcher(viewName).include(req, resp);
      }

    } catch (Exception e) {
      req.setAttribute("exception", e);
      req.getRequestDispatcher("/error.jsp").forward(req, resp);
    }
  }
}






