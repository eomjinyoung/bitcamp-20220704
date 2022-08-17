# 040. 네트워킹을 이용한 파일 공유: client/server app. 아키텍처로 전환

## 작업 내용

### 1단계 - client/server 프로젝트로 분리한다.

- board-app/app-client 프로젝트 폴더를 준비한다.
- board-app/app-server 프로젝트 폴더를 준비한다.

### 2단계 - server 프로젝트를 Eclipse IDE로 임포트 한다.

- `gradle eclipse` 명령을 수행하여 이클립스 설정 파일을 준비한다.
- 이클립스에서 임포트 한다.

### 3단계 - ServerApp 클래스를 생성한다.

- com.bitcamp.board.ServerApp 클래스 생성
  - App 클래스에서 서버 기능을 가져온다.

### 4단계 - XxxServlet 클래스를 추가한다.

- com.bitcamp.servlet.Servlet 인터페이스 추가
  - 클라이언트 요청을 다룰 객체의 사용 규칙을 정의한다.
- com.bitcamp.board.servlet.XxxServlet 클래스 추가
  - 기존의 XxxHandler의 코드를 가져와서 변경한다.
  - 클라이언트 요청에 응답하는 일을 수행한다.
- com.bitcam.board.dao.XxxDao 클래스 변경
  - update() 메서드 추가한다.
- com.bitcamp.util.Prompt 클래스 삭제
  - 서버에서는 해당 클래스가 필요 없다.

