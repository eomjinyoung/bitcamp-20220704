/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220704
 */
package com.bitcamp.board;

public class App {
  
  static java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

  public static void main(String[] args) {
    welcome();
    loop: while (true) {
      displayMenu();
      int menuNo = promptMenu();
      displayLine();

      switch (menuNo) {
        case 0: break loop;
        case 1: BoardHandler.processList(); break;
        case 2: BoardHandler.processDetail(); break;
        case 3: BoardHandler.processInput(); break;
        default: System.out.println("메뉴 번호가 옳지 않습니다!");
      }

      displayBlankLine();
    } // while

    System.out.println("안녕히 가세요!");
    keyboardInput.close();
  } // main

  static void welcome() {
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();
  }

  static void displayMenu() {
    System.out.println("메뉴:");
    System.out.println("  1: 게시글 목록");
    System.out.println("  2: 게시글 상세보기");
    System.out.println("  3: 게시글 등록");
    System.out.println();
    System.out.print("메뉴를 선택하세요[1..3](0: 종료) ");
  }

  static void displayLine() {
    System.out.println("=========================================");
  }

  // 메서드를 통해 특정 코드의 복잡함을 감출 수 있다. ==> encapsulation(캡슐화)
  static int promptMenu() {
    // 사용자로부터 메뉴 번호를 입력 받기
    // 방법1:
    /*
    String input = keyboardInput.nextLine();
    return Integer.parseInt(input);
    */

    // 방법2:
    int menuNo = keyboardInput.nextInt();
    keyboardInput.nextLine(); // 입력한 숫자 뒤에 남아 있는 줄바꿈 코드 제거
    return menuNo;
  }

  static void displayBlankLine() {
    System.out.println(); // 메뉴를 처리한 후 빈 줄 출력
  }
}
