### 069. 파일을 업로드하기: multipart/form-data MIME 타입

## 작업 내용

### 1단계 - 게시글의 첨부 파일 테이블을 생성한다.

- /doc/model.exerd 변경
- /doc/ddl.sql 변경
- /doc/data.sql 변경

### 2단계 - 게시글 등록할 때 파일을 첨부한다.

- /webapp/board/form.jsp 변경
- charlesproxy 프로그램으로 multipart/form-data 형식으로 넘어가는 프로토콜 확인

### 3단계 - 멀티파트 형식으로 업로드된 게시글의 입력을 처리한다.

- apache의 commons-fileupload 라이브러리를 프로젝트 추가
- com.bitcamp.board.domain.AttachedFile 클래스 생성
  - app_board_file 테이블의 값을 담는 객체
- com.bitcamp.board.controller.BoardAddController 클래스 변경
- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
  - insert()

### 4단계 - 게시글을 조회할 때 첨부파일 목록을 출력한다.

- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
  - findByNo() 변경
- /webapp/board/detail.jsp 변경

### 5단계 - 첨부파일 삭제 기능을 추가한다.

- /webapp/board/detail.jsp 변경
- com.bitcamp.board.controller.BoardFileDeleteController 클래스 생성
- com.bitcamp.board.dao.BoardDao 인터페이스 변경
  - findFileByNo(), deleteFile() 추가
- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
  - findFileByNo(), deleteFile() 구현

### 6단계 - 게시글을 변경할 때 첨부파일을 추가할 수 있게 만든다.

- /webapp/board/detail.jsp 변경
- com.bitcamp.board.controller.BoardUpdateController 클래스 변경
- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
  - insertFiles() 추가
  - update(),insert() 변경

### 7단계 - 게시글을 삭제할 때 첨부파일도 함께 삭제한다.

- com.bitcamp.board.dao.BoardDao 인터페이스 변경
  - deleteFiles() 추가
- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
  - deleteFiles() 구현
  - delete() 변경


  
