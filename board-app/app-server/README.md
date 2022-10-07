### 077. Front Controller 디자인 패턴 도입하기

## 작업 내용

### 1단계 - 프론트 컨트롤러 역할을 수행할 클래스를 만든다.

- com.bitcamp.servlet.DispatcherServlet 클래스 생성

### 2단계 - 기존의 컨트롤러를 페이지 컨트롤러로 만든다.

- com.bitcamp.board.controller.XxxFormController 클래스 생성
- com.bitcamp.board.controller.XxxController 클래스 변경
- /webapp/xxx/*.jsp 변경
  - 서블릿 경로에 맞춰 링크의 경로를 변경한다.
