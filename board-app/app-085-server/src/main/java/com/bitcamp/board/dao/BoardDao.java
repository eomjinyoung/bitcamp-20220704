package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;

public interface BoardDao {

  int insert(Board board) throws Exception;

  Board findByNo1(int no) throws Exception;

  Board findByNo2(int no) throws Exception;

  Board findByNo3(int no) throws Exception;

  int update(Board board) throws Exception;

  int delete(int no) throws Exception;

  int deleteByMember(int memberNo) throws Exception;

  List<Board> findAll() throws Exception;

  int insertFiles(Board board) throws Exception;

  AttachedFile findFileByNo(int fileNo) throws Exception;

  List<AttachedFile> findFilesByBoard(int boardNo) throws Exception;

  int deleteFile(int fileNo) throws Exception;

  int deleteFiles(int boardNo) throws Exception;

  int deleteFilesByMemberBoards(int memberNo) throws Exception;
}














