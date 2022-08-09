package com.bitcamp.util;

import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStream implements AutoCloseable {
  FileInputStream in;

  public DataInputStream(FileInputStream in) {
    this.in = in;
  }

  @Override
  public void close() throws IOException {
    in.close();
  }

  public byte readByte() throws Exception {
    return (byte) in.read();
  }

  public short readShort() throws Exception {
    int result = (in.read() << 8) + in.read();
    return (short) result;
  }

  public int readInt() throws Exception {
    return (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();
  }

  public long readLong() throws Exception {
    return ((long)in.read() << 56) 
        + ((long)in.read() << 48) 
        + ((long)in.read() << 40)
        + ((long)in.read() << 32)
        + ((long)in.read() << 24)
        + ((long)in.read() << 16)
        + ((long)in.read() << 8)
        + in.read();
  }

  public float readFloat() throws Exception {
    int value = readInt();
    return Float.intBitsToFloat(value);
  }

  public double readDouble() throws Exception {
    long value = readLong();
    return Double.longBitsToDouble(value);
  }

  public boolean readBoolean() throws Exception {
    return in.read() == 1 ? true : false;
  }

  public String readUTF() throws Exception {
    int len = readInt();
    byte[] bytes = new byte[len];
    in.read(bytes);
    return new String(bytes, "UTF-8");
  }


}






