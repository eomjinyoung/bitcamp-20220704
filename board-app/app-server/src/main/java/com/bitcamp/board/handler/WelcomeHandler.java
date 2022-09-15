package com.bitcamp.board.handler;

import java.io.PrintWriter;
import java.util.Map;

public class WelcomeHandler {
  public void service(Map<String,String> paramMap, PrintWriter out) {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>환영합니다!2</h1>");
    out.println("<p>비트캠프 게시판 관리 시스템 프로젝트입니다.</p>");
    out.println("</body>");
    out.println("</html>");
  }
}
