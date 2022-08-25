# 045. Thread를 이용한 멀티 태스킹 구현하기: 동시 요청 처리하기

## 작업 내용

### 1단계 - 클라이언트 요청을 별도의 실행흐름으로 처리할 스레드를 만든다.

- com.bitcamp.board.RequestThread 클래스 생성

### 2단계 - 스레드를 통해 클라이언트 요청을 처리한다.

- com.bitcamp.board.ServerApp 클래스 변경

### 3단계 - 리팩토링1: RequestThread를 ServerApp의 static nested class로 만든다.

- com.bitcamp.board.RequestThread 클래스 삭제
  - 삭제 전 클래스 백업: RequestThread01.java
- com.bitcamp.board.ServerApp 클래스 변경
  - 변경 전 클래스 백업: ServerApp01.java

### 4단계 - 리팩토링2: RequestThread를 main()의 local class로 만든다.

- com.bitcamp.board.ServerApp 클래스 변경
  - 변경 전 클래스 백업: ServerApp02.java

### 5단계 - 리팩토링3: RequestThread를 Runnable 구현체로 만든다.

- com.bitcamp.board.ServerApp 클래스 변경
  - 변경 전 클래스 백업: ServerApp03.java

### 6단계 - 리팩토링4: RequestRunnable을 익명 클래스로 만든다.

- com.bitcamp.board.ServerApp 클래스 변경
  - 변경 전 클래스 백업: ServerApp04.java

### 7단계 - 리팩토링5: 익명 클래스를 람다(lambda) 표현식으로 만든다.

- com.bitcamp.board.ServerApp 클래스 변경
  - 변경 전 클래스 백업: ServerApp05.java