# 018. 예외를 발생시키는 방법

## 작업 내용

### 1단계 - 예외 상황이 발생했을 때 특정 값을 리턴하는 대신 오류 정보를 던진다.

- com.bitcamp.util.ObjectList 클래스 변경
  - get() 변경: 오류 상황일 때(인덱스가 무효할 때) 예외를 발생시킨다.
  - remove() 변경: 오류 상황일 때(인덱스가 무효할 때) 예외를 발생시킨다.
  - 이 메서드를 호출하는 쪽에서 좀 더 정교하게 제어할 수 있도록 도와 준다.

### 2단계 - 메서드에서 예외를 던졌을 때 직접 처리하는 대신 호출자에게 위임한다.

- com.bitcamp.board.dao.BoardList 클래스 변경
  - ObjectList의 get(), remove() 메서드가 예외를 던질 때 처리하지 말고 호출자에게 위임한다.
- com.bitcamp.board.dao.MemberList 클래스 변경
  - ObjectList의 get(), remove() 메서드가 예외를 던질 때 처리하지 말고 호출자에게 위임한다

### 3단계 - XxxList 가 던진 예외를 XxxHandler에서 처리한다.

- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - onDetail(), onUpdate(), onDelete() 메서드 각각에서 예외를 처리한다.
  - BoardHandler01.java
- com.bitcamp.board.handler.MemberHandler 클래스 변경
  - onDetail(), onUpdate(), onDelete() 메서드 각각에서 예외를 처리한다.
    - 메서드 안의 코드를 통째로 try {} 안에 둔다.
  - MemberHandler01.java

### 4단계 - 메서드에서 발생한 예외를 한 곳에서 처리한다.

- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - onDetail(), onUpdate(), onDelete() 메서드에서 예외를 처리하는 대신 
    execute() 메서드에서 예외를 몰아 처리한다.
- com.bitcamp.board.handler.MemberHandler 클래스 변경
  - onDetail(), onUpdate(), onDelete() 메서드에서 예외를 처리하는 대신 
    execute() 메서드에서 예외를 몰아 처리한다.