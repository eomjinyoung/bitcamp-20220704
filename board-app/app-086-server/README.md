### 086. Mybatis SQL 매퍼 사용하기 II: DAO 구현 자동화

## 작업 내용

### 1단계 - DAO 구현체를 자동으로 생성하도록 설정한다.

- com.bitcamp.board.config.MybatisConfig 클래스 변경
  - @MapperScan 애노테이션 지정
- com.bitcamp.board.dao.MybatisMemberDao 클래스 삭제
- com.bitcamp.board.dao.MybatisBoardDao 클래스 삭제
- com.bitcamp.board.dao.MemberDao 인터페이스 변경
  - findByEmailPassword() 메서드에 @Param 애노테이션 지정

### 2단계 - 트랜잭션을 애노테이션을 설정한다.

- com.bitcamp.board.config.DatabaseConfig 클래스 변경
  - @EnableTransactionManagement 애노테이션 설정
- com.bitcamp.board.service.DefaultMemberService 클래스 변경
  - @Transactional 적용
- com.bitcamp.board.service.DefaultBoardService 클래스 변경
  - @Transactional 적용

### 3단계 - DB 정보를 별도의 파일로 분리한다.

- src/main/resources/jdbc.properties 파일 생성
- com.bitcamp.board.config.DatabaseConfig 클래스 변경
  - @PropertySource 애노테이션으로 jdbc.properties 파일 지정
  - @Value 애노테이션을 사용하여 jdbc.properties 값을 가져오기
