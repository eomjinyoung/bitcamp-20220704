### 057. 웹 애플리케이션 서버를 자바 표준 웹 기술로 대체하기: Servlet/JSP

## 작업 내용

### 1단계 - 톰캣 서버를 다운로드 하여 설치한다.

- tomcat.apache.org 사이트에서 다운로드 한다.
- 로컬에 압축을 푼다.

### 2단계 - 톰캣 서버를 이클립스IDE에 등록한다.

- Window > Preferences > Server > Runtime Environments > Add

### 3단계 - 프로젝트를 배포할 때 사용할 서버 작업 환경을 준비한다.

- Servers 뷰 > 새 서버 등록

### 4단계 - 톰캣 서버에 배포할 수 있는 웹 애플리케이션으로 전환한다.

- build.gradle 변경
  - id 'eclipse-wtp' 플러그인 추가 : 웹 애플리케이션 관련 설정 파일을 추가로 생성한다.
  - id 'war' 플러그인 추가 : .war 배포 파일을 생성한다.
  - 웹 애플리케이션 관련 설정 추가
  - `gradle cleanEclipse` 실행 : 이클립스 설정 파일 삭제
  - `gradle eclipse` 실행 : 이클립스 설정 파일 재생성

### 5단계 - 웹 애플리케이션을 서버에 배포한다.

- Servers 뷰 > 서버 실행 환경 선택 > 웹 프로젝트 추가

### 6단계 - 웹 애플리케이션 개발에 필요한 자바 표준 웹 라이브러리를 프로젝트에 추가한다.

- search.maven.org 에서 servlet-api 라이브러리를 찾아 추가한다.
  - build.gradle 변경 
  - `gradle eclipse` 실행
  - 프로젝트 갱신

### 7단계 - WelcomeHandler 클래스를 자바 표준 웹 기술에 맞춰 변경한다.

- com.bitcamp.board.servlet.WelcomeServlet 클래스 추가
  - WelcomeHandler 클래스를 복사해 온다.
  - Servlet 규칙에 따라 변경한다.