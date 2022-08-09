// FileInputStream: boolean 값 읽기
package com.bitcamp.study;

import java.io.FileInputStream;

public class Test14_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test8.data");

    byte[] arr = new byte[10000];
    int len = 0;

    len = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();
    in.read(arr, 0, len);
    String name = new String(arr, 0, len, "UTF-8");

    len = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();
    in.read(arr, 0, len);
    String gender = new String(arr, 0, len, "UTF-8");

    System.out.println(name);
    System.out.println(gender);

    in.close();

    System.out.println("실행 완료!");
  }

}
