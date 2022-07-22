package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Member;

// 회원 목록을 관리하는 역할
//
public class MemberList extends ObjectList {

  private int no = 0;

  private int nextNo() {
    return ++no;
  }

  @Override
  public void add(Object obj) {
    Member member = (Member) obj;
    member.no = nextNo();
    super.add(obj);
  }

  @Override
  public Member get(int memberNo) {
    for (int i = 0; i < this.length; i++) {
      Member member = (Member) this.list[i];
      if (member.no == memberNo) {
        return member;
      }
    }
    return null;
  }

  @Override
  public boolean remove(int memberNo) {
    int index = -1;
    for (int i = 0; i < this.length; i++) {
      Member member = (Member) this.list[i];
      if (member.no == memberNo) {
        index = i;
        break;
      }
    }
    return super.remove(index);
  }
}














