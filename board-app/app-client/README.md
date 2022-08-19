# 041. Client/Server 리팩토링

## 작업 내용

### 1단계 - BoardDaoProxy 클래스를 적용한다.
 
- com.bitcamp.board.dao.BoardDaoProxy 클래스 추가
  - 서버 개발자가 만들어준 클래스를 추가한다.
- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - 직접 통신하는 대신에 BoardDaoProxy 클래스를 사용한다.
