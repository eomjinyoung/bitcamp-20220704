### 081. CRUD를 수행하는 페이지 컨트롤러를 하나로 합치기

## 작업 내용

### 1단계 - 게시판 CRUD 페이지 컨트롤러들을 하나로 합친다.

- com.bitcamp.board.controller.BoardController 클래스 생성
  - 기존의 게시글 관련 페이지 컨트롤러의 메서드를 가져온다.
  - 기존의 페이지 컨트롤러를 삭제한다.

### 2단계 - 로그인, 로그아웃 관련 페이지 컨트롤러들을 하나로 합친다.

- com.bitcamp.board.controller.AuthController 클래스 생성
  - 기존의 로그인, 로그아웃 관련 페이지 컨트롤러의 메서드를 가져온다.
  - 기존의 페이지 컨트롤러를 삭제한다.

### 3단계 - 회원 CRUD 페이지 컨트롤러들을 하나로 합친다.

- com.bitcamp.board.controller.MemberController 클래스 생성
  - 기존의 회원 관련 페이지 컨트롤러의 메서드를 가져온다.
  - 기존의 페이지 컨트롤러를 삭제한다.
