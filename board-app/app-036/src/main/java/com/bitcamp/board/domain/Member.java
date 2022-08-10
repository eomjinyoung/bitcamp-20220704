package com.bitcamp.board.domain;

import java.io.Serializable;

public class Member implements Serializable {
  private static final long serialVersionUID = 1L;

  public int no;
  public String name;
  public String email;
  public String password;
  public long createdDate;
}
