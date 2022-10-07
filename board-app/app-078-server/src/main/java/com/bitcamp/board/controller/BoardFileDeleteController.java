package com.bitcamp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.BoardService;
import com.bitcamp.servlet.Controller;

public class BoardFileDeleteController implements Controller {

  BoardService boardService;
  public BoardFileDeleteController(BoardService boardService) {
    this.boardService = boardService;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    AttachedFile attachedFile = boardService.getAttachedFile(no); 

    Member loginMember = (Member) request.getSession().getAttribute("loginMember");
    Board board = boardService.get(attachedFile.getBoardNo()); 

    if (board.getWriter().getNo() != loginMember.getNo()) {
      throw new Exception("게시글 작성자가 아닙니다.");
    }

    if (!boardService.deleteAttachedFile(no)) {
      throw new Exception("게시글 첨부파일을 삭제할 수 없습니다.");
    }

    return "redirect:detail?no=" + board.getNo();
  }
}






