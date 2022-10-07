package com.bitcamp.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 페이지 컨트롤러 사용 규칙
public interface Controller {
  String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
