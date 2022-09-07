package com.bitcamp.board.domain;

import java.sql.Date;

public class Member {

  public int no;
  public String name;
  public String email;
  public String password;
  public Date createdDate;

  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password
        + ", createdDate=" + createdDate + "]";
  }
}
