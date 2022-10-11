### 079. Spring IoC 컨테이너 도입하기: 페이지 컨트롤러 생성 자동화

## 작업 내용

### 1단계 - Spring IoC 컨테이너 프레임워크를 프로젝트에 추가한다.

- search.maven.org 에서 spring-context 라이브러리 검색한다.
- 빌드 스크립트 파일(build.gradle)에 의존 라이브러리 정보를 추가한다.
- `gradle eclipse` 실행한다.
- 이클립스IDE에서 프로젝트를 갱신한다.

### 2단계 - Spring IoC 컨테이너의 설정을 수행하는 자바 클래스를 정의한다.

- com.bitcamp.board.config.AppConfig 클래스 정의

