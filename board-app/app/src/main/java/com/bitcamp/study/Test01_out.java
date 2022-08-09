// FileOutputStream: write(int) 사용법 
package com.bitcamp.study;

import java.io.FileOutputStream;

public class Test01_out {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("test.data");

    // 1바이트 출력
    out.write(3278); // 0x00000cce

    out.close();

    System.out.println("실행 완료!");
  }

}
