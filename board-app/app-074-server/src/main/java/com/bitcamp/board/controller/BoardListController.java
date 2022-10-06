package com.bitcamp.board.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.service.BoardService;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardService boardService;

  @Override
  public void init() {
    boardService = (BoardService) this.getServletContext().getAttribute("boardService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      List<Board> boards = boardService.list();

      req.setAttribute("boards", boards);

      resp.setContentType("text/html;charset=UTF-8"); // JSP가 출력할 콘텐트의 MIME 타입 설정
      RequestDispatcher 요청배달자 = req.getRequestDispatcher("/board/list.jsp");
      요청배달자.include(req, resp); // JSP를 실행한 후 리턴된다.

    } catch (Exception e) {
      RequestDispatcher 요청배달자 = req.getRequestDispatcher("/error.jsp");
      req.setAttribute("exception", e);
      요청배달자.forward(req, resp); // JSP를 실행한 후 리턴된다.
    }
  }
}






