### 075. DB 커넥션을 공유했을 때 발생하는 문제를 해결하기

## 작업 내용

### 1단계 - 스레드 전용 DB 커넥션을 제공해주는 일을 할 객체를 만든다.

- com.bitcamp.sql.DataSource 클래스 생성

### 2단계 - DAO에 DataSource 객체를 주입한다.

- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경

### 3단계 - DataSource에서 제공하는 Connection을 사용하여 데이터를 처리한다.

- com.bitcamp.board.dao.MariaDBBoardDao 클래스 변경
- com.bitcamp.board.dao.MariaDBMemberDao 클래스 변경
- com.bitcamp.board.service.DefaultBoardService 클래스 변경
