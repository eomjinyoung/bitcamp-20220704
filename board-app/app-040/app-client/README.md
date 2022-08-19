# 040. 네트워킹을 이용한 파일 공유: client/server app. 아키텍처로 전환

## 작업 내용

### 1단계 - client/server 프로젝트로 분리한다.
 
- board-app/app-client 프로젝트 폴더를 준비한다.
- board-app/app-server 프로젝트 폴더를 준비한다.

### 2단계 - client 프로젝트를 Eclipse IDE로 임포트 한다.

- `gradle eclipse` 명령을 수행하여 이클립스 설정 파일을 준비한다.
- 이클립스에서 임포트 한다.

### 3단계 - ClientApp 클래스를 생성한다.

- com.bitcamp.board.ClientApp 클래스 생성
  - App 클래스에서 클라이언트 기능을 가져온다.

### 4단계 - XxxHandler 클래스에 통신 기능을 넣는다.

- com.bitcamp.board.XxxHandler 클래스 변경
  - 데이터를 처리할 때 서버에 요청한다.
- com.bitcamp.board.dao.XxxDao 클래스 삭제
  - 데이터 관리는 서버에서 수행하기 때문에 클라이언트에서 제거한다.
  

