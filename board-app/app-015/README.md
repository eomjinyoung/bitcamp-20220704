# 015. 공통 코드(필드,메서드)를 공유하는 방법 : 상속 


## 작업 내용

### 1단계 - BoardList와 MemberList의 공통 필드와 메서드를 찾아 분리한다.

- com.bitcamp.util.ObjectList 클래스 생성
  - 여러 프로젝트에서 사용할 수 있도록 패키지를 조정한다.

### 2단계 - ObjectList를 상속 받아 BoardList와 MemberList를 정의한다.

- com.bitcamp.board.dao.BoardList 클래스 변경
- com.bitcamp.board.dao.MemberList 클래스 변경
  - ObjectList를 상속 받은 후 몇몇의 메서드를 오버라이딩 할 필요가 있음 확인하기 위해 기능을 변경한다.
  - 회원 번호 대신 이메일로 찾고 삭제하도록 변경한다.

### 3단계 - 상속의 일반화를 통해 구조가 변경된 것에 맞춰 XxxHandler를 변경한다.

- com.bitcamp.board.handler.BoardHandler 클래스 변경
- com.bitcamp.board.handler.MemberHandler 클래스 변경