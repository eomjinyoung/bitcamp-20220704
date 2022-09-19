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

@WebServlet(value="/board/add")
public class BoardAddHandler implements Servlet {

  private BoardDao boardDao;

  public BoardAddHandler(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<meta http-equiv='Refresh' content='1; url=list'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 입력</h1>");

    Board board = new Board();
    board.title = paramMap.get("title");
    board.content = paramMap.get("content");
    board.memberNo = Integer.parseInt(paramMap.get("writerNo"));

    if (boardDao.insert(board) == 0) {
      out.println("<p>게시글을 등록할 수 없습니다!</p>");

    } else {
      out.println("<p>게시글을 등록했습니다.</p>");
    }

    out.println("</body>");
    out.println("</html>");

  }


}




