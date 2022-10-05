### 071. DAO에서 비즈니스 로직 분리하기: Controller에서 비즈니스 로직처리

## 작업 내용

### 1단계 - 게시글 등록과 관련된 업무 흐름을 DAO에서 분리한다.

- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
  - insert() 변경
- com.bitcamp.board.controller.BoardAddController 클래스 변경

### 2단계 - 게시글 변경과 관련된 업무 흐름을 DAO에서 분리한다.

- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
  - update() 변경
- com.bitcamp.board.controller.BoardUpdateController 클래스 변경

### 3단계 - 게시글 삭제와 관련된 업무 흐름을 DAO에서 분리한다.

- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
  - delete() 변경
- com.bitcamp.board.controller.BoardDeleteController 클래스 변경