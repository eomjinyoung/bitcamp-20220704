/*
 * 회원 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;
import com.bitcamp.handler.AbstractHandler;
import com.bitcamp.util.Prompt;

public class MemberHandler extends AbstractHandler {

  private MemberDao memberDao;

  public MemberHandler(MemberDao memberDao) {
    super(new String[] {"목록", "상세보기", "등록", "삭제", "변경"});

    this.memberDao = memberDao;
  }

  @Override
  public void service(int menuNo, DataInputStream in, DataOutputStream out) {
    try {
      switch (menuNo) {
        case 1: this.onList(in, out); break;
        case 2: this.onDetail(in, out); break;
        case 3: this.onInput(in, out); break;
        case 4: this.onDelete(in, out); break;
        case 5: this.onUpdate(in, out); break;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void onList(DataInputStream in, DataOutputStream out) throws Exception {
    try (StringWriter strOut = new StringWriter();
        PrintWriter tempOut = new PrintWriter(strOut)) {

      List<Member> members = memberDao.findAll();

      tempOut.println("번호\t이름\t이메일");

      for (Member member : members) {
        tempOut.printf("%d\t%s\t%s\n",
            member.no, member.name, member.email);
      }

      out.writeUTF(strOut.toString());
    }
  }

  private void onDetail(DataInputStream in, DataOutputStream out) throws Exception {
    Prompt prompt = new Prompt(in, out);

    int no = prompt.inputInt("조회할 회원 번호? ");

    Member member = memberDao.findByNo(no);

    if (member == null) {
      out.writeUTF("해당 번호의 회원이 없습니다!");
      return;
    }

    try (StringWriter strOut = new StringWriter();
        PrintWriter tempOut = new PrintWriter(strOut)) {

      tempOut.printf("이름: %s\n", member.name);
      tempOut.printf("이메일: %s\n", member.email);
      tempOut.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", member.createdDate);
      out.writeUTF(strOut.toString());
    }
  }

  private void onInput(DataInputStream in, DataOutputStream out) throws Exception {
    Prompt prompt = new Prompt(in, out);
    Member member = new Member();

    member.name = prompt.inputString("이름? ");
    member.email = prompt.inputString("이메일? ");
    member.password = prompt.inputString("암호? ");

    memberDao.insert(member);
    out.writeUTF("회원을 등록했습니다.");
  }

  private void onDelete(DataInputStream in, DataOutputStream out) throws Exception {
    Prompt prompt = new Prompt(in, out);
    int no = prompt.inputInt("삭제할 회원 번호? ");

    if (memberDao.delete(no) == 1) {
      out.writeUTF("삭제하였습니다.");
    } else {
      out.writeUTF("해당 번호의 회원이 없습니다!");
    }
  }

  private void onUpdate(DataInputStream in, DataOutputStream out) throws Exception {
    Prompt prompt = new Prompt(in, out);
    int no = prompt.inputInt("변경할 회원 번호? ");

    Member member = memberDao.findByNo(no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다!");
      return;
    }

    member.name = prompt.inputString("이름?(" + member.name + ") ");
    member.email = prompt.inputString("이메일?(" + member.email + ") ");
    member.password = prompt.inputString("암호?");

    String input = prompt.inputString("변경하시겠습니까?(y/n) ");

    if (input.equals("y")) {
      if (memberDao.update(member) == 1) {
        out.writeUTF("변경했습니다.");
      } else {
        out.writeUTF("변경 실패입니다!");
      }

    } else {
      out.writeUTF("변경 취소했습니다.");
    }
  }
}




