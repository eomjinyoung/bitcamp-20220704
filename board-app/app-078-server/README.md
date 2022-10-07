### 078. 페이지 컨트롤러를 POJO로 전환하기

## 작업 내용

### 1단계 - 페이지 컨트롤러의 사용 규칙을 정의한다.

- com.bitcamp.servlet.Controller 인터페이스 생성

### 2단계 - Controller 규칙에 따라 페이지 컨트롤러를 변경한다.

- com.bitcamp.board.controller.XxxController 클래스 변경

### 3단계 - ContextLoaderListener 에서 페이지 컨트롤러를 생성한다.

- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경

### 4단계 - 클라이언트 요청이 들어 왔을 때 Controller 규칙에 따라 페이지 컨트롤러를 실행한다.

- com.bitcamp.servlet.DispatcherServlet 클래스 변경