/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import com.bitcamp.handler.AbstractHandler;

public class BoardHandler extends AbstractHandler {

  private String dataName;
  private DataInputStream in;
  private DataOutputStream out;

  public BoardHandler(String dataName, DataInputStream in, DataOutputStream out) {

    // 수퍼 클래스의 생성자를 호출할 때 메뉴 목록을 전달한다.
    super(new String[] {"목록", "상세보기", "등록", "삭제", "변경"});

    this.dataName = dataName;
    this.in = in;
    this.out = out;
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

  private void onList() {
    try {
      out.writeUTF(dataName);
      out.writeUTF("findAll");
      System.out.println(in.readUTF());

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    //    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    //
    //    System.out.println("번호 제목 조회수 작성자 등록일");
    //
    //    Board[] boards = this.boardDao.findAll();
    //
    //    for (Board board : boards) {
    //      Date date = new Date(board.createdDate);
    //      String dateStr = formatter.format(date); 
    //      System.out.printf("%d\t%s\t%d\t%s\t%s\n",
    //          board.no, board.title, board.viewCount, board.writer, dateStr);
    //    }

  }

  private void onDetail() {
    try {
      out.writeUTF(dataName);
      out.writeUTF("findByNo");
      System.out.println(in.readUTF());

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    //    int boardNo = 0;
    //    while (true) {
    //      try {
    //        boardNo = Prompt.inputInt("조회할 게시글 번호? ");
    //        break;
    //      } catch (Exception ex) {
    //        System.out.println("입력 값이 옳지 않습니다!");
    //      }
    //    }
    //
    //    // 해당 번호의 게시글이 몇 번 배열에 들어 있는지 알아내기
    //    Board board = this.boardDao.findByNo(boardNo);
    //
    //    // 사용자가 입력한 번호에 해당하는 게시글을 못 찾았다면
    //    if (board == null) {
    //      System.out.println("해당 번호의 게시글이 없습니다!");
    //      return;
    //    }
    //
    //    System.out.printf("번호: %d\n", board.no);
    //    System.out.printf("제목: %s\n", board.title);
    //    System.out.printf("내용: %s\n", board.content);
    //    System.out.printf("조회수: %d\n", board.viewCount);
    //    System.out.printf("작성자: %s\n", board.writer);
    //    Date date = new Date(board.createdDate);
    //    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);

  }

  private void onInput() throws Exception {
    try {
      out.writeUTF(dataName);
      out.writeUTF("insert");
      System.out.println(in.readUTF());

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    //    Board board = new Board();
    //
    //    board.title = Prompt.inputString("제목? ");
    //    board.content = Prompt.inputString("내용? ");
    //    board.writer = Prompt.inputString("작성자? ");
    //    board.password = Prompt.inputString("암호? ");
    //    board.viewCount = 0;
    //    board.createdDate = System.currentTimeMillis();
    //
    //    this.boardDao.insert(board);
    //    this.boardDao.save();
    //
    //    System.out.println("게시글을 등록했습니다.");
  }

  private void onDelete() throws Exception {
    try {
      out.writeUTF(dataName);
      out.writeUTF("delete");
      System.out.println(in.readUTF());

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    //    int boardNo = 0;
    //    while (true) {
    //      try {
    //        boardNo = Prompt.inputInt("삭제할 게시글 번호? ");
    //        break;
    //      } catch (Exception ex) {
    //        System.out.println("입력 값이 옳지 않습니다!");
    //      }
    //    }
    //
    //    if (boardDao.delete(boardNo)) {
    //      this.boardDao.save();
    //      System.out.println("삭제하였습니다.");
    //    } else {
    //      System.out.println("해당 번호의 게시글이 없습니다!");
    //    }
  }

  private void onUpdate() throws Exception {
    try {
      out.writeUTF(dataName);
      out.writeUTF("update");
      System.out.println(in.readUTF());

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    //    int boardNo = 0;
    //    while (true) {
    //      try {
    //        boardNo = Prompt.inputInt("변경할 게시글 번호? ");
    //        break;
    //      } catch (Throwable ex) {
    //        System.out.println("입력 값이 옳지 않습니다!");
    //      }
    //    }
    //
    //    Board board = this.boardDao.findByNo(boardNo);
    //
    //    if (board == null) {
    //      System.out.println("해당 번호의 게시글이 없습니다!");
    //      return;
    //    }
    //
    //    String newTitle = Prompt.inputString("제목?(" + board.title + ") ");
    //    String newContent = Prompt.inputString(String.format("내용?(%s) ", board.content));
    //
    //    String input = Prompt.inputString("변경하시겠습니까?(y/n) ");
    //    if (input.equals("y")) {
    //      board.title = newTitle;
    //      board.content = newContent;
    //      this.boardDao.save();
    //      System.out.println("변경했습니다.");
    //    } else {
    //      System.out.println("변경 취소했습니다.");
    //    }
  }
}




