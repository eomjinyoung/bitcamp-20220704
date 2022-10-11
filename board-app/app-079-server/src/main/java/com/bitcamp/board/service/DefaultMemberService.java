package com.bitcamp.board.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;

@Component
//- 이 애노테이션을 붙이면 Spring IoC 컨테이너가 객체를 자동으로 생성할 것이다.
//- 객체의 이름을 명시하지 않으면 
//  클래스 이름(첫 알파벳은 소문자. 예: "defaultMemberService")을 사용하여 저장한다.
//- 생성자에 파라미터가 있다면 해당 타입의 객체를 찾아 생성자를 호출할 때 주입할 것이다.
//- 만약 생성자가 원하는 파라미터 값이 없다면 생성 예외가 발생한다.
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








