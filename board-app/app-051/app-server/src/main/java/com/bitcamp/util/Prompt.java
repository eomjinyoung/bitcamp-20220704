/*
 * 키보드 입력을 받는 도구를 구비하고 있다.
 */
package com.bitcamp.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Prompt {

  DataInputStream in;
  DataOutputStream out;

  public Prompt(DataInputStream in, DataOutputStream out) {
    this.in = in;
    this.out = out;
  }

  public int inputInt() throws Exception {
    String str = in.readUTF();
    return Integer.parseInt(str); 
  }

  public int inputInt(String title) throws Exception {
    out.writeUTF(title);
    String str = in.readUTF();
    return Integer.parseInt(str);
  }

  public String inputString() throws Exception {
    return in.readUTF();
  }

  public String inputString(String title) throws Exception {
    out.writeUTF(title);
    return in.readUTF();
  }
}




