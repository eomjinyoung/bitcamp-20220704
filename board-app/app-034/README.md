# 034. Primitive 타입 및 String 타입 데이터를 입출력하는 기능을 캡슐화하기: DataInputStream/DataOutputStream

## 작업 내용

### 1단계 - Primtive type 또는 String type을 바이트 또는 바이트 배열로 가공하여 출력하는 일을 할 클래스를 정의한다.

- com.bitcamp.util.DataOutputStream 클래스 생성

### 2단계 - 바이트 또는 바이트 배열을 읽어 Primitive type 또는 String type의 값으로 변환시켜줄 클래스를 정의한다.

- com.bitcamp.util.DataInputStream 클래스 생성

### 3단계 - XxxDao에서 데이터를 읽거나 쓸 때 DataInputStream/DataOutputStream을 사용한다.

- com.bitcamp.board.dao.XxxDAo 클래스 변경
