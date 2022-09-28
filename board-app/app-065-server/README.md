### 065. 로그인, 로그아웃 처리하기: HttpSession, Cookie 사용

## 작업 내용

### 1단계 - 로그인 폼을 만든다.

- /webapp/auth/form.jsp 생성

### 2단계 - 로그인을 처리한다.

- com.bitcamp.board.controller.LoginController 클래스 생성
  - 로그인 사용자 정보를 HttpSession 보관소에 저장한다.
- /webapp/auth/loginResult.jsp 파일 생성
  - 로그인 결과에 따라 리프래시 경로를 지정한다.

### 3단계 - 로그아웃을 처리한다.

- com.bitcamp.board.controller.LogoutController 클래스 생성

### 4단계 - 로그인할 때 입력한 사용자 이메일을 기억한다.

- com.bitcamp.board.controller.LoginController 클래스 변경
  - 로그인 이메일을 쿠키로 웹브라우저에게 보낸다.
- /webapp/auth/form.jsp 변경
  - 쿠키 테이블에 보관된 이메일 정보를 꺼내 이메일 입력란에 출력한다.