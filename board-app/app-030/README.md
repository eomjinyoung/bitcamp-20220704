# 030. List가 특정 타입의 목록만 다루게 하는 방법: 제네릭 문법 적용


## 작업 내용

### 1단계 - List 인터페이스에 제네릭을 적용한다.

- com.bitcamp.util.List 인터페이스 변경
  - 목록에서 다루는 항목의 타입을 제네릭으로 설정한다.

### 2단계 - List 구현체에 제네릭을 적용한다.

- com.bitcamp.util.AbstractList 추상 클래스 변경
- com.bitcamp.util.ObjectList 클래스 변경
- com.bitcamp.util.LinkedList 클래스 변경

### 3단계 - XxxDao 클래스는 제네릭이 적용된 List 구현체 사용한다.

- com.bitcamp.board.dao.BoardDao 클래스 변경
- com.bitcamp.board.dao.MemberDao 클래스 변경