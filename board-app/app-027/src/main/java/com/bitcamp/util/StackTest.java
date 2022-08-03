package com.bitcamp.util;

public class StackTest {
  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push("홍길동");
    stack.push("임꺽정");
    stack.push("유관순");
    stack.push("안중근");

    // 스택에서 값을 꺼내기 전에 스택에 저장된 값을 문자열로 출력한다.
    System.out.println(stack); 
    // println()은 stack에 대해 toString()을 호출한 후 그 리턴 값을 출력한다. 

    while (!stack.empty()) {
      System.out.println(stack.pop());
    }

  }
}
