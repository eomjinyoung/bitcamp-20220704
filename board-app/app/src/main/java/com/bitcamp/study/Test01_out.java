package com.bitcamp.study;

import java.io.FileOutputStream;
import com.bitcamp.util.DataOutputStream;

public class Test01_out {

  public static void main(String[] args) throws Exception {
    FileOutputStream out = new FileOutputStream("test.data");
    DataOutputStream out2 = new DataOutputStream(out);

    byte b = 120;
    short s = 32000;
    int i = 1123456789;
    long l = 1234567812345678L;
    float f = 12.375f;
    double d = 12.375;
    boolean bool = true;
    String str1 = "ABCabc012가각간";
    String str2 = "홍길동";

    out2.writeByte(b);
    out2.writeShort(s);
    out2.writeInt(i);
    out2.writeLong(l);
    out2.writeFloat(f);
    out2.writeDouble(d);
    out2.writeBoolean(bool);
    out2.writeUTF(str1);
    out2.writeUTF(str2);

    out2.close();
    out.close();

    System.out.println("실행 완료!");
  }

}
