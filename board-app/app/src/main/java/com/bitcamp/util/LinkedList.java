package com.bitcamp.util;

public class LinkedList extends AbstractList {

  private Node head; // 첫 노드의 주소를 저장
  private Node tail; // 마지막 노드의 주소를 저장

  @Override
  public void add(Object value) {
    Node node = new Node(value);

    size++; // 목록의 크기를 한 개 증가시킨다.

    if (tail == null) {
      head = tail = node; // 첫 노드를 등록한다.
      return;
    }


    tail.next = node; // 리스트 끝에 새 노드를 연결한다.
    node.prev = tail; // 새 노드가 현재의 끝 노드를 가리키게 한다. 

    tail = node; // 새 노드를 끝 노드로 만든다.
  }

  @Override
  public Object get(int index) {

    // 인덱스의 유효 여부 검사
    if (index < 0 || index >= size) {
      throw new ListException("인덱스의 범위를 초과했습니다!");
    }

    // 인덱스에 해당하는 노드를 찾을 때 head 부터 시작한다. 
    Node cursor = head;

    // 지정된 인덱스의 노드 주소를 알아낸다.
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    // cursor가 가리키는 노드의 값을 꺼내 리턴한다.
    return cursor.value;
  }

  @Override
  public Object remove(int index) {

    // 인덱스의 유효 여부 검사
    if (index < 0 || index >= size) {
      throw new ListException("인덱스의 범위를 초과했습니다!");
    }

    // 목록 크기를 한 개 줄인다.
    size--;

    // 삭제할 값을 임시 보관하여 메서드를 리턴할 때 호출자에게 전달한다.
    Object deleted;

    if (head == tail) { // 마지막 남은 노드를 제거할 때
      deleted = head.value; // 노드를 삭제하기 전에 리턴할 수 있도록 값을 임시 보관한다.
      head.value = null; // 노드에 들어 있는 값 객체의 주소를 비운다.
      head = tail = null;
      return deleted; // 메서드를 종료할 때 호출자에게 삭제한 값을 리턴한다.
    }

    // 삭제할 노드를 찾기 위해 시작 노드를 head로 설정한다.
    Node cursor = head;

    // 지정된 인덱스의 노드 주소를 알아낸다.
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    // 찾은 노드의 앞, 뒤 노드를 바로 연결한다.
    if (cursor.prev != null) { // 맨 앞 노드가 아니라면
      cursor.prev.next = cursor.next; // 현재 노드의 다음 노드 주소를 이전 노드의 next 저장
    } else { // 맨 앞 노드라면
      head = cursor.next; // 삭제할 다음 노드를 시작 노드로 설정한다. 
      head.prev = null; // 시작 노드이기에 앞노드를 가리키지 않게 한다.
    }

    if (cursor.next != null) { // 마지막 노드가 아니라면
      cursor.next.prev = cursor.prev; // 현재 노드의 이전 노드 주소를 다음 노드의 prev 저장
    } else { // 마지막 노드라면 
      tail = cursor.prev; // 현재 커서의 이전 노드를 마지막 노드로 설정한다.
      tail.next = null; // 마지막 노드이기에 다음 노드를 가리키지 않게 한다.
    }

    // 삭제할 노드를 초기화시킨다.
    // => garbage 객체가 다른 garbage 객체를 참조하지 않게 한다.
    deleted = cursor.value; // 노드를 삭제하기 전에 노드에 들어 있는 값을 임시 보관해 둔다.
    cursor.value = null;
    cursor.prev = null;
    cursor.next = null;

    return deleted; // 메서드를 리턴할 때 삭제된 값을 호출자에게 전달한다.
  }

  @Override
  public Object[] toArray() {
    // 값을 담을 배열을 준비
    Object[] arr = new Object[size];

    // 노드를 따라 가면서 값을 꺼내 배열에 담는다.
    Node cursor = head;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }

    return arr;
  }

  // LinkedList 클래스에서만 사용할 클래스라면 
  // 이 클래스 안에 선언하는 것이 유지보수에 좋다.
  // 클래스 안에 정의된 클래스를 "중첩 클래스(nested class)"라 한다.
  // 
  // 다음과 같이 특정 인스턴스에 종속되지 않는 중첩 클래스라면 
  // static nested class(스태틱 중첩클래스)로 정의한다.
  // 
  private static class Node {
    Object value;
    Node prev;
    Node next;

    public Node(Object v) {
      this.value = v;
    }
  }

} // LinkedList 끝













