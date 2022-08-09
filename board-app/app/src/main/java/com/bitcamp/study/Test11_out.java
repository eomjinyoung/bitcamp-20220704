// FileOutputStream: byte, short, int, long 값 출력
package com.bitcamp.study;

import java.io.FileOutputStream;

public class Test11_out {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("test5.data");

    byte b = 100; // 0x64
    short s = 32000; // 0x7d00 
    int i = 1827568876; // 0x6cee7cec
    long l = 2345987655438181L; // 0x000855a9_d0d98f65

    // b 출력
    out.write(b); 

    // s 출력
    out.write(s >> 8);
    out.write(s);

    // i 출력
    out.write(i >> 24);
    out.write(i >> 16);
    out.write(i >> 8);
    out.write(i);

    // l 출력
    out.write((int)(l >> 56));
    out.write((int)(l >> 48));
    out.write((int)(l >> 40));
    out.write((int)(l >> 32));
    out.write((int)(l >> 24));
    out.write((int)(l >> 16));
    out.write((int)(l >> 8));
    out.write((int)l);

    out.close();

    System.out.println("실행 완료!");
  }

}
