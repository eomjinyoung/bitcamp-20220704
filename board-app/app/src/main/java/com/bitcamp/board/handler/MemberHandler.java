/*
 * 회원 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.util.Date;
import com.bitcamp.board.App;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;
import com.bitcamp.handler.Handler;
import com.bitcamp.util.Prompt;

public class MemberHandler implements Handler {

  private MemberDao memberDao = new MemberDao();

  // 모든 인스턴스가 같은 서브 메뉴를 가지기 때문에
  // 메뉴명을 저장할 배열은 클래스 필드로 준비한다.
  private static String[] menus = {"목록", "상세보기", "등록", "삭제", "변경"};

  static void printMenus(String[] menus) {
    for (int i = 0; i < menus.length; i++) {
      System.out.printf("  %d: %s\n", i + 1, menus[i]);
    }
  }

  public void execute() {
    while (true) {
      System.out.printf("%s:\n", App.breadcrumbMenu);
      printMenus(menus);
      System.out.println();

      try {
        int menuNo = Prompt.inputInt("메뉴를 선택하세요[1..5](0: 이전) ");

        if (menuNo < 0 || menuNo > menus.length) {
          System.out.println("메뉴 번호가 옳지 않습니다!");
          continue; // while 문의 조건 검사로 보낸다.

        } else if (menuNo == 0) {
          return; // 메인 메뉴로 돌아간다.
        }

        // 메뉴에 진입할 때 breadcrumb 메뉴바에 그 메뉴를 등록한다.
        App.breadcrumbMenu.push(menus[menuNo - 1]);

        displayHeadline();

        // 서브 메뉴의 제목을 출력한다.
        System.out.printf("%s:\n", App.breadcrumbMenu);

        switch (menuNo) {
          case 1: this.onList(); break;
          case 2: this.onDetail(); break;
          case 3: this.onInput(); break;
          case 4: this.onDelete(); break;
          case 5: this.onUpdate(); break;
        }

        displayBlankLine();

        App.breadcrumbMenu.pop();

      } catch (Exception ex) {
        System.out.printf("예외 발생: %s\n", ex.getMessage());
      }
    } // 게시판 while
  }

  private static void displayHeadline() {
    System.out.println("=========================================");
  }

  private static void displayBlankLine() {
    System.out.println(); 
  }

  private void onList() {
    System.out.println("이메일 이름");

    Member[] members = this.memberDao.findAll();

    for (Member member : members) {
      System.out.printf("%s\t%s\n",
          member.email, member.name);
    }

  }

  private void onDetail() {
    String email = Prompt.inputString("조회할 회원 이메일? ");

    Member member = this.memberDao.findByEmail(email);

    if (member == null) {
      System.out.println("해당 이메일의 회원이 없습니다!");
      return;
    }

    System.out.printf("이름: %s\n", member.name);
    System.out.printf("이메일: %s\n", member.email);
    Date date = new Date(member.createdDate);
    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);
  }

  private void onInput() {
    Member member = new Member();

    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.createdDate = System.currentTimeMillis();

    this.memberDao.insert(member);

    System.out.println("회워을 등록했습니다.");
  }

  private void onDelete() {
    String email = Prompt.inputString("삭제할 회원 이메일? ");

    if (memberDao.delete(email)) {
      System.out.println("삭제하였습니다.");
    } else {
      System.out.println("해당 이메일의 회원이 없습니다!");
    }
  }

  private void onUpdate() {
    String email = Prompt.inputString("변경할 회원 이메일? ");

    Member member = this.memberDao.findByEmail(email);

    if (member == null) {
      System.out.println("해당 이메일의 회원이 없습니다!");
      return;
    }

    String newName = Prompt.inputString("이름?(" + member.name + ") ");
    String newEmail = Prompt.inputString(String.format("이메일?(%s) ", member.email));

    String input = Prompt.inputString("변경하시겠습니까?(y/n) ");
    if (input.equals("y")) {
      member.name = newName;
      member.email = newEmail;
      System.out.println("변경했습니다.");
    } else {
      System.out.println("변경 취소했습니다.");
    }
  }
}




