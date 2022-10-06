package com.bitcamp.transaction;

import java.sql.Connection;
import com.bitcamp.sql.DataSource;

public class TransactionManager {
  DataSource ds;

  public TransactionManager(DataSource ds) {
    this.ds = ds;
  }

  public TransactionStatus getTransaction() throws Exception {
    // 현재 스레드에서 사용할 DB 커넥션 객체를 꺼낸다.
    Connection con = ds.getConnection();

    // 트랜잭션을 수행할 수 있도록 수동 커밋 상태로 변경한다.
    con.setAutoCommit(false);

    // 트랜잭션을 수행하는 동안 사용할 DB 커넥션 객체를 보관소에 담아서 리턴한다.
    return new TransactionStatus(con);
  }

  public void commit(TransactionStatus status) {
    try {
      // 트랜잭션 보관소에 저장된 DB 커넥션을 사용하여 커밋을 수행한다.
      status.get().commit();
    } catch (Exception e) {
      // 커밋하다가 발생한 예외는 무시한다.
    } finally {
      try {
        status.get().setAutoCommit(true);
      } catch (Exception e) {
        // 자동 커밋 상태로 설정하는 중에 발생한 오류는 무시한다.
      }
    }
  }

  public void rollback(TransactionStatus status) {
    try {
      // 트랜잭션 보관소에 저장된 DB 커넥션을 사용하여 롤백을 수행한다.
      status.get().rollback();
    } catch (Exception e) {
      // 롤백하다가 발생한 예외는 무시한다.
    } finally {
      try {
        status.get().setAutoCommit(true);
      } catch (Exception e) {
        // 자동 커밋 상태로 설정하는 중에 발생한 오류는 무시한다.
      }
    }
  }
}
