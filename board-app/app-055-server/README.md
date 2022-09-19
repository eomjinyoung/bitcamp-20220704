### 055. 애노테이션과 리플렉션 API를 활용하여 객체 자동 생성하기

## 작업 내용

### 1단계 - 객체 자동 생성 도구를 프로젝트에 추가한다.

- Reflections 라이브러리를 프로젝트에 추가한다.
  - search.maven.org 에서 reflections 로 검색한다.
  - build.gradle에 의존 라이브러리를 추가한다.
  - `gradle eclipse`를 실행하여 이클립스IDE 설정 파일을 갱신한다.
  - 이클립스IDE에서 프로젝트를 refresh 한다.

### 2단계 - DAO 객체를 자동 생성하여 맵에 보관한다.

- com.bitcamp.servlet.annotation.Repository 애노테이션 정의
- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
- com.bitcamp.board.dao.MariaDBMemberDao 클래스 변경
- com.bitcamp.board.MiniWebServer 클래스 변경

### 3단계 - 요청을 처리하는 객체를 자동 생성하여 맵에 보관한다.

- com.bitcamp.servlet.annotation.WebServlet 애노테이션 정의
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
- com.bitcamp.board.handler.WelcomeHandler 클래스 변경
- com.bitcamp.board.MiniWebServer 클래스 변경

