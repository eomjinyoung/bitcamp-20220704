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

### 4단계 - Spring IoC 컨테이너에서 트랜잭션 관리자를 생성한다.

- com.bitcamp.board.config.AppConfig 클래스 변경
  - createTransactionManager(): PlatformTransactionManager 구현체를 준비한다.

### 5단계 - 스프링에서 생성한 DataSource를 사용하도록 DAO를 변경한다.

- com.bitcamp.sql.DataSource 클래스 삭제
- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
- com.bitcamp.board.dao.MariaDBMemberDao 클래스 변경

### 6단계 - 스프링에서 DAO 객체를 생성한다.

- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경
  - DataSource 생성 코드 삭제
  - TransactionManager 생성 코드 삭제
  - DAO 생성 코드 삭제
- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
  - Spring IoC 컨테이너가 관리하는 객체임을 표시한다.
- com.bitcamp.board.dao.MariaDBMemberDao 클래스 변경
  - Spring IoC 컨테이너가 관리하는 객체임을 표시한다.
- com.bitcamp.board.config.AppConfig 클래스 변경
  - @Component가 붙은 클래스를 찾아 객체를 생성하도록 그 클래스가 소속된 패키지를 지정한다.


### 7단계 - 스프링에서 서비스 객체를 생성한다.

- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경
  - 서비스 객체 생성 코드 삭제
- com.bitcamp.board.service.DefaultBoardService 클래스 변경
  - Spring IoC 컨테이너가 관리하는 객체임을 표시한다.
  - 트랜잭션 매지저를 Spring 에서 제공하는 객체로 교체한다.
- com.bitcamp.board.service.DefaultMemberService 클래스 변경
  - Spring IoC 컨테이너가 관리하는 객체임을 표시한다.

### 8단계 - 스프링에서 페이지 컨트롤러를 생성한다.

- com.bitcamp.board.controller.XxxController 클래스 변경
  - Spring IoC 컨테이너가 관리하는 객체임을 표시한다.
- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경
  - 페이지 컨트롤러 생성 코드를 삭제한다.

### 9단계 - Spring IoC 컨테이너를 프론트 컨트롤러에 주입한다.

- com.bitcamp.servlet.DispatcherServlet 클래스 변경
  - Spring IoC 컨테이너를 주입받는 생성자로 변경한다.
- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경
  - DispatcherServlet 객체를 생성할 때 생성자 파라미터로 Spring IoC 컨테이너를 주입한다.