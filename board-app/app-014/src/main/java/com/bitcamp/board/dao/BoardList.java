package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Board;

// 게시글 목록을 관리하는 역할
//
public class BoardList {

  private static final int DEFAULT_SIZE = 3;

  private int boardCount; 
  private Board[] boards; 
  private int no = 0;

  // 생성자
  public BoardList() {
    this.boards = new Board[DEFAULT_SIZE];
  }

  public BoardList(int initCapacity) {
    this.boards = new Board[initCapacity];
  }

  // 목록에 저장된 인스턴스를 꺼내서 리턴한다.
  public Board[] toArray() {
    Board[] arr = new Board[this.boardCount];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = this.boards[i];
    }
    return arr;
  }

  // 게시글 번호에 해당하는 Board 인스턴스를 찾아 리턴한다.
  public Board get(int boardNo) {
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == boardNo) {
        return this.boards[i];
      }
    }
    return null;
  }

  // Board 인스턴스를 배열에 저장한다.
  public void add(Board board) {
    if (this.boardCount == this.boards.length) {
      grow();
    }
    board.no = nextNo();
    this.boards[this.boardCount++] = board;
  }

  public boolean remove(int boardNo) {
    int boardIndex = -1;
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == boardNo) {
        boardIndex = i;
        break;
      }
    }

    if (boardIndex == -1) {
      return false;
    }

    // 삭제할 항목의 다음 항목을 앞으로 당긴다.
    for (int i = boardIndex + 1; i < this.boardCount; i++) {
      this.boards[i - 1] = this.boards[i];
    }

    // 게시글 개수를 한 개 줄인 후 
    // 맨 뒤의 있던 항목의 주소를 0으로 설정한다.
    this.boards[--this.boardCount] = null;

    return true;
  }

  private void grow() {
    int newSize = this.boards.length + (this.boards.length >> 1);
    Board[] newArray = new Board[newSize];
    for (int i = 0; i < this.boards.length; i++) {
      newArray[i] = this.boards[i];
    }
    this.boards = newArray;
  }

  private int nextNo() {
    return ++no;
  }
}














