### 073. 서비스 객체에 인터페이스 적용하기: 서비스 객체를 교체하기 쉽게 만들기

## 작업 내용

### 1단계 - BoardService 객체를 인터페이스와 구현체로 분리한다.

- com.bitcamp.board.service.BoardService 클래스를 인터페이스로 변경
- com.bitcamp.board.service.DefaultBoardService 클래스 생성
  - 기존의 BoardService 클래스를 인터페이스 구현 클래스로 만든다.

### 2단계 - MemberService 객체를 인터페이스와 구현체로 분리한다.

- com.bitcamp.board.service.MemberService 클래스를 인터페이스로 변경
- com.bitcamp.board.service.DefaultMemberService 클래스 생성
  - 기존의 MemberService 클래스를 인터페이스 구현 클래스로 만든다.

### 3단계 - 서비스 객체를 준비할 때 새로 생성한 구현체를 사용한다.

- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경
