package com.bitcamp.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;

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
      DiskFileItemFactory factory = new DiskFileItemFactory();
      ServletFileUpload upload = new ServletFileUpload(factory);
      List<FileItem> items = upload.parseRequest(request);

      Board board = new Board();
      List<AttachedFile> attachedFiles = new ArrayList<>();

      // 첨부파일을 저장할 OS의 파일시스템 경로를 알아낸다.
      String dirPath = this.getServletContext().getRealPath("/board/files");

      for (FileItem item : items) {
        if (item.isFormField()) { 
          String paramName = item.getFieldName();
          String paramValue = item.getString("UTF-8");

          switch (paramName) {
            case "no": board.setNo(Integer.parseInt(paramValue));
            case "title": board.setTitle(paramValue);
            case "content": board.setContent(paramValue);
          }
        } else {
          // 첨부파일을 저장할 때 사용할 파일명을 생성한다.
          String filename = UUID.randomUUID().toString();

          // 지정한 위치에 생성한 이름으로 첨부파일을 저장한다.
          item.write(new File(dirPath + "/" + filename));

          // 첨부파일의 이름을 DB에 저장할 수 있도록 List에 보관한다.
          attachedFiles.add(new AttachedFile(filename));
        }
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






