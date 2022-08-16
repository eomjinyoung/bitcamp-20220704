package com.bitcamp.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;

// 사용자 요청을 다룰 객체의 사용법을 정의한다.
//
public interface Servlet {
  void service(DataInputStream in, DataOutputStream out);
}
