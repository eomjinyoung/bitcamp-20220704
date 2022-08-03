# 028. 인터페이스를 이용하여 핸들러의 사용법을 규격화 하기


## 작업 내용

### 1단계 - 핸들러의 사용법을 인터페이스로 규격화 한다.

- com.bitcamp.handler.Handler 인터페이스 생성
  - 핸들러 사용 규칙을 정의한다.

### 2단계 - 핸들러 사용 규칙에 따라 BoardHandler와 MemberHandler를 구현한다.

- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - Handler 인터페이스를 구현한다.
- com.bitcamp.board.handler.MemberHandler 클래스 변경
  - Handler 인터페이스를 구현한다.  

### 3단계 - Handler 규칙에 따라 핸들러 객체를 실행한다.

- com.bitcamp.board.App 클래스 변경
  - Handler 객체를 레퍼런스 배열로 관리한다.
  - 핸들러를 실행할 때 규칙에 따라 메서드를 호출한다. switch 문 제거!