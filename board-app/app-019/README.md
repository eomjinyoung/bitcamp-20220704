# 019. 사용자 정의 예외를 다루는 방법 

## 작업 내용

### 1단계 - ObjectList 에서 발생하는 예외 상황을 표현할 사용자 정의 예외를 만든다.

- com.bitcamp.util.ListException 클래스 생성
  - get()과 remove()에서 예외가 발생하면 이 클래스의 객체를 만들어 던진다.

### 2단계 - 사용자 정의 예외(ListException)를 적용한다.

- com.bitcamp.util.ObjectList 클래스 변경
  - get(), remove() 메서드에서 예외를 발생시킬 때 ListException을 던진다.
- com.bitcamp.board.dao.BoardList 클래스 변경
  - ObjectList 변경에 맞춰 예외 코드를 변경한다.
- com.bitcamp.board.dao.MemberList 클래스 변경
  - ObjectList 변경에 맞춰 예외 코드를 변경한다.

### 3단계 - XxxList 를 사용하는 XxxHandler 클래스를 변경한다.

- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - BoardList 변경에 맞춰 예외 코드를 변경한다.
- com.bitcamp.board.handler.MemberHandler 클래스 변경
  - MemberList 변경에 맞춰 예외 코드를 변경한다.
- com.bitcamp.board.App 클래스 변경
  - Throwable 대신 애플리케이션 예외 Exception 으로 교체한다.
  - 즉 시스템 예외인 Error 계열 예외는 다루지 않는다.