# 049. DAO 객체를 교체하기 쉽게 만들기 - 의존 객체 주입과 인터페이스

## 작업 내용

### 1단계 - Handler에서 DAO를 주입 받도록 변경한다.

- com.bitcamp.board.handler.MemberHandler 클래스 변경
- com.bitcamp.board.handler.BoardHandler 클래스 변경
- com.bitcamp.board.ClientApp 클래스 변경


### 2단계 - DAO의 사용법을 통일하여 DAO 교체시 코드 변경을 최소화시킨다.

- com.bitcamp.board.dao.MemberDao 인터페이스 정의
- com.bitcamp.board.dao.MariaDBMemberDao 클래스 변경
  - MemberDao 인터페이스 규칙에 맞춰 클래스를 정의한다.
- com.bitcamp.board.dao.BoardDao 인터페이스 정의
- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
  - BoardDao 인터페이스 규칙에 맞춰 클래스를 정의한다.
