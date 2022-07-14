# 006. 메서드 사용법(with static)


## 작업 내용

### 1단계 - 메뉴를 처리하는 코드를 별도의 블록으로 묶는다.
- com.bitcamp.board.App 클래스 변경
  - 프로그램 환영 메시지 출력 코드 ==> welcome() {}
  - 게시글 목록을 처리하는 코드 ==> processBoardList() {}
  - 게시글 상세보기를 처리하는 코드 ==> processBoardDetail() {}
  - 게시글 입력을 처리하는 코드 ==> processBoardInput() {}
  - 메뉴를 출력하는 코드 ==> displayMenu() {}
  - 실행 결과 구분선을 출력하는 코드 ==> displayLine() {}
  - 메뉴 번호를 입력 받는 코드 ==> promptMenu() {}
  - 메뉴 번호 조건 검사 코드 ==> if 문을 switch 문으로 변경 
  - 결과를 출력 후 빈 라인 출력 코드 ==> displayBlankLine(); 
  

