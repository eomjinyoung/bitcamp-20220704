package com.bitcamp.board;

// 회원 목록을 관리하는 역할
//
public class MemberList {

  static final int DEFAULT_SIZE = 3;

  int memberCount; 
  Member[] members; 
  int no = 0;

  MemberList() {
    this.members = new Member[DEFAULT_SIZE];
  }

  MemberList(int initCapacity) {
    this.members = new Member[initCapacity];
  }

  Member[] toArray() {
    Member[] arr = new Member[this.memberCount];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = this.members[i];
    }
    return arr;
  }

  Member get(int memberNo) {
    for (int i = 0; i < this.memberCount; i++) {
      if (this.members[i].no == memberNo) {
        return this.members[i];
      }
    }
    return null;
  }

  void add(Member member) {
    if (this.memberCount == this.members.length) {
      grow();
    }
    member.no = nextNo();
    this.members[this.memberCount++] = member;
  }

  boolean remove(int memberNo) {
    int memberIndex = -1;
    for (int i = 0; i < this.memberCount; i++) {
      if (this.members[i].no == memberNo) {
        memberIndex = i;
        break;
      }
    }

    if (memberIndex == -1) {
      return false;
    }

    for (int i = memberIndex + 1; i < this.memberCount; i++) {
      this.members[i - 1] = this.members[i];
    }

    this.members[--this.memberCount] = null;

    return true;
  }

  void grow() {
    int newSize = this.members.length + (this.members.length >> 1);
    Member[] newArray = new Member[newSize];
    for (int i = 0; i < this.members.length; i++) {
      newArray[i] = this.members[i];
    }
    this.members = newArray;
  }

  int nextNo() {
    return ++no;
  }
}














