/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220704
 */
package com.bitcamp.board;

public class App02 {

  public static void main(String[] args) {
    welcome();

    loop: while (true) {

      // 메인 메뉴 출력
      System.out.println("메뉴:");
      System.out.println("  1: 게시판");
      System.out.println("  2: 독서록");
      System.out.println("  3: 방명록");
      System.out.println("  4: 공지사항");
      System.out.println();
      int mainMenuNo = Prompt.inputInt("메뉴를 선택하세요[1..4](0: 종료) ");

      switch (mainMenuNo) {
        case 0: break loop;
        case 1: // 게시판
          onBoardMenu();
          break;
        case 2: // 독서록
          break;
        case 3: // 방명록
          break;
        case 4: // 공지사항
          break;
        default: System.out.println("메뉴 번호가 옳지 않습니다!");
      } // switch


    } // while

    System.out.println("안녕히 가세요!");
    Prompt.close();
  } // main

  static void welcome() {
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();
  }

  static void displayLine() {
    System.out.println("=========================================");
  }

  static void displayBlankLine() {
    System.out.println(); // 메뉴를 처리한 후 빈 줄 출력
  }

  static void onBoardMenu() {
    while (true) {
      System.out.println("게시판:");
      System.out.println("  1: 목록");
      System.out.println("  2: 상세보기");
      System.out.println("  3: 등록");
      System.out.println("  4: 삭제");
      System.out.println("  5: 변경");
      System.out.println();

      int menuNo = Prompt.inputInt("메뉴를 선택하세요[1..5](0: 이전) ");
      displayLine();

      switch (menuNo) {
        case 0: return;
        case 1: BoardHandler.processList(); break;
        case 2: BoardHandler.processDetail(); break;
        case 3: BoardHandler.processInput(); break;
        case 4: BoardHandler.processDelete(); break;
        case 5: BoardHandler.processUpdate(); break;
        default: System.out.println("메뉴 번호가 옳지 않습니다!");
      }

      displayBlankLine();
    } // 게시판 while
  }
}







