# 039. JSON 형식으로 데이터 입출력하기: Gson 라이브러리 사용

## 작업 내용

### 1단계 - 프로젝트에 google-gson 라이브러리를 포함한다.

- board-app/app/build.gradle 변경
  - search.maven.org 사이트에서 gson 라이브러리를 찾는다.
  - dependencies{} 블록에 gson 라이브러리 설정을 추가한다.
- 이클립스의 프로젝트 설정 파일(.classpath)에 라이브러리 정보를 추가한다.
  - CLI에서 `gradle eclipse` 를 실행한다.
  - 이클립스 프로젝트를 리프래시 한다.

### 2단계 - XxxDao에 Gson 라이브러리를 적용한다.

- com.bitcamp.board.dao.XxxDao 클래스 변경
  - save(), load() 메서드에서 Gson 라이브러리를 사용하여 JSON 데이터를 다룬다.
