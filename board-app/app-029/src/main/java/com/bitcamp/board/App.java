/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220704
 */
package com.bitcamp.board;

import com.bitcamp.board.handler.BoardHandler;
import com.bitcamp.board.handler.MemberHandler;
import com.bitcamp.handler.Handler;
import com.bitcamp.util.Prompt;
import com.bitcamp.util.Stack;

public class App {

  // breadcrumb 메뉴를 저장할 스택을 준비
  public static Stack breadcrumbMenu = new Stack();

  public static void main(String[] args) {
    welcome();

    // 핸들러를 담을 레퍼런스 배열을 준비한다.
    Handler[] handlers = new Handler[] {
        new BoardHandler(), // 게시판
        new BoardHandler(), // 독서록
        new BoardHandler(), // 방명록
        new BoardHandler(), // 공지사항
        new BoardHandler(), // 일기장
        new MemberHandler() // 회원
    };

    // "메인" 메뉴의 이름을 스택에 등록한다.
    breadcrumbMenu.push("메인");

    // 메뉴명을 저장할 배열을 준비한다.
    String[] menus = {"게시판", "독서록", "방명록", "공지사항", "일기장", "회원"};

    loop: while (true) {

      // 메인 메뉴 출력
      System.out.printf("%s:\n", breadcrumbMenu);

      printMenus(menus);

      System.out.println();

      try {
        int mainMenuNo = Prompt.inputInt("메뉴를 선택하세요[1..6](0: 종료) ");

        if (mainMenuNo < 0 || mainMenuNo > menus.length) {
          System.out.println("메뉴 번호가 옳지 않습니다!");
          continue; // while 문의 조건 검사로 보낸다.

        } else if (mainMenuNo == 0) {
          break loop;
        }

        // 메뉴에 진입할 때 breadcrumb 메뉴바에 그 메뉴를 등록한다.
        breadcrumbMenu.push(menus[mainMenuNo - 1]);

        // 메뉴 번호로 Handler 레퍼런스에 들어있는 객체를 찾아 실행한다.
        handlers[mainMenuNo - 1].execute();

        breadcrumbMenu.pop();

      } catch (Exception ex) {
        System.out.println("입력 값이 옳지 않습니다.");
      }


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

  static void printMenus(String[] menus) {
    for (int i = 0; i < menus.length; i++) {
      System.out.printf("  %d: %s\n", i + 1, menus[i]);
    }
  }
}







