### 076. 트랜잭션 관리자 역할을 별도의 클래스로 분리하기

## 작업 내용

### 1단계 - 트랜잭션 제어에 필요한 값을 담을 보관소를 만든다.

- com.bitcamp.transaction.TransactionStatus 클래스 생성

### 2단계 - 트랜잭션 관리자 역할을 수행할 클래스를 정의한다.

- com.bitcamp.transaction.TransactionManager 클래스 생성

### 3단계 - 서비스 객체에 DataSource 대신 트랜잭션 관리자를 주입한다.

- com.bitcamp.board.listener.ContextLoaderListener 클래스 변경

### 4단계 - 트랜잭션 관리자를 이용하여 트랜잭션을 처리한다.

- com.bitcamp.board.service.DefaultBoardService 클래스 변경
