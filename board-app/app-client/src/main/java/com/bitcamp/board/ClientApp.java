package com.bitcamp.board;

import java.net.Socket;

public class ClientApp {
  public static void main(String[] args) {
    System.out.println("[게시글 관리 클라이언트]");

    try {
      // 네트워크 준비
      // => 정상적으로 연결되었으면 Socket 객체를 리턴한다.
      Socket socket = new Socket("127.0.0.1", 8888);

      System.out.println("연결되었음!");

      // 네트워크 끊기
      // => 서버와 연결된 것을 끊는다.
      socket.close();
      System.out.println("연결을 끊었음!");

    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("종료!");
  }
}
