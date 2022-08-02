package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Member;
import com.bitcamp.util.LinkedList;
import com.bitcamp.util.List;

// 회원 목록을 관리하는 역할
//
public class MemberDao {

  // MemberDao는 List 규격에 맞춰 생산한 객체를 사용할 것이다.
  // => ObjectList 클래스는 List 규격에 맞춰 메서드를 정의한 클래스다.
  // => 따라서 List 레퍼런스 변수에 그 주소를 저장할 수 있다. 
  List list = new LinkedList();

  public void insert(Member member) {
    list.add(member);
  }

  public Member findByEmail(String email) {
    for (int i = 0; i < list.size(); i++) {
      Member member = (Member) list.get(i);
      if (member.email.equals(email)) {
        return member;
      }
    }
    return null;
  }

  public boolean delete(String email) {
    for (int i = 0; i < list.size(); i++) {
      Member member = (Member) list.get(i);
      if (member.email.equals(email)) {
        return list.remove(i) != null;
      }
    }
    return false;
  }

  public Member[] findAll() {

    Object[] arr = list.toArray();
    Member[] members = new Member[arr.length];

    for (int i = 0; i < arr.length; i++) {
      members[i] = (Member) arr[i];
    }
    return members;
  }
}














