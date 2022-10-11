package com.bitcamp.board.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.BoardService;

@Controller // 페이지 컨트롤러에 붙이는 애노테이션
public class BoardUpdateController {

  BoardService boardService;
  public BoardUpdateController(BoardService boardService) {
    this.boardService = boardService;
  }

  @PostMapping("/board/update") // 요청이 들어 왔을 때 호출될 메서드에 붙이는 애노테이션
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setCharacterEncoding("UTF-8");

    Board board = new Board();
    board.setNo(Integer.parseInt(request.getParameter("no")));
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));

    List<AttachedFile> attachedFiles = new ArrayList<>();
    String dirPath = request.getServletContext().getRealPath("/board/files");
    Collection<Part> parts = request.getParts();
    for (Part part : parts) {
      if (!part.getName().equals("files") || part.getSize() == 0) continue;
      String filename = UUID.randomUUID().toString();
      part.write(dirPath + "/" + filename);
      attachedFiles.add(new AttachedFile(filename));
    }
    board.setAttachedFiles(attachedFiles);

    // 게시글 작성자인지 검사한다.
    Member loginMember = (Member) request.getSession().getAttribute("loginMember");
    if (boardService.get(board.getNo()).getWriter().getNo() != loginMember.getNo()) {
      throw new Exception("게시글 작성자가 아닙니다.");
    }

    if (!boardService.update(board)) {
      throw new Exception("게시글을 변경할 수 없습니다!");
    }

    return "redirect:list";
  }
}






