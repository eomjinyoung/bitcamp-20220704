// FileInputStream: boolean 값 읽기
package com.bitcamp.study;

import java.io.FileInputStream;

public class Test13_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test7.data");

    boolean b1 = in.read() == 1 ? true : false;
    boolean b2 = in.read() == 1 ? true : false;

    System.out.println(b1);
    System.out.println(b2);

    in.close();

    System.out.println("실행 완료!");
  }

}
