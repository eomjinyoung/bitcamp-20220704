package com.bitcamp.util;

public class ObjectList {

  private static final int DEFAULT_CAPACITY = 10;

  private int size;
  private Object[] elementData;

  public ObjectList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public ObjectList(int initialCapacity) {
    elementData = new Object[initialCapacity];
  }

  public void add(Object e) {
    if (size == elementData.length) {
      grow();
    }

    elementData[size++] = e;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = elementData[i];
    }
    return arr;
  }

  public Object get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }

    return elementData[index];
  }

  public boolean remove(int index) {
    if (index < 0 || index >= size) {
      return false;
    }

    // 삭제할 항목의 다음 항목을 앞으로 당긴다.
    for (int i = index + 1; i < size; i++) {
      elementData[i - 1] = elementData[i];
    }

    // 목록의 개수를 한 개 줄인 후 
    // 맨 뒤의 있던 항목의 주소를 0으로 설정한다.
    elementData[--size] = null;

    return true;
  }

  public int size() {
    return size;
  }

  private void grow() {
    int newCapacity = elementData.length + (elementData.length >> 1);
    Object[] newArray = new Object[newCapacity];
    for (int i = 0; i < elementData.length; i++) {
      newArray[i] = elementData[i];
    }
    elementData = newArray;
  }
}








