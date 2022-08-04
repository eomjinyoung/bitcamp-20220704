# 029. 추상 클래스를 사용하여 핸들러의 공통 기능 구현하기: 템플릿 메서드 패턴 적용


## 작업 내용

### 1단계 - Handler 규격에 맞춰 구현체를 제작한다.

- com.bitcamp.handler.AbstractHandler 추상 클래스 생성
  - Handler 규격에 맞춰 메서드를 구현한다.
  - 템플릿 메서드 패턴을 적용한다.

### 2단계 - AbstractHandler를 상속 받아서 BoardHandler, MemberHandler를 만든다.

- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - service() 추상 메서드 구현
- com.bitcamp.board.handler.MemberHandler 클래스 변경
  - service() 추상 메서드 구현