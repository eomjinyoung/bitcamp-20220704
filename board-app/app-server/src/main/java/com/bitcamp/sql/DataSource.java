package com.bitcamp.sql;

import java.sql.Connection;
import java.sql.DriverManager;

// 스레드 전용 DB 커넥션을 제공하는 일을 한다.
//
public class DataSource {

  String jdbcUrl;
  String username;
  String password;

  // 스레드 전용 DB 커넥션 보관소
  ThreadLocal<Connection> conStore = new ThreadLocal<>();

  public DataSource(String driver, String jdbcUrl, String username, String password) throws Exception {
    // JDBC Driver 클래스 로딩하기
    Class.forName(driver);

    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  public Connection getConnection() throws Exception {
    Thread currThread = Thread.currentThread();
    System.out.printf("%s=> getConnection() 호출\n", currThread.getName());

    // 현재 스레드의 보관소에서 DB 커넥션 객체를 꺼낸다.
    Connection con = conStore.get();
    if (con == null) { // 현재 스레드 보관소에 커넥션 객체가 없다면,  
      con = DriverManager.getConnection(jdbcUrl, username, password); // 새로 생성
      conStore.set(con); // 새로 만든 DB 커넥션 객체를 다음에 다시 사용할 수 있도록 보관한다.
      System.out.printf("%s=> Connection 객체 생성\n", currThread.getName());
    }
    return con;
  }

}






