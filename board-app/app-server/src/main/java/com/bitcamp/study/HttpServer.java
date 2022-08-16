package com.bitcamp.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
  public static void main(String[] args) throws Exception {

    try (ServerSocket ss = new ServerSocket(80);) {
      System.out.println("서버 시작!!");

      while (true) {

        try (
            Socket socket = ss.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());
            ) {
          System.out.println("클라이언트가 연결됨!");

          // 클라이언트가 보낸 데이터를 읽는다.
          System.out.println("-------------------------------");
          String line;
          while ((line = in.readLine()) != null) {
            if (line.length() == 0) { // 클라이언트가 빈 줄을 보내면, 읽기를 끝낸다.
              break;
            }
            System.out.println(line);
          }

          // 클라이언트에게 응답한다.
          out.println("HTTP/1.1 200 OK");
          out.println("Content-Type: text/html;charset=UTF-8");
          out.println(); // 이제부터 본격적으로 콘텐트를 보내겠다고 알린다.
          out.println("<html>");
          out.println("<head>");
          out.println("<title>Hello!</title>");
          out.println("</head>");
          out.println("<body>");
          out.println("<h1>안녕하세요!</h1>");
          out.println("</body>");
          out.println("</html>");
        } // try
      } // while
    } // try
  } // main()
}