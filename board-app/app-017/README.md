# 017. 예외를 처리하는 방법 2

## 작업 내용

### 1단계 - 메인 메뉴를 잘못 입력 했을 때 발생한 예외를 처리한다.

- com.bitcamp.board.App 클래스 변경
  - 메뉴 번호 입력 받는 부분에 try ~ catch ~ 적용 

### 2단계 - 게시판 메뉴를 잘못 입력 했을 때 발생한 예외를 처리한다.

- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - execute() 메서드에 try ~ catch ~ 적용

### 3단계 - 게시글 조회, 변경, 삭제 메뉴에서 발생한 예외를 처리한다.

- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - onDetail(), onUpdate(), onDelete() 에 try ~ catch ~ 적용

예외 처리 코드는 프로그램 동작에 따라 적용이 달라진다.
  
