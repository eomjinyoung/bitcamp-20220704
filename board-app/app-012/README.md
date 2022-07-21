# 012. 인스턴스 목록을 다루는 코드를 분리: High Cohesion 구현(재사용성 강화)


## 작업 내용

### 1단계 - BoardHandler에서 인스턴스 목록을 다루는 코드를 분리한다.

- com.bitcamp.board.BoardHandler 클래스 변경
  - 목록과 관련된 필드를 BoardList 클래스로 옮긴다.
  - 각 메서드에서 데이터 목록을 다루는 코드를 BoardList 클래스로 옮긴다.
- com.bitcamp.board.BoardList 클래스 추가
  - 관련 필드와 메서드를 정의한다.
- com.bitcamp.board.App 클래스 변경
  - BoardHandler의 생성자 변경에 맞춰 코드 변경

