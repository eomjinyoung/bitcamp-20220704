/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.io.PrintWriter;
import java.util.Map;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;
import com.bitcamp.servlet.Servlet;
import com.bitcamp.servlet.annotation.WebServlet;

@WebServlet(value="/board/detail")
public class BoardDetailHandler implements Servlet {

  private BoardDao boardDao;

  public BoardDetailHandler(BoardDao boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void service(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 상세 정보</h1>");

    int boardNo = Integer.parseInt(paramMap.get("no"));
    Board board = boardDao.findByNo(boardNo);

    if (board == null) {
      out.println("<p>해당 번호의 게시글이 없습니다.</p>");

    } else {
      out.println("<form action='update'>");
      out.println("<table border='1'>");
      out.println("  <tr>");
      out.printf("    <th>번호</th><td><input name='no' type='number' value='%d' readonly></td>", board.no);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>제목</th><td><input name='title' type='text' value='%s' size='60'></td>", board.title);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>내용</th><td><textarea name='content' rows='10' cols='60'>%s</textarea></td>", board.content);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>조회수</th><td>%d</td>", board.viewCount);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>작성자</th><td>%d</td>", board.memberNo);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>등록일</th><td>%s</td>", board.createdDate);
      out.println("  </tr>");
      out.println("</table>");
      out.println("<p>");
      out.println("  <button type='submit'>변경</button>");
      out.printf("  <a href='delete?no=%d'>삭제</a>", board.no);
      out.println("</p>");
      out.println("</form>");
    }

    out.println("</body>");
    out.println("</html>");
  }

}




