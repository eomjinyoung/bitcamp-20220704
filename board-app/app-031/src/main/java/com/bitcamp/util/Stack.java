package com.bitcamp.util;

public class Stack<E> extends LinkedList<E> {

  public void push(E value) {
    add(value); 
  }

  public E pop() {
    return remove(size() - 1);
  }

  public boolean empty() { 
    return size() == 0;
  }

  public E peek() { 
    return get(size() - 1);
  }

  @Override
  public String toString() {
    Iterator<E> iterator = iterator();
    StringBuffer buf = new StringBuffer();

    while (iterator.hasNext()) {
      if (buf.length() > 0) { 
        buf.append(" > ");
      }
      buf.append(iterator.next());
    }

    return buf.toString();
  }
}





