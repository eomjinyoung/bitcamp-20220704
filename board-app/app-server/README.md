### 082. Spring WebMVC 프레임워크 사용법

## 작업 내용

### 1단계 - @RequestMapping 애노테이션으로 요청 URL을 합성하는 방법

- com.bitcamp.board.controller.XxxxController 클래스 변경

### 2단계 - 스프링에서 제공하는 CharacterEncodingFilter로 교체한다.

- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경
- LoginCheckFilter, AdminCheckFilter 도 자바 코드로 등록한다.

### 3단계 - 요청 핸들러의 파라미터 값을 조정한다.

- com.bitcamp.board.controller.XxxxController 클래스 변경
  - 요청을 처리하는 메서드에 필요한 값만 파라미터로 받는다.
  - 요청 파라미터 값을 핸들러의 파라미터로 직접 받을 수 있다.: @RequestParam
  - @RequestParam 을 생략할 수 있는 경우