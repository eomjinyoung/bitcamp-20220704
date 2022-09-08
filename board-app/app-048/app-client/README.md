# 048. Connection 객체 공유하기 II - 의존 객체 주입 방식

## 작업 내용

### 1단계 - ClientApp에서 커넥션 객체를 준비한다.

- com.bitcamp.board.ClientApp 클래스 변경

### 2단계 - Connection 객체를 주입하는 방식으로 DAO를 변경한다.

- com.bitcamp.board.dao.MariaDBMemberDao 클래스 변경
- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경

### 3단계 - Handler에서 Connection 객체를 받을 수 있도록 변경한다.

- com.bitcamp.board.handler.MemberHandler 클래스 변경
- com.bitcamp.board.handler.BoardHandler 클래스 변경

### 4단계 - Handler를 생성할 때 Connection 객체를 주입한다.

- com.bitcamp.board.ClientApp 클래스 변경