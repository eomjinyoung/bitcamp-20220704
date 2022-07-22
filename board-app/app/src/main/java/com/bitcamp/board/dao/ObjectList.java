package com.bitcamp.board.dao;

public class ObjectList {

  private static final int DEFAULT_SIZE = 3;

  private int length; 
  private Object[] list; 

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
}







