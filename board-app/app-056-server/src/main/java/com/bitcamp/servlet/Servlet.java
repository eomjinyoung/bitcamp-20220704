package com.bitcamp.servlet;

import java.io.PrintWriter;
import java.util.Map;

// 요청을 처리하는 객체의 사용법을 정의한다.
//
public interface Servlet {

  // HTTP 클라이언트의 요청을 들어올 때 마다 해당 요청을 처리하는 객체에 대해 
  // 호출되는 메서드이다.
  void service(Map<String,String> paramMap, PrintWriter out) throws Exception;
}
