// FileOutputStream: 문자열 출력
package com.bitcamp.study;

import java.io.FileOutputStream;

public class Test14_out {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("test8.data");

    String name = "ABCabc012가각간";
    String gender = "man";

    byte[] bytes = name.getBytes("UTF-8"); 
    out.write(bytes.length >> 24);
    out.write(bytes.length >> 16);
    out.write(bytes.length >> 8);
    out.write(bytes.length);
    out.write(bytes);

    bytes = gender.getBytes("UTF-8"); 
    out.write(bytes.length >> 24);
    out.write(bytes.length >> 16);
    out.write(bytes.length >> 8);
    out.write(bytes.length);
    out.write(bytes);

    out.close();

    System.out.println("실행 완료!");
  }

}
