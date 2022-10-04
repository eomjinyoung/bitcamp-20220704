package com.bitcamp.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10) // 최대 10M까지 업로드 허용
@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
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
      request.setCharacterEncoding("UTF-8");

      Board board = new Board();
      board.setNo(Integer.parseInt(request.getParameter("no")));
      board.setTitle(request.getParameter("title"));
      board.setContent(request.getParameter("content"));

      List<AttachedFile> attachedFiles = new ArrayList<>();
      String dirPath = this.getServletContext().getRealPath("/board/files");
      Collection<Part> parts = request.getParts();
      for (Part part : parts) {
        if (!part.getName().equals("files")) continue;
        String filename = UUID.randomUUID().toString();
        part.write(dirPath + "/" + filename);
        attachedFiles.add(new AttachedFile(filename));
      }
      board.setAttachedFiles(attachedFiles);

      // 게시글 작성자인지 검사한다.
      Member loginMember = (Member) request.getSession().getAttribute("loginMember");
      if (boardDao.findByNo(board.getNo()).getWriter().getNo() != loginMember.getNo()) {
        throw new Exception("게시글 작성자가 아닙니다.");
      }

      if (boardDao.update(board) == 0) {
        throw new Exception("게시글 변경 실패!");
      }

      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}






