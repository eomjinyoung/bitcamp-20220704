package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Member;
import com.bitcamp.util.ObjectList;

// 회원 목록을 관리하는 역할
//
public class MemberList extends ObjectList {

  // 수퍼 클래스의 get() 메서드를 호출했을 때 예외가 발생하면,
  // 서브 클래스의 get() 메서드에서 처리할 상황이 아니다.
  // 서브 클래스의 get()을 호출한 쪽에 보고하는 것이 더 낫다.
  // 이럴경우 try ~ catch ~ 를 쓰지 말고 메서드 선언부에 발생되는 예외를 표시하라!
  public Member get(String email) throws Throwable {
    for (int i = 0; i < size(); i++) {
      Member member = (Member) get(i);
      if (member.email.equals(email)) {
        return member;
      }
    }
    return null;
  }

  // 수퍼 클래스의 remove() 메서드를 호출했을 때 예외가 발생하면,
  // 서브 클래스의 remove() 메서드에서 처리할 상황이 아니다.
  // 서브 클래스의 remove()를 호출한 쪽에 보고하는 것이 더 낫다.
  // 이럴경우 try ~ catch ~ 를 쓰지 말고 메서드 선언부에 발생되는 예외를 표시하라!
  public boolean remove(String email) throws Throwable {
    for (int i = 0; i < size(); i++) {
      Member member = (Member) get(i);
      if (member.email.equals(email)) {
        return remove(i);
      }
    }
    return false;
  }
}














