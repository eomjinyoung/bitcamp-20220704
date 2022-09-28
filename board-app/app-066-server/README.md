### 066. 로그인 기능 활용하기: HttpSession 활용

## 작업 내용

### 0단계 - 게시글을 출력할 때 작성자 이름을 출력한다.

- com.bitcamp.board.domain.Board 클래스 변경
  - 필드에 직접 접근하지 못하게 private으로 접근 범위를 변경한다.
- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
- /webapp/board/list.jsp 변경
- /webapp/board/detail.jsp 변경
- com.bitcamp.board.controller.BoardAddController 클래스 변경
- com.bitcamp.board.controller.BoardUpdateController 클래스 변경

### 1단계 - 게시글 등록할 때 로그인 정보를 활용한다.

- /webapp/board/form.jsp 변경
  - 작성자 입력상자에 로그인 사용자의 번호를 자동으로 입력한다.
  - 로그인 사용자 정보를 요청 파라미터로 보낼 때의 문제점을 이해한다.
- com.bitcamp.board.controller.BoardAddController 클래스 변경
  - 게시글 등록할 때 로그인 사용자의 번호를 작성자 번호로 설정한다.

### 2단계 - 게시글을 변경, 삭제할 때 로그인 정보를 활용한다.

- com.bitcamp.board.controller.BoardUpdateController 클래스 변경
- com.bitcamp.board.controller.BoardDeleteController 클래스 변경

### 3단계 - 도메인 객체의 필드 대신 프로퍼티를 사용한다.

- com.bitcamp.board.domain.Member 클래스 변경
  - 필드에 직접 접근하지 못하게 private으로 접근 범위를 변경한다.
- com.bitcamp.board.controller.MemberAddController 클래스 변경
- com.bitcamp.board.controller.MemberUpdateController 클래스 변경