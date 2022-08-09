// FileOutputStream: boolean 값 출력
package com.bitcamp.study;

import java.io.FileOutputStream;

public class Test13_out {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("test7.data");

    boolean b1 = true;
    boolean b2 = false;

    out.write(b1 ? 1 : 0);
    out.write(b2 ? 1 : 0);

    out.close();

    System.out.println("실행 완료!");
  }

}
