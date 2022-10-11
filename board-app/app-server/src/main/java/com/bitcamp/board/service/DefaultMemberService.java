package com.bitcamp.board.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;

@Service // 서비스 역할을 수행하는 객체에 붙이는 애노테이션
public class DefaultMemberService implements MemberService {
  MemberDao memberDao;

  public DefaultMemberService(MemberDao memberDao) {
    System.out.println("DefaultMemberService() 호출됨!");
    this.memberDao = memberDao;
  }

  @Override
  public void add(Member member) throws Exception {
    memberDao.insert(member);
  }

  @Override
  public boolean update(Member member) throws Exception {
    return memberDao.update(member) > 0;
  }

  @Override
  public Member get(int no) throws Exception {
    return memberDao.findByNo(no);
  }

  @Override
  public Member get(String email, String password) throws Exception {
    return memberDao.findByEmailPassword(email, password);
  }

  @Override
  public boolean delete(int no) throws Exception {
    return memberDao.delete(no) > 0;
  }

  @Override
  public List<Member> list() throws Exception {
    return memberDao.findAll();
  }
}








