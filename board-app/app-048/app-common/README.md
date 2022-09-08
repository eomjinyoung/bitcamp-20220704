# 046. DBMS 도입하기

## 작업 내용

### 1단계 - 도메인 클래스를 DBMS 사용에 맞춰 정리한다.

- com.bitcamp.board.domain.Member 클래스 변경
  - createdDate 필드를 java.sql.Date 타입으로 변경
  - 기타 메서드 정리
- com.bitcamp.board.domain.Board 클래스 변경
  - createdDate 필드를 java.sql.Date 타입으로 변경
  - writer 필드를 int 타입 memberNo로 변경
  - 기타 메서드 정리
