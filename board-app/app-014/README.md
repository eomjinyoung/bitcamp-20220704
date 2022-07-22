# 014. 패키지를 이용하여 클래스를 분류하는 방법 + 접근 제어 조정


## 작업 내용

### 1단계 - 데이터 타입에 해당하는 클래스를 별도의 패키지로 분류한다.

- com.bitcamp.board.domain 패키지 생성
  - 데이터 타입을 담는 패키지 명
    - domain|vo(value object)|dto(data transfer object)
  - Board, Member 클래스를 이 패키지로 옮긴다.
    - 접근 범위를 조정해야 한다.
    - public: 모두 공개
    - protected: 같은 패키지 + 자식 클래스
    - (default): 같은 패키지
    - private: 그 멤버를 가지고 있는 클래스 안에서만 접근 가능

### 2단계 - 데이터의 저장과 조회를 다루는 클래스를 별도의 패키지로 분류한다.

데이터의 저장과 조회를 "퍼시스턴스(persistence)" 라 부른다.

- com.bitcamp.board.dao 패키지 생성
  - XxxList 클래스를 이 패키지로 옮긴다.
  - 접근 범위를 조정한다.
    - 외부에 공개할 멤버(변수,메서드): public
    - 내부에서만 사용할 멤버: private 

### 3단계 - UI를 처리하는 클래스를 별도의 패키지로 분류한다.

- com.bitcamp.board.handler
  - XxxHandler 클래스를 이 패키지로 옮긴다.
  - 접근 범위를 조정한다.

### 4단계 - 유틸리티에 해당하는 클래스를 별도의 패키지로 분류한다.

- com.bitcamp.util 패키지 생성
  - Prompt 클래스를 이 패키지로 옮긴다.