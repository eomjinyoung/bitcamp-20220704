package com.bitcamp.board.dao;

import java.util.List;
import com.bitcamp.board.domain.Member;

public interface MemberDao {

  int insert(Member member) throws Exception;

  Member findByNo(int no) throws Exception;

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;

  List<Member> findAll() throws Exception;

  Member findByEmailPassword(String email, String password) throws Exception;
}














