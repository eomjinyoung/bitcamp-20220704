package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;

@WebServlet("/board/fileDelete")
public class BoardFileDeleteController extends HttpServlet {
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

      // 첨부파일 정보를 가져온다.
      AttachedFile attachedFile = boardDao.findFileByNo(no); 

      // 게시글의 작성자가 로그인 사용자인지 검사한다.
      Member loginMember = (Member) request.getSession().getAttribute("loginMember");
      Board board = boardDao.findByNo(attachedFile.getBoardNo()); 

      if (board.getWriter().getNo() != loginMember.getNo()) {
        throw new Exception("게시글 작성자가 아닙니다.");
      }

      // 첨부파일을 삭제한다.
      if (boardDao.deleteFile(no) == 0) {
        throw new Exception("게시글 첨부파일 삭제 실패!");
      }

      response.sendRedirect("detail?no=" + board.getNo());

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}






