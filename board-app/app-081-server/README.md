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

### 4단계 - 리팩토링

- com.bitcamp.board.controller.BoardController 클래스 변경
  - saveAttachedFiles()
  - checkOwner()

### 5단계 - POST 요청 파라미터 값의 문자셋 지정을 필터로 이관한다.

- com.bitcamp.board.filter.CharacterEncodingFilter 클래스 생성
- com.bitcamp.board.controller.XxxController 클래스 변경
  - 요청 파라미터 값의 문자집합 설정 코드를 제거한다.

### 6단계 - @RequestMapping 애노테이션 사용법을 연습한다.

- com.bitcamp.board.controller.AuthController 클래스 변경
  - @PostMapping, @GetMapping 대신 @RequestMapping 애노테이션을 사용한다.