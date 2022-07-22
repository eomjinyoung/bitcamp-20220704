package com.bitcamp.board.dao;

public class ObjectList {

  private static final int DEFAULT_SIZE = 3;

  // 서브 클래스에서 직접 접근할 수 있도록 접근 범위를 넓힌다.
  protected int length; 
  protected Object[] list; // protected: 같은 패키지 + 서브 클래스 

  public ObjectList() {
    this.list = new Object[DEFAULT_SIZE];
  }

  public ObjectList(int initCapacity) {
    this.list = new Object[initCapacity];
  }

  // 목록에 저장된 인스턴스를 꺼내서 리턴한다.
  public Object[] toArray() {
    Object[] arr = new Object[this.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  // 목록에서 지정된 인덱스의 값을 찾아 리턴한다.
  // => 목록에서 값을 꺼낼 때 인덱스에 기반해서 꺼낸다.
  // => 왜? 
  //    어떤 경우에는 번호가 아닌 이메일이나 아이디를 가지고 
  //    데이터를 꺼낼 수 있기 때문이다.
  public Object get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }
    return list[index];
  }

  public void add(Object obj) {
    if (this.length == this.list.length) {
      grow();
    }
    this.list[this.length++] = obj;
  }

  private void grow() {
    int newSize = this.list.length + (this.list.length >> 1);
    Object[] newArray = new Object[newSize];
    for (int i = 0; i < this.list.length; i++) {
      newArray[i] = this.list[i];
    }
    this.list = newArray;
  }

  public boolean remove(int index) {
    if (index < 0 || index >= this.length) {
      return false;
    }
    for (int i = index + 1; i < this.length; i++) {
      this.list[i - 1] = this.list[i];
    }
    this.list[--this.length] = null;
    return true;
  }
}















