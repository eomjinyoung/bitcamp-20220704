package com.bitcamp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.service.BoardService;
import com.bitcamp.servlet.Controller;

public class BoardListController implements Controller {

  BoardService boardService;
  public BoardListController(BoardService boardService) {
    this.boardService = boardService;
  }

  @Override
  public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    req.setAttribute("boards", boardService.list());
    return "/board/list.jsp";
  }
}






