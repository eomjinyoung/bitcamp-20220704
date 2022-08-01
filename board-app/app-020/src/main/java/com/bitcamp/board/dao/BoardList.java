package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Board;
import com.bitcamp.util.LinkedList;

// 게시글 목록을 관리하는 역할
//
public class BoardList extends LinkedList {

  private int boardNo = 0;

  @Override
  public void append(Object e) {
    Board board = (Board) e;
    board.no = nextNo();
    super.append(e);
  }

  @Override
  public Board retrieve(int boardNo) {
    for (int i = 0; i < length(); i++) {
      Board board = (Board) super.retrieve(i);
      if (board.no == boardNo) {
        return board;
      }
    }
    return null;
  }

  @Override
  public Object delete(int boardNo) {
    for (int i = 0; i < length(); i++) {
      Board board = (Board) super.retrieve(i);
      if (board.no == boardNo) {
        return super.delete(i);
      }
    }

    return null;
  }

  private int nextNo() {
    return ++boardNo;
  }
}














