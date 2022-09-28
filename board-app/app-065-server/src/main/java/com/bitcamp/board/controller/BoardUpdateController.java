package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;

@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardDao boardDao;

  @Override
  public void init() {
    boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Board board = new Board();
      board.no = Integer.parseInt(request.getParameter("no"));
      board.title = request.getParameter("title");
      board.content = request.getParameter("content");

      if (boardDao.update(board) == 0) {
        throw new Exception("게시글 변경 실패!");
      }

      // Refresh:
      // - 응답 헤더 또는 HTML 문서에 refresh 명령을 삽입할 수 있다.
      // - 응답 프로토콜
      //      HTTP/1.1 200
      //      Content-Type: text/html;charset=UTF-8
      //      Refresh: 30;url=list   <=== 응답 헤더에 refresh 명령을 삽입한다.
      //      Content-Length: 244
      //      Date: Mon, 26 Sep 2022 05:24:29 GMT
      //      Keep-Alive: timeout=20
      //      Connection: keep-alive
      //
      //      <!DOCTYPE html>
      //      <html>
      //      <head>
      //      <meta charset="UTF-8">
      //      <title>bitcamp</title>
      //      </head>
      //      <body>
      //      <h1>게시글 변경-JSP</h1>
      //      <p>게시글을 변경했습니다.</p>
      //      </body>
      //      </html>
      //
      // 자바 코드:
      response.setHeader("Refresh", "1;url=list"); // 응답 헤더에 refresh를 삽입한다.
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/board/update.jsp").include(request, response); 

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}






