package com.bitcamp.board.listener;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import com.bitcamp.board.config.AppConfig;
import com.bitcamp.board.filter.AdminCheckFilter;
import com.bitcamp.board.filter.LoginCheckFilter;

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
      iocContainer.register(AppConfig.class);  // 자바 config 클래스(AppConfig)에 설정된 대로 객체를 생성한다.

      ServletContext ctx = sce.getServletContext();

      // 자바 코드로 서블릿 객체를 직접 생성하여 서버에 등록하기
      DispatcherServlet servlet = new DispatcherServlet(iocContainer);
      Dynamic config = ctx.addServlet("DispatcherServlet", servlet);
      config.addMapping("/service/*");
      config.setMultipartConfig(new MultipartConfigElement(
          this.getClass().getAnnotation(MultipartConfig.class)));
      config.setLoadOnStartup(1); // 웹 애플리케이션을 시작할 때 프론트 컨트롤러를 자동 생성.

      // 필터 등록
      CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF-8");
      FilterRegistration.Dynamic filterConfig = ctx.addFilter("CharacterEncodingFilter", filter);
      filterConfig.addMappingForServletNames(
          EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), 
          false, 
          "DispatcherServlet");

      AdminCheckFilter adminFilter = new AdminCheckFilter();
      FilterRegistration.Dynamic adminFilterConfig = ctx.addFilter("AdminCheckFilter", adminFilter);
      adminFilterConfig.addMappingForUrlPatterns(
          EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), 
          false, 
          "/service/member/*");

      LoginCheckFilter loginFilter = new LoginCheckFilter();
      FilterRegistration.Dynamic loginFilterConfig = ctx.addFilter("LoginCheckFilter", loginFilter);
      loginFilterConfig.addMappingForUrlPatterns(
          EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), 
          false, 
          "/service/*");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
