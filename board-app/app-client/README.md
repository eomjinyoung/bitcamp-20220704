# 046. DBMS 도입하기

## 작업 내용

### 1단계 - 테이블을 정의한다.

- 멤버 및 게시글 DB 모델링
  - model.exerd
- SQL DDL 작성
  - ddl.sql
- DBMS에 테이블 생성

### 2단계 - 테스트용 예제 데이터를 입력한다.

- 회원 데이터 및 게시글 데이터 입력
  - data.sql

### 3단계 - MariaDB 용 JDBC Driver 를 추가한다.

- search.maven.org 사이트에서 mariadb jdbc 검색
- build.gradle 파일에 의존 라이브러리 정보 추가
- `gradle eclipse` 실행
- 이클립스IDE에서 프로젝트 갱신
- 프로젝트에 mariadb jdbc driver 가 추가되었는지 확인


### 4단계 - MariaDB 서버와 연동하는 MemberDao를 정의한다.

- com.bitcamp.board.domain.Board 클래스 변경
  - createdDate 필드를 java.sql.Date 타입으로 변경
  - 기타 메서드 정리
- com.bitcamp.board.dao.MariaDBMemberDao 클래스 정의
