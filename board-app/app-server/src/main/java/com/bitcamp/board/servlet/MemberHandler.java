/*
 * 회원 메뉴 처리 클래스
 */
package com.bitcamp.board.servlet;

import java.util.Date;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;
import com.bitcamp.servlet.AbstractServlet;
import com.bitcamp.util.Prompt;

public class MemberHandler extends AbstractServlet {

  private MemberDao memberDao;

  public MemberHandler(String filename) {
    super(new String[] {"목록", "상세보기", "등록", "삭제", "변경"});
    memberDao = new MemberDao(filename);

    try {
      memberDao.load();
    } catch (Exception e) {
      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filename);
      //      e.printStackTrace();
    }
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

  private void onInput() throws Exception {
    Member member = new Member();

    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.createdDate = System.currentTimeMillis();

    this.memberDao.insert(member);
    memberDao.save();

    System.out.println("회워을 등록했습니다.");
  }

  private void onDelete() throws Exception {
    String email = Prompt.inputString("삭제할 회원 이메일? ");

    if (memberDao.delete(email)) {
      memberDao.save();
      System.out.println("삭제하였습니다.");
    } else {
      System.out.println("해당 이메일의 회원이 없습니다!");
    }
  }

  private void onUpdate() throws Exception {
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
      memberDao.save();
      System.out.println("변경했습니다.");
    } else {
      System.out.println("변경 취소했습니다.");
    }
  }
}




