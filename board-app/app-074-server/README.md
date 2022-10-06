### 074. 서비스 객체에 트랜잭션 적용하기

## 작업 내용

### 1단계 - 서비스 객체에 Connection 객체를 주입한다.

- com.bitcamp.board.service.DefaultBoardService 클래스 변경
  - 생성자 변경
- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경
  - BoardService 객체를 생성할 때 생성자에 Connection 객체를 주입한다.

### 2단계 - 게시글 입력과 변경, 삭제에 트랜잭션을 적용한다.

- com.bitcamp.board.service.DefaultBoardService 클래스 변경
  - add(), update(), delete() 변경