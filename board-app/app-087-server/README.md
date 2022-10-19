### 087. 프로젝트에 서블릿 컨테이너(예:톰캣) 삽입하기

## 작업 내용

### 1단계 - 삽입 용 톰캣 서버 라이브러리를 프로젝트에 추가한다.

- search.maven.org 에서 'tomcat-embed-jasper' 검색
- 빌드 스크립트 파일(build.gradle)에 등록
- `gradle eclipse` 실행해서 이클립스IDE 설정 파일을 갱신
- 이클립스IDE에서 'refresh'

### 2단계 - 톰캣 서버를 실행하는 메인 클래스를 정의한다.

- com.bitcamp.board.App 클래스 생성
