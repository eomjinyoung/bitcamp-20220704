package com.bitcamp.board.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;

@Service // 서비스 역할을 수행하는 객체에 붙이는 애노테이션
public class DefaultBoardService implements BoardService {

  @Autowired 
  PlatformTransactionManager txManager;

  @Autowired 
  @Qualifier("mybatisBoardDao") 
  BoardDao boardDao;

  @Override
  public void add(Board board) throws Exception {
    // 트랜잭션 동작 방법을 정의한다.
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = txManager.getTransaction(def);

    try {
      // 1) 게시글 등록
      if (boardDao.insert(board) == 0) {
        throw new Exception("게시글 등록 실패!");
      }

      // 2) 첨부파일 등록
      if (board.getAttachedFiles().size() > 0) {
        boardDao.insertFiles(board);
      }

      txManager.commit(status);

    } catch (Exception e) {
      txManager.rollback(status);
      throw e;
    }
  }

  @Override
  public boolean update(Board board) throws Exception {
    // 트랜잭션 동작 방법을 정의한다.
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = txManager.getTransaction(def);

    try {
      // 1) 게시글 변경
      if (boardDao.update(board) == 0) {
        return false;
      }
      // 2) 첨부파일 추가
      boardDao.insertFiles(board);

      txManager.commit(status);
      return true;

    } catch (Exception e) {
      txManager.rollback(status);
      throw e;
    }
  }

  @Override
  public Board get(int no) throws Exception {
    // 방법1:
    //    return boardDao.findByNo1(no); // select를 두 번 실행한다.

    // 방법2:
    //    Board board = boardDao.findByNo2(no);
    //    List<AttachedFile> attachedFiles = boardDao.findFilesByBoard(no);
    //    board.setAttachedFiles(attachedFiles);
    //    return board;

    // 방법3:
    return boardDao.findByNo3(no); // 첨부파일 데이터까지 조인하여 select를 한 번만 실행한다.
  }

  @Override
  public boolean delete(int no) throws Exception {
    // 트랜잭션 동작 방법을 정의한다.
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setName("tx1");
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    TransactionStatus status = txManager.getTransaction(def);

    try {
      // 1) 첨부파일 삭제
      boardDao.deleteFiles(no);

      // 2) 게시글 삭제
      boolean result = boardDao.delete(no) > 0;

      txManager.commit(status);
      return result;

    } catch (Exception e) {
      txManager.rollback(status);
      throw e;
    }
  }

  @Override
  public List<Board> list() throws Exception {
    return boardDao.findAll();
  }

  @Override
  public AttachedFile getAttachedFile(int fileNo) throws Exception {
    return boardDao.findFileByNo(fileNo);
  }

  @Override
  public boolean deleteAttachedFile(int fileNo) throws Exception {
    return boardDao.deleteFile(fileNo) > 0;
  }

}








