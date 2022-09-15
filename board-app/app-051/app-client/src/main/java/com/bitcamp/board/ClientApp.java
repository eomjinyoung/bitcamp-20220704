package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import com.bitcamp.util.Prompt;

// 1) 서버에 접속 
// 4) 사용자 입력을 서버에 전송
// 5) 요청/응답을 무한 반복한다.
// 6) quit 명령을 보내면 연결 끊기
//
public class ClientApp {

  public static void main(String[] args) {

    System.out.println("[게시글 관리 클라이언트]");

    try (Socket socket = new Socket("localhost", 8888);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

      String response = null;

      while (true) {
        response = in.readUTF();
        System.out.println(response);

        String input = Prompt.inputString("> ");
        out.writeUTF(input);

        if (input.equals("quit")) {
          break;
        }
      }

    } catch (Exception e) {
      System.out.println("서버와 통신 중 오류 발생!");
      e.printStackTrace();
    }

    Prompt.close();

    System.out.println("종료!");

  }
}
