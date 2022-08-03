package com.bitcamp.util;

public class Stack extends LinkedList {

  // 비록 push()나 pop() 메서드는 
  // LinkedList의 메서드를 호출하는 껍데기 불과하지만 
  // 스택이라는 개념을 명확하게 표현할 수 있어서 
  // 이렇게 별도의 메서드로 구현하는 것이다.
  //

  // 스택의 맨 마지막에 값을 추가한다.
  public void push(Object value) {
    add(value); // 수퍼 클래스의 메서드를 호출하여 push() 기능을 구현한다.
  }

  // 스택의 맨 마지막 값을 꺼낸다. 꺼낸 값은 스택에서 제거한다.
  public Object pop() {
    return remove(size() - 1); // 수퍼 클래스의 메서드를 호출하여 pop() 기능을 구현한다.
  }

  //스택이 비어 있는지 여부를 알려준다.
  public boolean empty() { 
    return size() == 0;
  }

  //스택에 맨 마지막에 저장된 값을 리턴한다. 제거하지 않는다.
  public Object peek() { 
    return get(size() - 1);
  }

  @Override
  public String toString() {
    // 스택에 저장된 객체를 순서대로 꺼내 문자열로 저장한다.
    StringBuffer buf = new StringBuffer();

    for (int i = 0; i < size(); i++) { // 스택에 저장된 개수만큼 반복한다.
      if (buf.length() > 0) { // 이미 버퍼에 저장된 문자열이 있다면
        buf.append(" > ");
      }
      buf.append(get(i));
    }

    return buf.toString();
  }
}





