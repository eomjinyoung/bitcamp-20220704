package com.bitcamp.board.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;
import com.bitcamp.board.filter.AdminCheckFilter;
import com.bitcamp.board.filter.LoginCheckFilter;

// 
// 서블릿 컨테이너에서 웹 애플리케이션을 시작할 때:
// ==> 수퍼 클래스 코드를 분석하시오!! 제발!!!
//
public class AppWebApplicationInitializer extends AbstractDispatcherServletInitializer {

  // 수퍼클래스에서 ContextLoaderListener 를 준비할 때 사용할 Root IoC 컨테이너를 리턴한다. 
  @Override
  protected WebApplicationContext createRootApplicationContext() {
    return null; // 설정할 필요가 없다면 null을 리턴
  }

  // 수퍼클래스에서 DispatcherServlet 을 준비할 때 사용할 서블릿 이름을 리턴한다.
  @Override
  protected String getServletName() {
    return "app";
  }

  // 수퍼클래스에서 DispatcherServlet 을 준비할 때 사용할 IoC 컨테이너를 리턴한다.
  @Override
  protected WebApplicationContext createServletApplicationContext() {
    AnnotationConfigWebApplicationContext iocContainer = 
        new AnnotationConfigWebApplicationContext();
    iocContainer.register(AppConfig.class);
    return iocContainer;
  }

  // 수퍼클래스에서 DispatcherServlet 의 URL을 연결할 때 사용할 경로를 리턴한다.
  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app/*"};
  }

  // 수퍼클래스에서 필터를 등록할 때 사용할 정보를 리턴한다.
  @Override
  protected Filter[] getServletFilters() {
    return new Filter[] {
        new CharacterEncodingFilter("UTF-8"),
        new AdminCheckFilter(),
        new LoginCheckFilter()
    };
  }

  // 수퍼클래스에서 DispatcherServlet 을 준비할 때 추가적으로 설정할 것이 있으면 설정한다.
  @Override
  protected void customizeRegistration(Dynamic registration) {
    registration.setMultipartConfig(new MultipartConfigElement(
        System.getProperty("java.io.tmpdir"), // 클라이언트가 보낸 파일을 임시 저장할 때 사용할 디렉토리
        1024 * 1024 * 5, // 한 파일의 최대 크기
        1024 * 1024 * 10, // 첨부 파일을 포함한 전체 요청 데이터의 최대 크기
        1024 * 1024 // 첨부 파일을 데이터를 일시적으로 보관할 버퍼 크기
        ));
  }
}
