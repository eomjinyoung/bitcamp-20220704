# 025. 추상 클래스를 활용하여 인터페이스의 일부를 미리 구현하기


## 작업 내용

### 1단계 - List 규격에 맞춰 AbstractList를 구현한다.

- com.bitcamp.util.AbstractList 추상클래스 생성
  - size 필드와 size() 메서드를 구현한다.

  
### 2단계 - ObjectList와 LinkedList는 AbstractList를 상속한다.

- com.bitcamp.util.ObjectList 클래스 변경
  - AbstractList가 구현하지 않은 List의 나머지 메서드를 구현한다.
- com.bitcamp.util.LinkedList 클래스 변경
  - AbstractList가 구현하지 않은 List의 나머지 메서드를 구현한다.