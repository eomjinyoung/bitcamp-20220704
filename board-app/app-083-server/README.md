### 083. Spring WebMVC 프레임워크 사용법 II : 기타 설정

## 작업 내용

### 1단계 - 웹 애플리케이션의 context path를 / 로 지정한다.

- Eclipse IDE에서 처리
- 프론트 컨트롤러의 경로를 /service 대신 /app으로 변경
  - ContextLoaderListener 변경
- JSP의 링크 경로를 조정

### 2단계 - ServletContextInitializer 사용법

- WebApplicationInitializer 인터페이스 구현
- AbstractContextLoaderInitializer 추상클래스 상속 받아 구현
- AbstractDispatcherServletInitializer 추상클래스 상속 받아 구현
- AbstractAnnotationConfigDispatcherServletInitializer 추상클래스 상속 받아 구현


