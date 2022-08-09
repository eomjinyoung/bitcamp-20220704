// FileOutputStream: write(int) 사용법 
package com.bitcamp.study;

import java.io.FileOutputStream;

public class Test02_out {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("test2.data");

    // 4바이트 출력
    out.write(3278 >> 24); //       00|000cce
    out.write(3278 >> 16); //     0000|0cce
    out.write(3278 >> 8);  //   00000c|ce
    out.write(3278);       // 00000cce|

    out.close();

    System.out.println("실행 완료!");
  }

}
