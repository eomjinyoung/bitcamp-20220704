### 058. 서블릿이 사용할 자원을 공유하기

## 작업 내용

### 1단계 - DAO 객체를 여러 서블릿이 공유하게 만든다.

- com.bitcamp.board.servlet.AppInitServlet 클래스 추가
- com.bitcamp.board.servlet.XxxServlet 클래스 변경

### 2단계 - 요청하지 않아도 서블릿 객체가 자동으로 생성되게 한다.

- com.bitcamp.board.servlet.AppInitServlet 클래스 변경
  - @WebServlet 애노테이션에 자동 로딩 설정 추가
