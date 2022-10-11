package com.bitcamp.board.listener;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import com.bitcamp.board.config.AppConfig;

// 웹애플리케이션이 시작되었을 때 공유할 자원을 준비시키거나 해제하는 일을 한다.
//
@MultipartConfig(maxFileSize = 1024 * 1024 * 10) 
@WebListener
public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("공유 자원을 준비 중!!");
    try {
      // 웹 기능이 포함된 스프링 IoC 컨테이너 준비
      AnnotationConfigWebApplicationContext iocContainer = 
          new AnnotationConfigWebApplicationContext();
      iocContainer.register(AppConfig.class);
      iocContainer.refresh(); // 자바 config 클래스(AppConfig)에 설정된 대로 객체를 생성한다.

      ServletContext ctx = sce.getServletContext();

      // 자바 코드로 서블릿 객체를 직접 생성하여 서버에 등록하기
      DispatcherServlet servlet = new DispatcherServlet(iocContainer);
      Dynamic config = ctx.addServlet("DispatcherServlet", servlet);
      config.addMapping("/service/*");
      config.setMultipartConfig(new MultipartConfigElement(
          this.getClass().getAnnotation(MultipartConfig.class)));
      config.setLoadOnStartup(1); // 웹 애플리케이션을 시작할 때 프론트 컨트롤러를 자동 생성.

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
