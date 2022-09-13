/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.util.List;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;
import com.bitcamp.handler.AbstractHandler;
import com.bitcamp.util.Prompt;

public class BoardHandler extends AbstractHandler {

  private BoardDao boardDao;

  public BoardHandler(BoardDao boardDao) {

    // 수퍼 클래스의 생성자를 호출할 때 메뉴 목록을 전달한다.
    super(new String[] {"목록", "상세보기", "등록", "삭제", "변경"});

    this.boardDao = boardDao;
  }

  @Override
  public void service(int menuNo) {
    try {
      switch (menuNo) {
        case 1: this.onList(); break;
        case 2: this.onDetail(); break;
        case 3: this.onInput(); break;
        case 4: this.onDelete(); break;
        case 5: this.onUpdate(); break;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void onList() throws Exception {
    List<Board> boards = boardDao.findAll();

    System.out.println("번호 제목 조회수 작성자 등록일");
    for (Board board : boards) {
      System.out.printf("%d\t%s\t%d\t%d\t%s\n",
          board.no, board.title, board.viewCount, board.memberNo, board.createdDate);
    }
  }

  private void onDetail() throws Exception {
    int boardNo = 0;
    while (true) {
      try {
        boardNo = Prompt.inputInt("조회할 게시글 번호? ");
        break;
      } catch (Exception ex) {
        System.out.println("입력 값이 옳지 않습니다!");
      }
    }

    Board board = boardDao.findByNo(boardNo);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.printf("작성자: %d\n", board.memberNo);
    System.out.printf("등록일: %s\n", board.createdDate);
  }

  private void onInput() throws Exception {
    Board board = new Board();

    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.memberNo = Prompt.inputInt("작성자? ");

    boardDao.insert(board);
    System.out.println("게시글을 등록했습니다.");
  }

  private void onDelete() throws Exception {
    int boardNo = 0;
    while (true) {
      try {
        boardNo = Prompt.inputInt("삭제할 게시글 번호? ");
        break;
      } catch (Exception ex) {
        System.out.println("입력 값이 옳지 않습니다!");
      }
    }

    if (boardDao.delete(boardNo) == 1) {
      System.out.println("삭제하였습니다.");
    } else {
      System.out.println("해당 번호의 게시글이 없습니다!");
    }
  }

  private void onUpdate() throws Exception {
    int boardNo = 0;
    while (true) {
      try {
        boardNo = Prompt.inputInt("변경할 게시글 번호? ");
        break;
      } catch (Throwable ex) {
        System.out.println("입력 값이 옳지 않습니다!");
      }
    }

    Board board = boardDao.findByNo(boardNo);
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    board.title = Prompt.inputString("제목?(" + board.title + ") ");
    board.content = Prompt.inputString(String.format("내용?(%s) ", board.content));

    String input = Prompt.inputString("변경하시겠습니까?(y/n) ");

    if (input.equals("y")) {
      if (boardDao.update(board) == 1) {
        System.out.println("변경했습니다.");
      } else {
        System.out.println("변경 실패입니다!");
      }

    } else {
      System.out.println("변경 취소했습니다.");
    }
  }
}




