# 011. 인스턴스 필드와 인스턴스 메서드, 생성자 사용법 


## 작업 내용

### 1단계 - BoardHandler의 필드와 메서드를 인스턴스 멤버로 전환한다.

- com.bitcamp.board.BoardHandler 클래스 변경
  - 관련 필드를 인스턴스 필드로 변경한다.
  - 인스턴스 필드를 다루는 메서드는 인스턴스 메서드로 변경한다.
- com.bitcamp.board.App 클래스 변경
  - BoardHandler의 인스턴스를 만들어 다양한 게시판을 관리한다.

### 2단계 - 각 게시판의 제목을 따로 다룰 수 있게 한다.

- com.bitcamp.board.BoardHandler 클래스 변경
  - 게시판 제목을 저장할 인스턴스 필드 title을 추가한다.
  - 게시판 제목을 출력할 수 있도록 관련 메서드를 변경한다.
- com.bitcamp.board.App 클래스 변경
  - BoardHandler의 인스턴스를 만들 때 각 게시판에 대해 title 필드를 설정한다.

### 3단계 - 게시판의 제목을 설정하지 않으면 쓸 수 없도록 제한을 가한다.

- com.bitcamp.board.BoardHandler 클래스 변경
  - 인스턴스를 생성활 때 게시판 제목을 저장하는 title 필드의 값을 반드시 입력하도록 생성자를 추가한다.
  - 인스턴스 메서드가 제대로 작업할 수 있도록 인스턴스 필드를 유효한 값으로 설정하기 위해 생성자를 이용한다.

### 4단계 - 리팩토링: 사용자의 명령을 처리하는 메서드의 이름을 적절하게 변경한다.

- com.bitcamp.board.BoardHandler 클래스 변경
  - processList() ==> onList()
  - processDetail() ==> onDetail()
  - processInput() ==> onInput()
  - processDelete() ==> onDelete()
  - processUpdate() ==> onUpdate();

### 5단계 - 다양한 상황에서 사용할 생성자를 추가한다.

- com.bitcamp.board.BoardHandler 클래스 변경
  - Board() 기본 생성자 추가
  - Board(int) 생성자 추가