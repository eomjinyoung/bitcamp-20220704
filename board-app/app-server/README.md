### 069. 파일을 업로드하기: multipart/form-data MIME 타입

## 작업 내용

### 1단계 - 게시글의 첨부 파일 테이블을 생성한다.

- /doc/model.exerd 변경
- /doc/ddl.sql 변경
- /doc/data.sql 변경

### 2단계 - 게시글 등록할 때 파일을 첨부한다.

- /webapp/board/form.jsp 변경
- charlesproxy 프로그램으로 multipart/form-data 형식으로 넘어가는 프로토콜 확인

### 3단계 - 멀티파트 형식으로 업로드된 데이터를 처리한다.

- apache의 commons-fileupload 라이브러리를 프로젝트 추가
- com.bitcamp.board.domain.AttachedFile 클래스 생성
  - app_board_file 테이블의 값을 담는 객체
  
