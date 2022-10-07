package com.bitcamp.transaction;

import java.sql.Connection;

public class TransactionStatus {
  Connection con;

  public TransactionStatus(Connection con) {
    this.con = con;
  }

  public Connection get() {
    return this.con;
  }
}
