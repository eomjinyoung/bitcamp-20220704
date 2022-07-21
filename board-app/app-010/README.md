# 010. 스태틱 필드의 한계


## 작업 내용

### 1단계 - 독서록 게시판을 추가한다.

- com.bitcamp.board.ReadingHandler 클래스 추가
  - BoardHandler 클래스를 복제하고, 코드를 변경한다.
- com.bitcamp.board.App 클래스 변경
  - 독서록 메뉴를 실행할 수 있도록 코드 변경

### 2단계 - 방명록을 추가한다.

- com.bitcamp.board.VisitHandler 클래스 추가
  - BoardHandler 클래스를 복제하고, 코드를 변경한다.
- com.bitcamp.board.App 클래스 변경
  - 방명록 메뉴를 실행할 수 있도록 코드 변경

### 3단계 - 공지사항 게시판을 추가한다.

- com.bitcamp.board.NoticeHandler 클래스 추가
  - BoardHandler 클래스를 복제하고, 코드를 변경한다.
- com.bitcamp.board.App 클래스 변경
  - 공지사항 메뉴를 실행할 수 있도록 코드 변경

### 4단계 - 게시판의 글목록 크기를 자동으로 증가시킨다.

- com.bitcamp.board.BoardHandler 클래스 변경
  - processInput() 메서드 변경

### 5단계 - 나머지 게시판의 글목록 크기를 자동으로 증가시킨다.

- com.bitcamp.board.ReadingHandler 클래스 변경
  - processInput() 메서드 변경
- com.bitcamp.board.VisitHandler 클래스 변경
  - processInput() 메서드 변경
- com.bitcamp.board.NoticeHandler 클래스 변경
  - processInput() 메서드 변경