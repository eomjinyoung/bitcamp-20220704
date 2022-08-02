# 021. 공통 코드(필드,메서드)를 공유하는 방법 : 연관(association)


## 작업 내용

### 0단계 - 프로젝트 소스 준비

- 019 버전 소스를 가져온다.

### 1단계 - ObjectList를 상속하는 대신 연관(포함) 관계로 바꾼다.

- com.bitcamp.board.dao.BoardList 클래스 변경
  - ObjectList를 포함하는 관계로 바꾼다.
  - 기능을 ObjectList 로 위임할 수 있도록 메서드를 추가, 변경한다.
  - 서브 클래스가 아닌 관계로 클래스 이름을 BoardDao로 변경한다.
  - 메서드 이름도 데이터를 다루는 이름으로 적절하게 변경한다.
    - 기존의 ObjectList 는 인스턴스를 다룬다는 의미로 메서드 이름도 그에 맞춰서 지었다.
    - BoardDao은 인스턴스라는 기술적인 용어 대신 데이터에 초점을 맞춘다.
    - 따라서 데이터에 초점을 맞춘 메서드 이름으로 변경한다.
- com.bitcamp.board.dao.MemberList 클래스 변경
  - BoardList를 변경한 것과 똑같이 처리한다.

### 2단계 - BoardDao와 MemberDao에 맞춰 XxxHandler를 변경한다.

- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - BoardList 대신 ObjectList에 의존하고 있는 BoardDao를 사용한다.
- com.bitcamp.board.handler.MemberHandler 클래스 변경
  - MemberList 대신 ObjectList에 의존하고 있는 MemberDao를 사용한다.