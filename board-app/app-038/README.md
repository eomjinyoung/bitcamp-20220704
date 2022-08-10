# 038. 리팩토링: Factory Method 패턴, Information Expert 패턴

## 작업 내용

### 1단계 - Board 클래스에 팩토리 메서드를 추가한다.

- com.bitcamp.board.domain.Board 클래스 변경
  - 팩토리 메서드 create()를 추가한다.
  - 즉 CSV 데이터를 가지고 객체를 생성하는 복잡한 로직을 캡슐화 한다.

### 2단계 - CSV 데이터를 가지고 객체를 생성할 Board 클래스를 사용한다.

- com.bitcamp.board.dao.BoardDao 클래스 변경
  - load() 메서드에서 CSV 데이터를 처리할 때 팩토리 메서드를 호출한다.

### 3단계 - Board 클래스에 CSV 데이터를 생성하는 메서드를 추가한다.

- com.bitcamp.board.domain.Board 클래스 변경
  - toCsv()를 추가한다.
    - 필드를 알고 있는 것은 Board 클래스이기 때문에 필드의 값을 가지고 CSV 형식의 데이터를 생성하는 것도 Board 클래스가 할 일이다.
    - GRASP 패턴의 Information Expert 패턴

### 4단계 - CSV 데이터를 출력할 때 Board 클래스를 사용한다.

- com.bitcamp.board.dao.BoardDao 클래스 변경
  - save() 메서드 변경

### 5단계 - Member와 MemberDao도 마찬가지로 변경한다.



