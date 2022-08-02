# 024. List 규격에 맞춰 LinkedList 구현하고 적용하기


## 작업 내용

### 1단계 - List 규격에 맞춰 LinkedList를 구현한다.

- com.bitcamp.util.LinkedList 클래스 생성
  - 022 버전의 LinkedList 클래스를 가져온다.
  - List 인터페이스를 구현한다.
  
### 2단계 - XxxDao에서 사용하는 ObjectList를 LinkedList로 교체한다.

- com.bitcamp.dao.BoardDao 클래스 변경
  - ObjectList 대신 LinkedList로 교체한다.
- com.bitcamp.dao.MemberDao 클래스 변경
  - ObjectList 대신 LinkedList로 교체한다.