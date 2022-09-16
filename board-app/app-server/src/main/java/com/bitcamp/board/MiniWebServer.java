package com.bitcamp.board;

import static org.reflections.scanners.Scanners.TypesAnnotated;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.handler.ErrorHandler;
import com.bitcamp.servlet.Servlet;
import com.bitcamp.servlet.annotation.WebServlet;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

// 1) 기본 웹 서버 만들기
// 2) 한글 콘텐트를 출력하기
// 3) HTML 콘텐트를 출력하기
// 4) 메인 화면을 출력하는 요청처리 객체를 분리하기
// 5) 요청 자원의 경로를 구분하여 처리하기
// 6) 게시글 요청 처리하기
// 7) URL 디코딩 처리
// 8) 회원 요청 처리하기
//
public class MiniWebServer {

  public static void main2(String[] args) throws Exception {
    // 클래스를 찾아주는 도구를 준비
    Reflections reflections = new Reflections("com.bitcamp.board");

    /*
    // 지정된 패키지에서 @WebServlet 애노테이션이 붙은 클래스를 모두 찾는다.
    // 검색필터 1) WebServlet 애노테이션이 붙어 있는 클래스의 이름들을 모두 찾아라!
    QueryFunction<Store,String> 검색필터1 = TypesAnnotated.with(WebServlet.class);

    // 검색필터 2) 찾은 클래스 이름을 가지고 클래스를 Method Area 영역에 로딩하여
    //             Class 객체 목록을 리턴하라!
    QueryFunction<Store,Class<?>> 검색필터2 = 검색필터1.asClass();

    // 위의 두 검색 조건으로 클래스를 찾는다.
    Set<Class<?>> 서블릿클래스들 = reflections.get(검색필터2);

    for (Class<?> 서블릿클래스정보 : 서블릿클래스들) {
      System.out.println(서블릿클래스정보.getName());
    }
     */

    Set<Class<?>> servlets = reflections.get(TypesAnnotated.with(WebServlet.class).asClass());
    for (Class<?> servlet : servlets) {
      WebServlet anno = servlet.getAnnotation(WebServlet.class);
      System.out.printf("%s ---> %s\n", anno.value(), servlet.getName());
    }

  }

  public static void main(String[] args) throws Exception {
    Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");

    BoardDao boardDao = new MariaDBBoardDao(con);
    MemberDao memberDao = new MariaDBMemberDao(con);

    // 서블릿 객체를 보관할 맵을 준비
    Map<String,Servlet> servletMap = new HashMap<>();

    // WebServlet 애노테이션이 붙은 클래스를 찾아 객체를 생성한 후 맵에 저장한다.
    // 맵에 저장할 때 사용할 key는 WebServlet 애노테이션에 설정된 값이다.
    //
    Reflections reflections = new Reflections("com.bitcamp.board");
    Set<Class<?>> servlets = reflections.get(TypesAnnotated.with(WebServlet.class).asClass());
    for (Class<?> servlet : servlets) {
      // 서블릿 클래스의 붙은 WebServlet 애노테이션으로부터 path 를 꺼낸다.
      String servletPath = servlet.getAnnotation(WebServlet.class).value();

      // 생성자의 파라미터의 타입을 알아내, 해당 객체를 주입한다.
      Constructor<?> constructor = servlet.getConstructors()[0];
      Parameter[] params = constructor.getParameters();

      if (params.length == 0) { // 생성자의 파라미터가 없다면 
        servletMap.put(servletPath, (Servlet) constructor.newInstance());

      } else if (params[0].getType() == BoardDao.class) {
        servletMap.put(servletPath, (Servlet) constructor.newInstance(boardDao));

      } else if (params[0].getType() == MemberDao.class) {
        servletMap.put(servletPath, (Servlet) constructor.newInstance(memberDao));
      } 
    }

    ErrorHandler errorHandler = new ErrorHandler();

    class MyHttpHandler implements HttpHandler {
      @Override
      public void handle(HttpExchange exchange) throws IOException {
        System.out.println("클라이언트가 요청함!");

        URI requestUri = exchange.getRequestURI();
        String path = requestUri.getPath();
        // String query = requestUri.getQuery(); // 디코딩을 제대로 수행하지 못한다!
        String query = requestUri.getRawQuery(); // 디코딩 없이 query string을 그대로 리턴 받기!
        byte[] bytes = null;

        try (StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter)) {

          Map<String,String> paramMap = new HashMap<>();
          if (query != null && query.length() > 0) { // 예) no=1&title=aaaa&content=bbb
            String[] entries = query.split("&");
            for (String entry : entries) { // 예) no=1
              String[] kv = entry.split("=");
              // 웹브라우저가 보낸 파라미터 값은 저장하기 전에 URL 디코딩 한다.
              paramMap.put(kv[0], URLDecoder.decode(kv[1], "UTF-8"));
            }
          }
          System.out.println(paramMap);

          Servlet servlet = servletMap.get(path);

          if (servlet != null) {
            servlet.service(paramMap, printWriter);
          } else {
            errorHandler.service(paramMap, printWriter);
          }

          bytes = stringWriter.toString().getBytes("UTF-8");

        } catch (Exception e) {
          bytes = "요청 처리 중 오류 발생!".getBytes("UTF-8");
          e.printStackTrace(); // 서버 콘솔 창에 오류에 대한 자세한 내용을 출력한다.
        }

        // 보내는 콘텐트의 MIME 타입이 무엇인지 응답 헤더에 추가한다.
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        exchange.sendResponseHeaders(200, bytes.length);

        OutputStream out = exchange.getResponseBody();
        out.write(bytes);
        out.close();
      }
    }

    HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);
    server.createContext("/", new MyHttpHandler()); 
    server.setExecutor(null); 
    server.start();

    System.out.println("서버 시작!");
  }

}
