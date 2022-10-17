### 084. Root IoC 컨테이너와 멀티 프론트 컨트롤러 사용법

## 작업 내용

### 1단계 - Root IoC 컨테이너의 java config 를 정의한다.

- com.bitcamp.board.config.RootConfig 클래스 생성
- com.bitcamp.board.config.DatabaseConfig 클래스 생성
- com.bitcamp.board.config.AppWebApplicationInitializer 클래스 변경

### 2단계 - '/app/*' 요청 처리 프론트 컨트롤러를 설정한다.

- com.bitcamp.board.config.AppWebConfig 클래스 생성
- com.bitcamp.board.config.AppWebApplicationInitializer 클래스 변경

### 3단계 - '/admin/*' 요청 처리 프론트 컨트롤러를 설정한다.

- com.bitcamp.board.config.AdminWebConfig 클래스 생성
- com.bitcamp.board.config.AdminWebApplicationInitializer 클래스 생성
- /webapp/welcome.jsp 변경

