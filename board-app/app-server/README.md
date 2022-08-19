# 043. Client/Server 공통 코드를 라이브러리 프로젝트로 분리하기

## 작업 내용

### 1단계 - 도메인 클래스와 프록시 클래스를 app-common 프로젝트로 옮긴다.

- com.bitcamp.board.domain.* 패키지 삭제
- com.bitcamp.board.dao.XxxDaoProxyXxx 클래스 삭제

### 2단계 - app-common 서브 프로젝트를 포함시킨다.

- build.gradle 파일 변경