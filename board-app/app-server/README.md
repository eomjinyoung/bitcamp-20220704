### 085. Mybatis SQL 매퍼 사용하기: DAO 구현 자동화

## 작업 내용

### 1단계 - Mybatis SQL Mapper 라이브러리를 프로젝트에 추가한다.

- search.maven.org 에서 'mybatis' 검색한다.
  - mybatis 라이브러리 파일
- search.maven.org 에서 'mybatis-spring' 검색한다.
  - mybatis를 spring과 연동할 때 사용되는 라이브러리 파일
- 라이브러리를 빌드 스크립트 파일(build.gradle)에 설정한다.
- 이클립스 IDE용 설정 파일을 갱신한다.
- 프로젝트를 갱신한다.
- 라이브러리가 추가된 것을 확인한다.

### 2단계 - SqlSessionFactory 객체를 준비한다.

- com.bitcamp.board.config.MybatisConfig 클래스 생성
  - sqlSessionFactory() 메서드 추가
- com.bitcamp.board.config.AppWebApplicationInitializer 클래스 변경
  - getRootConfigClasses() 메서드 리턴 값 변경

### 3단계 - Mybatis를 사용하는 DAO를 정의한다.

- com.bitcamp.board.dao.MybatisMemberDao 클래스 생성
- com/bitcamp/board/mapper/MemberDaoMapper.xml 파일 생성


- com.bitcamp.board.dao.MybatisBoardDao 클래스 생성

