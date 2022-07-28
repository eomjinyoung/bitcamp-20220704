/*
 * 키보드 입력을 받는 도구를 구비하고 있다.
 */
package com.bitcamp.util;

public class Prompt {

  private static java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

  public static int inputInt() {
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str); //"123" ==> 123, "5" ==> 5, "ok" ==> 실행 오류!
  }

  public static int inputInt(String title) {
    System.out.print(title);
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str);
  }

  public static String inputString() {
    return keyboardInput.nextLine();
  }

  public static String inputString(String title) {
    System.out.print(title);
    return keyboardInput.nextLine();
  }

  public static void close() {
    keyboardInput.close();
  }
}
