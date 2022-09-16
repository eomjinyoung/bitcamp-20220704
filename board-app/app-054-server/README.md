### 054. Command 객체의 사용법 통일하기 - 인터페이스 활용

## 작업 내용

### 1단계 - Command 객체의 사용 규칙을 정의한다.

- com.bitcamp.servlet.Servlet 인터페이스 정의


### 2단계 - 기존의 커맨드 객체를 Servlet 구현체로 변경한다.

- com.bitcamp.board.handler.BoardListHandler 클래스 변경
- com.bitcamp.board.handler.BoardDetailHandler 클래스 변경
- com.bitcamp.board.handler.BoardUpdateHandler 클래스 변경
- com.bitcamp.board.handler.BoardDeleteHandler 클래스 변경
- com.bitcamp.board.handler.BoardFormHandler 클래스 변경
- com.bitcamp.board.handler.BoardAddHandler 클래스 변경
- com.bitcamp.board.handler.MemberListHandler 클래스 변경
- com.bitcamp.board.handler.MemberDetailHandler 클래스 변경
- com.bitcamp.board.handler.MemberUpdateHandler 클래스 변경
- com.bitcamp.board.handler.MemberDeleteHandler 클래스 변경
- com.bitcamp.board.handler.MemberFormHandler 클래스 변경
- com.bitcamp.board.handler.MemberAddHandler 클래스 변경
- com.bitcamp.board.handler.ErrorHandler 클래스 변경
- com.bitcamp.board.handler.WelcomeHandler 클래스 변경
- com.bitcamp.board.MiniWebServer 클래스 변경 
