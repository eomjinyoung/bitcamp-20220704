package com.bitcamp.board;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

// 1) 기본 웹 서버 만들기
// 2) 한글 콘텐트를 출력하기
// 3) HTML 콘텐트를 출력하기
// 
public class MiniWebServer03 {

  public static void main(String[] args) throws Exception {

    class MyHttpHandler implements HttpHandler {
      @Override
      public void handle(HttpExchange exchange) throws IOException {
        System.out.println("클라이언트가 요청함!");

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("<!DOCTYPE html>");
        strBuilder.append("<html>");
        strBuilder.append("<head>");
        strBuilder.append("<meta charset=\"UTF-8\">");
        strBuilder.append("<title>bitcamp</title>");
        strBuilder.append("</head>");
        strBuilder.append("<body>");
        strBuilder.append("<h1>환영합니다!</h1>");
        strBuilder.append("<p>비트캠프 게시판 관리 시스템 프로젝트입니다.</p>");
        strBuilder.append("</body>");
        strBuilder.append("</html>");

        byte[] bytes = strBuilder.toString().getBytes("UTF-8");

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
