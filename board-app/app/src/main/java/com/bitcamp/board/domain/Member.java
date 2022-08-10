package com.bitcamp.board.domain;

import java.io.Serializable;

public class Member implements Serializable {
  private static final long serialVersionUID = 1L;

  public int no;
  public String name;
  public String email;
  public String password;
  public long createdDate;

  //GoF의 Factory Method 패턴
  // - 객체 생성 과정이 복잡할 때 별도의 메서드로 캡슐화 한다.
  // 
  public static Member create(String csv) {
    String[] values = csv.split(",");

    Member member = new Member();
    member.no = Integer.parseInt(values[0]);
    member.name = values[1];
    member.email = values[2];
    member.password = values[3];
    member.createdDate = Long.parseLong(values[4]);

    return member;
  }

  // GRASP 패턴의 Information Expert 패턴
  // => 정보 생성은 그 데이터를 갖고 있는 전문가에게 맡긴다.
  public String toCsv() {
    return String.format("%d,%s,%s,%s,%d",
        this.no,
        this.name,
        this.email,
        this.password,
        this.createdDate);
  }
}
