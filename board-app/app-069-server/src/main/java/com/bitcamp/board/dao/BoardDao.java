package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;

public interface BoardDao {

  int insert(Board board) throws Exception;

  Board findByNo(int no) throws Exception;

  int update(Board board) throws Exception;

  int delete(int no) throws Exception;

  List<Board> findAll() throws Exception;

  int insertFiles(Board board) throws Exception;

  AttachedFile findFileByNo(int fileNo) throws Exception;

  int deleteFile(int fileNo) throws Exception;

  int deleteFiles(int boardNo) throws Exception;
}














