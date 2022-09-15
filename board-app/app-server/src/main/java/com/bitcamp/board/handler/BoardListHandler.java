package com.bitcamp.board.handler;

import java.io.PrintWriter;

public class BoardListHandler {
  public void execute(PrintWriter out) {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");
    out.println("<p>콘텐트 준비 중!</p>");
    out.println("</body>");
    out.println("</html>");
  }
}
