### 082. Spring WebMVC 프레임워크 사용법

## 작업 내용

### 1단계 - @RequestMapping 애노테이션으로 요청 URL을 합성하는 방법

- com.bitcamp.board.controller.XxxxController 클래스 변경

### 2단계 - 스프링에서 제공하는 CharacterEncodingFilter로 교체한다.

- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경
- LoginCheckFilter, AdminCheckFilter 도 자바 코드로 등록한다.