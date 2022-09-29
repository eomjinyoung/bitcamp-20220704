### 068. POST 방식으로 데이터 보내기: GET/POST 요청

## 작업 내용

### 1단계 - 로그인 요청을 POST 방식으로 변경한다.

- /webapp/auth/form.jsp 변경
- com.bitcamp.board.controller.LoginController 클래스 변경
  
### 2단계 - 게시글 등록 및 변경도 POST 방식으로 바꾼다.

- /webapp/board/form.jsp 변경
- /webapp/board/detail.jsp 변경
- com.bitcamp.board.controller.BoardAddController 클래스 변경
- com.bitcamp.board.controller.BoardUpdateController 클래스 변경

### 3단계 - 회원 등록 및 변경도 POST 방식으로 바꾼다.

- /webapp/member/form.jsp 변경
- /webapp/member/detail.jsp 변경
- com.bitcamp.board.controller.MemberAddController 클래스 변경
- com.bitcamp.board.controller.MemberUpdateController 클래스 변경