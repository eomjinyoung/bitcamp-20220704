/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.sql.Date;
import java.text.SimpleDateFormat;
import com.bitcamp.board.dao.BoardDaoProxy;
import com.bitcamp.board.domain.Board;
import com.bitcamp.handler.AbstractHandler;
import com.bitcamp.util.Prompt;

public class BoardHandler extends AbstractHandler {

  private BoardDaoProxy boardDao;

  public BoardHandler(String dataName, String ip, int port) {

    // 수퍼 클래스의 생성자를 호출할 때 메뉴 목록을 전달한다.
    super(new String[] {"목록", "상세보기", "등록", "삭제", "변경"});

    boardDao = new BoardDaoProxy(dataName, ip, port);
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
    Board[] boards = boardDao.findAll();

    if (boards == null) {
      System.out.println("목록을 가져오는데 실패했습니다!");
      return;
    }

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println("번호 제목 조회수 작성자 등록일");
    for (Board board : boards) {
      Date date = new Date(board.createdDate);
      String dateStr = formatter.format(date); 
      System.out.printf("%d\t%s\t%d\t%s\t%s\n",
          board.no, board.title, board.viewCount, board.writer, dateStr);
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
    System.out.printf("작성자: %s\n", board.writer);
    Date date = new Date(board.createdDate);
    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);
  }

  private void onInput() throws Exception {
    Board board = new Board();

    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.password = Prompt.inputString("암호? ");
    board.viewCount = 0;
    board.createdDate = System.currentTimeMillis();

    if (boardDao.insert(board)) {
      System.out.println("게시글을 등록했습니다.");
    } else {
      System.out.println("게시글 등록에 실패했습니다!");
    }
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

    if (boardDao.delete(boardNo)) {
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
      if (boardDao.update(board)) {
        System.out.println("변경했습니다.");
      } else {
        System.out.println("변경 실패입니다!");
      }

    } else {
      System.out.println("변경 취소했습니다.");
    }
  }
}




