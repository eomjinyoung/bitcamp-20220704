package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.dao.BoardDao;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
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
      int no = Integer.parseInt(request.getParameter("no"));

      if (boardDao.delete(no) == 0) {
        throw new Exception("게시글 삭제 실패!");
      }

      // Redirect:
      // - 클라이언트에게 콘텐트를 보내지 않는다.
      // - 응답 프로토콜
      //      HTTP/1.1 302   <=== 응답 상태 코드
      //      Location: list  <=== 자동으로 요청할 URL
      //      Content-Length: 0  <=== 콘텐트는 보내지 않는다.
      //      Date: Mon, 26 Sep 2022 05:21:22 GMT
      //      Keep-Alive: timeout=20
      //      Connection: keep-alive
      // 
      //      (콘텐트 없음!)
      //
      // 자바 코드:
      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}






