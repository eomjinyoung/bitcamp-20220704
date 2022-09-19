package com.bitcamp.servlet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.TYPE) // 애노테이션을 붙일 수 있는 범위를 설정
@Retention(value=RetentionPolicy.RUNTIME) // 애노테이션 값을 추출할 때를 지정
// 다음 애노테이션은 HTTP 요청을 처리하는 객체에 대해
// 경로를 설정할 때 사용한다.
public @interface WebServlet {
  String value(); // 애노테이션의 필수 속성을 설정
}
