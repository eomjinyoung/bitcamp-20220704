### 059. 공동 보관소를 사용하여 서블릿이 사용할 자원을 공유하기

## 작업 내용

### 1단계 - DAO 객체를 ServletContext 보관소에 저장한다.

- com.bitcamp.board.servlet.AppInitServlet 클래스 변경

### 2단계 - 서블릿은 DAO를 사용할 때 ServletContext에서 꺼낸다.

- com.bitcamp.board.servlet.*Servlet 클래스 변경