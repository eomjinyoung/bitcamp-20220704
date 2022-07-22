# 015. 공통 코드(필드,메서드)를 공유하는 방법 : 상속 


## 작업 내용

### 1단계 - BoardList와 MemberList의 공통 필드와 메서드를 찾아 분리한다.

- com.bitcamp.board.dao.ObjectList 클래스 생성

### 2단계 - ObjectList를 상속 받아 BoardList와 MemberList를 정의한다.

- com.bitcamp.board.dao.BoardList 클래스 변경
- com.bitcamp.board.dao.MemberList 클래스 변경
- com.bitcamp.board.handler.BoardHandler 클래스 변경
- com.bitcamp.board.handler.MemberHandler 클래스 변경