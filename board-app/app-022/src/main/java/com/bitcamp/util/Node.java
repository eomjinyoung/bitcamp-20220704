package com.bitcamp.util;

/**
 * 연결 리스트의 각 항목의 값을 저장하는 일을 할 클래스다.
 * @author bitcamp
 *
 */
public class Node {
  Object value;
  Node prev;
  Node next;

  public Node() {}

  public Node(Object v) {
    this.value = v;
  }
}





