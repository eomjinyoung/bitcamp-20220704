package com.bitcamp.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;

// 사용자 요청을 다룰 객체의 사용법을 정의한다.
//
public interface Handler {
  // 핸들러가 클라이언트와 통신할 수 있도록 입출력 스트림을 파라미터로 전달한다.
  void execute(DataInputStream in, DataOutputStream out) throws Exception;
}
