# 036. 인스턴스를 통째로 입출력하기(객체 직렬화): ObjectInputStream/ObjectOutputStream

## 작업 내용

### 1단계 - 도메인 클래스의 인스턴스 값을 직렬화 가능하도록 설정한다.

- com.bitcamp.board.domain.Board 클래스 변경
  - java.io.Serializable 인터페이스를 구현한다.
- com.bitcamp.board.domain.Member 클래스 변경
  - java.io.Serializable 인터페이스를 구현한다.

### 2단계 - ObjectInputStream/ObjectOutputStream 을 사용하여 객체를 통째로 입출력한다.

- com.bitcamp.board.dao.XxxDao 클래스 변경
  - DataOutputStream/DataInputStream 대신 ObjectOutputStream/ObjectInputStream 클래스를 사용하여 객체를 입출력한다.






