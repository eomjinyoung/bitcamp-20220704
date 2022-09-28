package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.Board;

public interface BoardDao {

  int insert(Board board) throws Exception;

  Board findByNo(int no) throws Exception;

  int update(Board board) throws Exception;

  int delete(int no) throws Exception;

  List<Board> findAll() throws Exception;
}














