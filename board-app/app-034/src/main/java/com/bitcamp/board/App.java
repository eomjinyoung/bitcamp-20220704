/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220704
 */
package com.bitcamp.board;

import java.util.Stack;
import com.bitcamp.board.handler.BoardHandler;
import com.bitcamp.board.handler.MemberHandler;
import com.bitcamp.handler.Handler;
import com.bitcamp.util.Prompt;

public class App {

  // breadcrumb 메뉴를 저장할 스택을 준비
  public static Stack<String> breadcrumbMenu = new Stack<>();

  public static void main(String[] args) {
    try {
      welcome();

      // 핸들러를 담을 레퍼런스 배열을 준비한다.
      Handler[] handlers = new Handler[] {
          new BoardHandler("board.data"), // 게시판
          new BoardHandler("reading.data"), // 독서록
          new BoardHandler("visit.data"), // 방명록
          new BoardHandler("notice.data"), // 공지사항
          new BoardHandler("daily.data"), // 일기장
          new MemberHandler("member.data") // 회원
      };

      // "메인" 메뉴의 이름을 스택에 등록한다.
      breadcrumbMenu.push("메인");

      // 메뉴명을 저장할 배열을 준비한다.
      String[] menus = {"게시판", "독서록", "방명록", "공지사항", "일기장", "회원"};

      loop: while (true) {

        printTitle();
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

      Prompt.close();

    } catch (Exception e) {
      // 더이상 애플리케이션을 계속 실행할 수 없는 상황일 때,
      // (main() 메서드까지 예외 보고가 올라 왔다는 것은 계속 실행할 수 없는 상태라는 뜻이다)
      // 사용자에게 간단한 예외 메시지를 남기고
      // 필요하다면 로그 파일에 오류 기록을 남기고,
      // 실행을 종료한다.
      System.out.printf("실행 오류 발생! - %s:%s\n", 
          e.getClass().getName(), 
          e.getMessage() != null ? e.getMessage() : "");
    }

    System.out.println("안녕히 가세요!");
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

  protected static void printTitle() {
    StringBuilder builder = new StringBuilder();
    for (String title : App.breadcrumbMenu) {
      if (!builder.isEmpty()) {
        builder.append(" > ");
      }
      builder.append(title);
    }
    System.out.printf("%s:\n", builder.toString());
  }
}







