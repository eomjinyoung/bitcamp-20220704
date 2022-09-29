package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;

@WebServlet("/board/add")
public class BoardAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardDao boardDao;

  @Override
  public void init() {
    boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      // URL 디코딩 한 바이트를 UTF-16으로 변환하기 전에 
      // 그 바이트의 characterset이 무엇인지 알려줘야 한다.
      // 안 알려주면 그 디코딩 바이트가 ASCII 코드라고 간주한다.
      // UTF-8 코드를 ASCII 코드라고 잘못 판단하니까 UTF-16으로 바꿀 때 오류가 발생하는 것이다.
      // 물론 영어나 숫자는 ASCII 코드와 UTF-8 코드가 같기 때문에 UTF-16으로 변환하더라도 문제가 되지 않는다.
      // 그러나 한글은 UTF-8 코드의 3바이트를 묶어서 UTF-16 2바이트로 변환해야 하는데
      // 영어라고 간주하고 각각의 1바이트를 2바이트로 변환하니 문제가 발생하는 것이다.
      request.setCharacterEncoding("UTF-8");

      Board board = new Board();
      board.setTitle(request.getParameter("title"));
      board.setContent(request.getParameter("content"));

      Member loginMember = (Member) request.getSession().getAttribute("loginMember");
      board.setWriter(loginMember);

      if (boardDao.insert(board) == 0) {
        throw new Exception("게시글 등록 실패!");
      }

      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}






