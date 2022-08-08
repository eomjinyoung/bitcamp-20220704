# 032. 기존 List 구현체를 자바 컬렉션 API로 교체하기: java.util 패키지의 클래스 사용

## 작업 내용

### 1단계 - 목록 관련 클래스나 인터페이스를 java.util 패키지의 멤버로 교체한다.

- com.bitcamp.util.Iterator 인터페이스 삭제
- com.bitcamp.util.List 인터페이스 삭제
- com.bitcamp.util.AbstractList 추상 클래스 삭제
- com.bitcamp.util.ObjectList 클래스 삭제
- com.bitcamp.util.LinkedList 클래스 삭제
- com.bitcamp.util.Stack 클래스 삭제
- com.bitcamp.util.ListException 클래스 삭제
- com.bitcamp.board.App 클래스 변경
- com.bitcamp.board.dao.XxxDao 클래스 변경