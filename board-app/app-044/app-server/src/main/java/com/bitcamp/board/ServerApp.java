package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import com.bitcamp.board.servlet.BoardServlet;
import com.bitcamp.board.servlet.MemberServlet;
import com.bitcamp.servlet.Servlet;

public class ServerApp {
  public static void main(String[] args) {
    System.out.println("[게시글 데이터 관리 서버]");

    try (ServerSocket serverSocket = new ServerSocket(8888);) {

      System.out.println("서버 소켓 준비 완료!");

      // 클라이언트 요청을 처리할 객체 준비
      Hashtable<String,Servlet> servletMap = new Hashtable<>();
      servletMap.put("board", new BoardServlet("board"));
      servletMap.put("reading", new BoardServlet("reading"));
      servletMap.put("visit", new BoardServlet("visit"));
      servletMap.put("notice", new BoardServlet("notice"));
      servletMap.put("daily", new BoardServlet("daily"));
      servletMap.put("member", new MemberServlet("member"));

      while (true) {
        try (Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {

          System.out.println("클라이언트와 연결 되었음!");

          // 클라이언트와 서버 사이에 정해진 규칙(protocol)에 따라 데이터를 주고 받는다.
          String dataName = in.readUTF();

          if (dataName.equals("exit")) {
            break;
          }

          Servlet servlet = servletMap.get(dataName);
          if (servlet != null) {
            servlet.service(in, out);
          } else {
            out.writeUTF("fail");
          }

          System.out.println("클라이언트와 연결을 끊었음!");
        } // 안쪽 try
      }
    } catch (Exception e) {
      e.printStackTrace();
    } // 바깥 쪽 try 

    System.out.println("서버 종료!");
  }
}
