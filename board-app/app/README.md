# 023. 메서드 사용법을 규격화하여 객체 사용 방법을 일관성 있게 만들기: 인터페이스


## 작업 내용

### 0단계 - 코드 준비

- 021 버전의 소스를 가져온다.

### 1단계 - 목록을 다루는 객체가 가져야 할 메서드의 형식을 정한다.

- com.bitcamp.util.List 인터페이스 생성
  - 목록을 다루는 메서드를 선언한다.
  
### 2단계 - List 규격에 따라 ObjectList를 구현한다.

- com.bitcamp.util.Object 클래스 변경
  - List 인터페이스를 구현한다.

### 3단계 - XxxDao에서 의존 객체를 가리킬 때는 클래스명 대신 인터페이스 이름을 사용한다.

- com.bitcamp.board.dao.BoardDao 클래스 변경
  - ObjectList 객체의 주소를 담는 필드를 List 타입으로 변경한다.
  - List 규격에 따라 메서드를 호출한다.

- com.bitcamp.board.dao.MemberDao 클래스 변경
  - ObjectList 객체의 주소를 담는 필드를 List 타입으로 변경한다.
  - List 규격에 따라 메서드를 호출한다.