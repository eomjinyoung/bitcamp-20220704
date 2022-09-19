/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.io.PrintWriter;
import java.util.Map;
import com.bitcamp.servlet.Servlet;
import com.bitcamp.servlet.annotation.WebServlet;

@WebServlet(value="/board/form")
public class BoardFormHandler implements Servlet {

  @Override
  public void service(Map<String, String> paramMap, PrintWriter out) {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 입력</h1>");

    out.println("<form action='add'>");
    out.println("<table border='1'>");
    out.println("  <tr>");
    out.println("    <th>제목</th><td><input name='title' type='text' size='60'></td>");
    out.println("  </tr>");
    out.println("  <tr>");
    out.println("    <th>내용</th><td><textarea name='content' rows='10' cols='60'></textarea></td>");
    out.println("  </tr>");
    out.println("  <tr>");
    out.println("    <th>작성자</th><td><input name='writerNo' type='number' size='5'></td>");
    out.println("  </tr>");
    out.println("</table>");
    out.println("<p>");
    out.println("  <button type='submit'>등록</button>");
    out.println("  <a href='list'>목록</a>");
    out.println("</p>");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");

  }


}




