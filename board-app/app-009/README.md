# 009. 리팩토링: 함수 추출 및 함수 옮기기


## 작업 내용

### 1단계 - 메뉴 구조를 변경한다.

```
메뉴:
  1: 게시판
  2: 독서록
  3: 방명록
  4: 공지사항
메뉴를 선택하세요[1..4](0: 종료) 1

게시판:
  1: 목록
  2: 상세보기
  3: 등록
  4: 삭제
  5: 변경
메뉴를 선택하세요[1..5](0: 이전) 0

메뉴:
  1: 게시글
  2: 독서록
  3: 방명록
  4: 공지사항
메뉴를 선택하세요[1..4](0: 종료)
```
- com.bitcamp.board.App 클래스 변경
  - App01.java 로 백업

### 2단계 - 리팩토링: 게시판 메뉴를 다루는 코드를 메서드로 추출한다.
- com.bitcamp.board.App 클래스 변경
  - onBoardMenu() 메서드 추가
  - displayMenu() 메서드 제거: onBoardMenu()로 코드를 옮긴다.
  - App02.java 로 백업

### 3단계 - 리팩토링: 게시판 메뉴를 출력하는 메서드를 BoardHandler로 옮긴다.
- com.bitcamp.board.App 클래스 변경
  - onBoardMenu(), displayLine(), displayBlankLine() 메서드를 BoardHandler 로 옮긴다.
- com.bitcamp.board.BoardHandler 클래스 변경
  - onBoardMenu(), displayLine(), displayBlankLine() 메서드 추가
  - displayLine() ==> displayHeadline() 이름 변경
  - onBoardMenu() ==> execute() 이름 변경