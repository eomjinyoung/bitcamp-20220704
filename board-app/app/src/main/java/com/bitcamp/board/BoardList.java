package com.bitcamp.board;

// 게시글 목록을 관리하는 역할
//
public class BoardList {

  static final int DEFAULT_SIZE = 3;

  int boardCount; 
  Board[] boards; 

  // 생성자
  BoardList() {
    this.boards = new Board[DEFAULT_SIZE];
  }

  BoardList(int initCapacity) {
    this.boards = new Board[initCapacity];
  }

  // 목록에 저장된 인스턴스를 꺼내서 리턴한다.
  Board[] toArray() {
    Board[] arr = new Board[this.boardCount];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = this.boards[i];
    }
    return arr;
  }
}














