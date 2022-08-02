package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Board;
import com.bitcamp.util.LinkedList;
import com.bitcamp.util.List;

// 게시글 목록을 관리하는 역할
//
public class BoardDao {

  // List 인터페이스의 레퍼런스인 list 변수는
  // List 규격에 따라 만든 객체 주소를 담을 수 있다.
  //
  List list = new LinkedList();

  private int boardNo = 0;

  public void insert(Object e) {

    // 게시글 객체를 적절하게 준비한 다음
    Board board = (Board) e;
    board.no = nextNo();

    // List 규격에 따라 만든 객체를 사용하여 목록에 추가한다.
    // => 메서드를 호출할 때는 List 규격에 따라 호출한다.
    list.add(e);
  }

  public Board findByNo(int boardNo) {

    for (int i = 0; i < list.size(); i++) {
      Board board = (Board) list.get(i);
      if (board.no == boardNo) {
        return board;
      }
    }

    return null;
  }

  public boolean delete(int boardNo) {

    for (int i = 0; i < list.size(); i++) {
      Board board = (Board) list.get(i);
      if (board.no == boardNo) {
        return list.remove(i) != null;
      }
    }

    return false;
  }

  public Board[] findAll() {

    Object[] arr = list.toArray();
    Board[] boards = new Board[arr.length];

    for (int i = 0; i < arr.length; i++) {
      boards[i] = (Board) arr[i];
    }
    return boards;
  }

  private int nextNo() {
    return ++boardNo;
  }
}














