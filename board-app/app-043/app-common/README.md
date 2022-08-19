# 043. Client/Server 공통 코드를 라이브러리 프로젝트로 분리하기

## 작업 내용

### 1단계 - 도메인 클래스와 프록시 클래스를 app-common 프로젝트로 옮긴다.

- com.bitcamp.board.domain.* 패키지 추가
- com.bitcamp.board.dao.XxxDaoProxyXxx 클래스 추가

### 2단계 - app-common 프로젝트 자바 라이브러리 프로젝트로 만든다.

- build.gradle 파일 변경
  - id 'java-library' 설정