package com.bitcamp.study;

import java.io.FileInputStream;
import com.bitcamp.util.DataInputStream;

public class Test01_in {

  public static void main(String[] args) throws Exception {
    FileInputStream in = new FileInputStream("test.data");
    DataInputStream in2 = new DataInputStream(in);

    byte b = in2.readByte();
    short s = in2.readShort();
    int i = in2.readInt();
    long l = in2.readLong();
    float f = in2.readFloat();
    double d = in2.readDouble();
    boolean bool = in2.readBoolean();
    String str1 = in2.readUTF();
    String str2 = in2.readUTF();

    System.out.println(b);
    System.out.println(s);
    System.out.println(i);
    System.out.println(l);
    System.out.println(f);
    System.out.println(d);
    System.out.println(bool);
    System.out.println(str1);
    System.out.println(str2);

    in2.close();
    in.close();

    System.out.println("실행 완료!");
  }

}
