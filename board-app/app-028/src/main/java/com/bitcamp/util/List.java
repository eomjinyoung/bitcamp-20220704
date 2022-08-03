package com.bitcamp.util;

/**
 * 인덱스를 기반으로 목록을 다루는 메서드의 규격을 정한다.
 * @author bitcamp
 *
 */
public interface List {
  // 메서드 형식
  // - 추상 메서드 형태
  // - 무조건 public 으로 공개

  void add(Object value); // 목록에 값을 더하는 메서드의 형식
  Object get(int index); // 목록에서 인덱스에 해당하는 항목을 꺼내는 메서드의 형식
  Object remove(int index); // 목록에서 인덱스에 해당하는 항목을 삭제하는 메서드의 형식
  Object[] toArray(); // 목록에 저장된 항목들을 배열에 담아 리턴하는 메서드의 형식
  int size(); // 목록에 저장된 항목의 개수를 리턴하는 메서드의 형식
}
