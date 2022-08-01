# 020. 자료구조를 구현하고 다루는 방법: Linked List 구현 및 사용

## 작업 내용

### 1단계 - 링크드리스트에서 값을 저장하는 일을 할 Node 클래스를 정의한다.

- com.bitcamp.util.Node 클래스 생성
  - 값을 저장할 필드와, 이전 노드/다음 노드 주소를 저장할 필드를 선언한다.

### 2단계 - Node 목록을 관리할 LinkedList 클래스를 정의한다.

- com.bitcamp.util.LinkedList 클래스 생성
  - 클래스 필드 및 생성자 정의
  - append() 메서드 구현
  - retrieve(int) 메서드 구현
  - delete(int) 메서드 구현
  - length() 메서드 구현
  - getArray() 메서드 구현
  
### 3단계 - BoardList와 MemberList의 수퍼 클래스를 ObjectList에서 LinkedList로 교체한다.

- com.bitcamp.board.dao.BoardList 클래스 변경
  - 수퍼 클래스 교체에 맞춰 오버라이딩 메서드 변경
- com.bitcamp.board.dao.MemberList 클래스 변경
  - 수퍼 클래스 교체에 맞춰 오버라이딩 메서드 변경

### 4단계 - BoardList와 MemberList의 변경에 맞춰 XxxHandler 클래스를 변경한다.

- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - BoardList 변경에 맞춰 맞춰 오버라이딩 메서드의 이름을 변경한다.
- com.bitcamp.board.handler.MemberHandler 클래스 변경
  - MemberList 변경에 맞춰 맞춰 오버라이딩 메서드의 이름을 변경한다.