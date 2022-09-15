/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;
import com.bitcamp.util.Prompt;

public class BoardHandler {

  private BoardDao boardDao;

  public BoardHandler(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  public void list(PrintWriter out) throws Exception {
    //List<Board> boards = boardDao.findAll();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");
    out.println("<table width='1'>");
    out.println("  <tr>");
    out.println("    <th>번호</th>");
    out.println("    <th>제목</th>");
    out.println("    <th>조회수</th>");
    out.println("    <th>작성자</th>");
    out.println("    <th>등록일</th>");
    out.println("  </tr>");
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");

    //    tempOut.println("번호 제목 조회수 작성자 등록일");
    //    for (Board board : boards) {
    //      tempOut.printf("%d\t%s\t%d\t%d\t%s\n",
    //          board.no, board.title, board.viewCount, board.memberNo, board.createdDate);
    //    }
  }

  private void onDetail(DataInputStream in, DataOutputStream out) throws Exception {

    Prompt prompt = new Prompt(in, out);

    int boardNo = 0;
    while (true) {
      try {
        boardNo = prompt.inputInt("조회할 게시글 번호? ");
        break;
      } catch (Exception ex) {
        out.writeUTF("입력 값이 옳지 않습니다!");
      }
    }

    Board board = boardDao.findByNo(boardNo);

    try (StringWriter strOut = new StringWriter();
        PrintWriter tempOut = new PrintWriter(strOut)) {

      if (board == null) {
        tempOut.println("해당 번호의 게시글이 없습니다!");
        out.writeUTF(strOut.toString());
        return;
      }

      tempOut.printf("번호: %d\n", board.no);
      tempOut.printf("제목: %s\n", board.title);
      tempOut.printf("내용: %s\n", board.content);
      tempOut.printf("조회수: %d\n", board.viewCount);
      tempOut.printf("작성자: %d\n", board.memberNo);
      tempOut.printf("등록일: %s\n", board.createdDate);

      out.writeUTF(strOut.toString());
    }
  }

  private void onInput(DataInputStream in, DataOutputStream out) throws Exception {

    Prompt prompt = new Prompt(in, out);

    Board board = new Board();

    board.title = prompt.inputString("제목? ");
    board.content = prompt.inputString("내용? ");
    board.memberNo = prompt.inputInt("작성자? ");

    boardDao.insert(board);
    out.writeUTF("게시글을 등록했습니다.");
  }

  private void onDelete(DataInputStream in, DataOutputStream out) throws Exception {

    Prompt prompt = new Prompt(in, out);

    int boardNo = 0;
    while (true) {
      try {
        boardNo = prompt.inputInt("삭제할 게시글 번호? ");
        break;
      } catch (Exception ex) {
        out.writeUTF("입력 값이 옳지 않습니다!");
      }
    }

    if (boardDao.delete(boardNo) == 1) {
      out.writeUTF("삭제하였습니다.");
    } else {
      out.writeUTF("해당 번호의 게시글이 없습니다!");
    }
  }

  private void onUpdate(DataInputStream in, DataOutputStream out) throws Exception {

    Prompt prompt = new Prompt(in, out);

    int boardNo = 0;
    while (true) {
      try {
        boardNo = prompt.inputInt("변경할 게시글 번호? ");
        break;
      } catch (Throwable ex) {
        out.writeUTF("입력 값이 옳지 않습니다!");
      }
    }

    Board board = boardDao.findByNo(boardNo);
    if (board == null) {
      out.writeUTF("해당 번호의 게시글이 없습니다!");
      return;
    }

    board.title = prompt.inputString("제목?(" + board.title + ") ");
    board.content = prompt.inputString(String.format("내용?(%s) ", board.content));

    String input = prompt.inputString("변경하시겠습니까?(y/n) ");

    if (input.equals("y")) {
      if (boardDao.update(board) == 1) {
        out.writeUTF("변경했습니다.");
      } else {
        out.writeUTF("변경 실패입니다!");
      }

    } else {
      out.writeUTF("변경 취소했습니다.");
    }
  }
}




