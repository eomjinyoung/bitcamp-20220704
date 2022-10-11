### 080. Spring WebMVC 프론트 컨트롤러 도입하기

## 작업 내용

### 1단계 - Spring WebMVC 프레임워크를 프로젝트에 추가한다.

- search.maven.org 에서 spring-webmvc 라이브러리 검색한다.
- 빌드 스크립트 파일(build.gradle)에 의존 라이브러리 정보를 추가한다.
  - 기존의 spring-context 라이브러리를 제거한다.
  - webmvc 라이브러리가 context 라이브러리를 의존하기 때문에 자동으로 포함된다.
- `gradle eclipse` 실행한다.
- 이클립스IDE에서 프로젝트를 갱신한다.

### 2단계 - 스프링에서 제공하는 프론트 컨트롤러를 사용한다.

- com.bitcamp.servlet.DispatcherServlet 클래스 삭제
- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경

### 3단계 - 페이지 컨트롤러를 스프링 규격에 맞춰서 정의한다.

- com.bitcamp.board.controller.XxxController 클래스 변경

### 4단계 - 서비스, DAO 객체의 역할을 설명하는 애노테이션으로 변경한다.

- com.bitcamp.board.dao.*Dao 클래스 변경
- com.bitcamp.board.service.*Service 클래스 변경