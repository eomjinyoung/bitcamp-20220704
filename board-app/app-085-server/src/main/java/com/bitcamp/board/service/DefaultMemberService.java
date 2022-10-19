package com.bitcamp.board.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;

@Service // 서비스 역할을 수행하는 객체에 붙이는 애노테이션
public class DefaultMemberService implements MemberService {

  @Autowired 
  PlatformTransactionManager txManager;

  @Autowired
  MemberDao memberDao;

  @Autowired
  BoardDao boardDao;


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
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = txManager.getTransaction(def);

    try {
      boardDao.deleteFilesByMemberBoards(no); // 회원이 작성한 게시글의 모든 첨부파일 삭제
      boardDao.deleteByMember(no); // 회원이 작성한 게시글 삭제
      boolean result = memberDao.delete(no) > 0; // 회원 삭제
      txManager.commit(status);
      return result;

    } catch (Exception e) {
      txManager.rollback(status);
      throw e;
    }
  }

  @Override
  public List<Member> list() throws Exception {
    return memberDao.findAll();
  }
}








