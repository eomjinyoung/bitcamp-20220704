# 022. 자료구조를 구현하고 다루는 방법: Linked List 구현 및 사용


## 작업 내용

### 1단계 - LinkedList 를 구현한다.

- 020 버전에서 구현한 LinkedList 관련 클래스를 가져온다.

### 2단계 - BoardDao와 MemberDao는 ObjectList 대신 LinkedList를 사용한다.

- com.bitcamp.board.dao.BoardDao 클래스 변경
  - 의존 객체를 ObjectList 에서 LinkedList로 교체한다.
- com.bitcamp.board.dao.MemberDao 클래스 변경
  - 의존 객체를 ObjectList 에서 LinkedList로 교체한다.