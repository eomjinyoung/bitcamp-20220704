### 082. Spring WebMVC 프레임워크 사용법

## 작업 내용

### 1단계 - @RequestMapping 애노테이션으로 요청 URL을 합성하는 방법

- com.bitcamp.board.controller.XxxxController 클래스 변경

### 2단계 - 스프링에서 제공하는 CharacterEncodingFilter로 교체한다.

- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경
- LoginCheckFilter, AdminCheckFilter 도 자바 코드로 등록한다.

### 3단계 - 요청 핸들러의 파라미터 및 리턴 값을 조정한다.

- com.bitcamp.board.controller.XxxxController 클래스 변경
  - 요청을 처리하는 메서드에 필요한 값만 파라미터로 받는다.
  - 요청 파라미터 값을 핸들러의 파라미터로 직접 받을 수 있다.: @RequestParam
  - @RequestParam 을 생략할 수 있는 경우
  - 첨부파일을 파라미터로 직접 받을 수 있다.
  - ServletContext를 받는 방법: 생성자를 통해 주입 받는다. 
  - Part 대신 스프링에서 제공하는 MultipartFile 타입으로 첨부파일을 받는다.
  - 낱개의 파라미터 값을 도메인 객체로 바로 받을 수 있다.
    - 단, multipart/form-data 형식으로 전송된 데이터를 처리하려면 MultipartResolver를 설정해야 한다.
  - ServletRequest 보관소에 작업 결과를 저장할 때 페이지 컨트롤러에서 하는 대신 프론트 컨트롤러에서 하기: ModelAndView, Model, Map 클래스
  - 기본 ViewResolver를 InternalResourceViewResolver로 교체한다.
    - 접두사, 접미사를 이용하여 JSP 주소를 완성할 수 있다.
    - InternalResourceViewResolver를 설정해야 한다.
- com.bitcamp.board.config.AppConfig 클래스 변경
  - createMultipartResolver() 메서드 추가
  - createViewResolver() 메서드 추가

### 4단계 - JSP 파일을 /WEB-INF 밑에 두어 직접 접근하지 못하도록 만든다.

- /WEB-INF/jsp 디렉토리 생성
  - 기존의 JSP 파일을 이 디렉토리로 옮긴다.
- com.bitcamp.board.config.AppConfig 클래스 변경
  - createViewResolver() 메서드 변경