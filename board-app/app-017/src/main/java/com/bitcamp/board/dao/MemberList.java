package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Member;
import com.bitcamp.util.ObjectList;

// 회원 목록을 관리하는 역할
//
public class MemberList extends ObjectList {

  // 인덱스 대신 이메일로 회원 데이터를 찾을 수 있도록 
  // 메서드를 추가한다. 
  // 기존의 메서드와 같은 이름으로 지어서 
  // 메서드 호출할 때 일관되게 사용할 수 있다.
  // => 오버로딩(overloading)
  public Member get(String email) {
    for (int i = 0; i < size(); i++) {
      Member member = (Member) get(i);
      if (member.email.equals(email)) {
        return member;
      }
    }
    return null;
  }


  // 인덱스 대신 이메일로 회원 데이터를 찾아 삭제하는 메서드.
  // 수퍼 클래스로부터 상속 받은 메서드와 같은 일을 하며
  // 메서드 이름도 같다. 오버로딩!
  public boolean remove(String email) {
    for (int i = 0; i < size(); i++) {
      Member member = (Member) get(i);
      if (member.email.equals(email)) {
        return remove(i);
      }
    }
    return false;
  }
}














