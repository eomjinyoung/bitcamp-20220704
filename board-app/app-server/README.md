### 079. Spring IoC 컨테이너 도입하기: 페이지 컨트롤러 생성 자동화

## 작업 내용

### 1단계 - Spring IoC 컨테이너 프레임워크를 프로젝트에 추가한다.

- search.maven.org 에서 spring-context 라이브러리 검색한다.
- 빌드 스크립트 파일(build.gradle)에 의존 라이브러리 정보를 추가한다.
- `gradle eclipse` 실행한다.
- 이클립스IDE에서 프로젝트를 갱신한다.

### 2단계 - ContextLoaderListener에서 스프링 IoC 컨테이너를 준비한다.

- com.bitcamp.board.config.AppConfig 클래스 생성
  - 스프링 IoC 컨테이너의 설정을 수행하는 클래스
- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경


### 3단계 - Spring IoC 컨테이너에서 DataSource 객체를 생성한다.

- Spring JDBC 라이브러리 추가한다.
  - search.maven.org 에서 spring-jdbc 라이브러리 검색한다.
  - 빌드 스크립트 파일(build.gradle)에 의존 라이브러리 정보를 추가한다.
  - `gradle eclipse` 실행한다.
  - 이클립스IDE에서 프로젝트를 갱신한다.
- com.bitcamp.board.config.AppConfig 클래스 변경
  - createDataSource(): DataSource 구현체를 준비한다.

### 4단계 - Spring IoC 컨테이너에서 DataSource 객체를 생성한다.










### 4단계 - 우리가 만든 DataSource 를 스프링에서 제공하는 DataSource 구현체로 교체한다.

- com.bitcamp.sql.DataSource 클래스 삭제
- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
- com.bitcamp.board.dao.MariaDBMemberDao 클래스 변경

### 5단계 - 우리가 만든 TransactionManager를 스프링의 PlatformTransactionManager 구현체로 교체한다.

- com.bitcamp.transaction.TransactionManager 클래스 삭제
- com.bitcamp.transaction.TransactionStatus 클래스 삭제
- com.bitcamp.boad.service.DefaultBoardService 클래스를 변경

### 6단계 - Spring IoC 컨테이너를 이용하여 페이지 컨트롤러 관련 객체를 자동으로 생성한다.

- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경

### 7단계 - Spring IoC 컨테이너를 프론트 컨트롤러에 주입한다.

- com.bitcamp.servlet.DispatcherServlet 클래스 변경
