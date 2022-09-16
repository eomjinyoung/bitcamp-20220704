package com.bitcamp.board.domain;

import java.sql.Date;

public class Board {

  public int no;
  public String title;
  public String content;
  public int memberNo;
  public String password;
  public int viewCount;
  public Date createdDate;

  @Override
  public String toString() {
    return "Board [no=" + no + ", title=" + title + ", content=" + content + ", memberNo="
        + memberNo + ", password=" + password + ", viewCount=" + viewCount + ", createdDate="
        + createdDate + "]";
  }
}







