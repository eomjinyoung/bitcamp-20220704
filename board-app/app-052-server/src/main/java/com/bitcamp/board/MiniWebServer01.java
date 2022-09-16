package com.bitcamp.board;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

// 1) 기본 웹 서버 만들기
//
public class MiniWebServer01 {

  public static void main(String[] args) throws Exception {

    // 클라이언트 요청을 처리하는 객체
    class MyHttpHandler implements HttpHandler {
      @Override
      public void handle(HttpExchange exchange) throws IOException {
        // 클라이언트 요청이 들어 왔을 때 마다 호출된다.
        System.out.println("클라이언트가 요청함!");

        // 응답할 콘텐트 준비 
        String response = "This is the response";

        // 응답헤더 전송
        exchange.sendResponseHeaders(200, response.length());

        // 콘텐트 출력 스트림 준비
        OutputStream out = exchange.getResponseBody();

        out.write(response.getBytes());
        out.close();
      }
    }

    HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);
    server.createContext("/", new MyHttpHandler()); 
    server.setExecutor(null); // HttpServer에 기본으로 설정되어 있는 Executor 사용
    // Executor? 멀티 스레딩을 수행하는 객체
    server.start(); // HttpServer를 시작시킨 후 즉시 리턴한다.

    System.out.println("서버 시작!");
    // main() 메서드 호출이 끝났다 하더라도 
    // 내부에서 생성한 스레드(예: HttpServer)가 종료되지 않으면 JVM도 종료되지 않는다.
  }

}
