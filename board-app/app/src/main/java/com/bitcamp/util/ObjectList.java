package com.bitcamp.util;

import java.lang.reflect.Array;

public class ObjectList<E> extends AbstractList<E> {

  private static final int DEFAULT_CAPACITY = 10;

  private Object[] elementData;

  public ObjectList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public ObjectList(int initialCapacity) {
    elementData = new Object[initialCapacity];
  }

  @Override // 인터페이스 규격에 따라 메서드를 정의하는 것도 오버라이딩으로 간주한다.
  public void add(E e) {
    if (size == elementData.length) {
      grow();
    }

    elementData[size++] = e;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = elementData[i];
    }
    return arr;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E[] toArray(E[] arr) {

    // 파라미터로 받은 배열이 목록에 저장된 항목의 개수 보다 작다면
    if (arr.length < size) { 

      // 파라미터로 받은 배열과 똑같은 타입의 배열을 만든다.
      // 단 크기는 size 에 지정한 개수 만큼 만든다.
      arr = (E[]) Array.newInstance(
          arr.getClass().getComponentType(), // 레퍼런스 배열의 항목 타입
          size  /* 배열의 개수*/);
    }

    // 목록에 있는 항목들을 파라미터로 받은 배열에 복사한다.
    for (int i = 0; i < size; i++) {
      arr[i] = (E) elementData[i];
    }

    return arr;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new ListException("인덱스가 무효함!");
    }
    return (E) elementData[index];
  }

  @SuppressWarnings("unchecked")
  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new ListException("인덱스가 무효합니다!");
    }

    // 삭제한 객체를 리턴할 수 있도록 임시 변수에 담아 둔다.
    E deleted = (E) elementData[index];

    for (int i = index + 1; i < size; i++) {
      elementData[i - 1] = elementData[i];
    }
    elementData[--size] = null;

    return deleted;
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








