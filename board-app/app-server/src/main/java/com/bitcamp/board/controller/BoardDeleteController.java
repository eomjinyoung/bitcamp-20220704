package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.BoardService;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardService boardService;

  @Override
  public void init() {
    boardService = (BoardService) this.getServletContext().getAttribute("boardService");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Member loginMember = (Member) request.getSession().getAttribute("loginMember");
      if (boardService.get(no).getWriter().getNo() != loginMember.getNo()) {
        throw new Exception("게시글 작성자가 아닙니다.");
      }

      if (!boardService.delete(no)) {
        throw new Exception("게시글을 삭제할 수 없습니다.");
      }

      request.setAttribute("viewName", "redirect:list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
    }
  }
}






