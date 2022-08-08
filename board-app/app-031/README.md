# 031. 데이터 조회 로직을 객체화 하기: Iterator 패턴 적용

## 작업 내용

### 1단계 - Iterator 인터페이스를 정의한다.

- com.bitcamp.util.Iterator 인터페이스 생성

### 2단계 - List 규격에 Iterator 를 리턴하는 규칙을 추가한다.

- com.bitcamp.util.List 인터페이스 변경
  - iterator() 규칙 추가

### 3단계 - AbstractList 에서 iterator() 메서드를 구현한다.

- com.bitcamp.util.AbstractList 클래스 변경

### 4단계 - XxxDao 에서 목록을 가져올 때 Iterator를 사용한다.

toArray() 대신 iterator() 사용을 통해 Iterator 객체 사용법 훈련.

- com.bitcamp.board.dao.XxxDao 클래스 변경

### 5단계 - Stack의 toString() 메서드를 구현할 때 Iterator를 사용한다.

- com.bitcamp.util.Stack 클래스 변경
  - 제네릭을 적용한다.
  - toString()에서 Iterator를 사용한다. 

### 6단계 - App 클래스에서 Stack 을 만들 때 제네릭을 적용한다.

- com.bitcamp.board.App 클래스 변경
