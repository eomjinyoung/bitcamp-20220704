# 007. 클래스 사용법


## 작업 내용

### 1단계 - 게시글을 처리하는 메서드를 별도의 클래스로 분류한다
- com.bitcamp.board.BoardHandler 클래스 생성
  - App 클래스에 processBoardList() {} 가져온다. 
    - 메서드 이름을 processList()로 변경한다.
  - App 클래스에 processBoardDetail() {} 가져온다. 
    - 메서드 이름을 processDetail()로 변경한다.
  - App 클래스에 processBoardInput() {} 가져온다. 
    - 메서드 이름을 processInput()로 변경한다.
- com.bitcamp.board.App 클래스 변경

### 2단계 - 사용자에게 프롬프트를 제공한 클래스를 추가한다.
- com.bitcamp.board.Prompt 클래스 생성
  - inputInt() 메서드 추가
  - inputString() 메서드 추가
  - inputInt(String) 메서드 추가
  - inputString(String) 메서드 추가
- com.bitcamp.board.App 클래스 변경
  - Prompt 클래스를 이용하여 사용자 입력 받기
- com.bitcamp.board.BoardHandler 클래스 변경
  - Prompt 클래스를 이용하여 사용자 입력 받기

