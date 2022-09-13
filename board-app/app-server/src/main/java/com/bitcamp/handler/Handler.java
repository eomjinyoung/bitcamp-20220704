package com.bitcamp.handler;

import java.io.PrintWriter;

// 사용자 요청을 다룰 객체의 사용법을 정의한다.
//
public interface Handler {
  // 클라이언트로 출력할 때 사용할 출력 스트림을 파라미터로 받는다.
  void execute(PrintWriter out) throws Exception;
}
