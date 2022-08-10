# 035. 자바에서 제공하는 데코레이터(중간에서 가공처리 일을 하는 객체)를 사용하기

## 작업 내용

### 1단계 - 기존의 DataInputStream/DataOutputStream 클래스를 자바 API로 교체한다.

- com.bitcamp.util.DataOutputStream 클래스 삭제
- com.bitcamp.util.DataInputStream 클래스 삭제
- com.bitcamp.board.dao.XxxDao 클래스 변경
  - 자바 stream api로 교체한다.

