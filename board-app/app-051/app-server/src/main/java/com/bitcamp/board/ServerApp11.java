package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.handler.BoardHandler;
import com.bitcamp.board.handler.MemberHandler;
import com.bitcamp.handler.Handler;
import com.bitcamp.util.BreadCrumb;

// 1) 클라이언트 접속 시 환영 메시지 전송
// 2) 여러 클라이언트를 순차적으로 접속 처리
// 3) 스레드를 이용하여 여러 클라이언트를 동시 접속 처리
// 4) 클라이언트가 보낸 요청 값을 받아서 그래도 돌려둔다.
// 5) 요청/응답을 무한 반복한다.
// 6) quit 명령을 보내면 연결 끊기
// 7) 환영 메시지 후에 메인 메뉴를 응답한다.
// 8) 사용자가 선택한 메뉴 번호의 유효성을 검증한다.
// 9) 메인 메뉴 선택에 따라 핸들러를 실행하여 클라이언트에게 하위 메뉴를 출력한다.
//    - Handler 인터페이스 변경
//    - AbstractHandler 추상 클래스의 execute() 변경
// 10) Breadcrumb 기능을 객체로 분리한다.
//    - BreadCrumb 클래스를 정의한다.
// 11) 코드 리팩토링
//    - execute() 메서드 정의: main() 메서드의 코드를 옮긴다.
// 
public class ServerApp11 {

  // 메인 메뉴 목록 준비
  private String[] menus = {"게시판", "회원"};
  private int port;
  ArrayList<Handler> handlers = new ArrayList<>();

  public static void main(String[] args) {
    try {
      ServerApp11 app = new ServerApp11(8888);
      app.execute();

    } catch (Exception e) {
      System.out.println("서버 실행 오류!");
    }
  }

  public ServerApp11(int port) throws Exception {
    this.port = port;

    // DAO 가 사용할 커넥션 객체 준비
    Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");

    // DAO 객체를 준비한다.
    BoardDao boardDao = new MariaDBBoardDao(con);
    MemberDao memberDao = new MariaDBMemberDao(con);

    handlers.add(new BoardHandler(boardDao));
    handlers.add(new MemberHandler(memberDao));
  }

  public void execute() {
    try (ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중...");

      while (true) {
        new Thread(new ServiceProcessor(serverSocket.accept())).start();
        System.out.println("클라이언트 접속!");
      }
      //      System.out.println("서버 종료!");
    } catch (Exception e) {
      System.out.println("서버 실행 중 오류 발생!");
      e.printStackTrace();
    }
  }

  static void welcome(DataOutputStream out) throws Exception {
    try (StringWriter strOut = new StringWriter();
        PrintWriter tempOut = new PrintWriter(strOut)) {
      tempOut.println("[게시판 애플리케이션]");
      tempOut.println();
      tempOut.println("환영합니다!");
      tempOut.println();
      out.writeUTF(strOut.toString());
    }
  }

  static void error(DataOutputStream out, Exception e) {
    try (StringWriter strOut = new StringWriter();
        PrintWriter tempOut = new PrintWriter(strOut)) {
      tempOut.printf("실행 오류:%s\n", e.getMessage());
      out.writeUTF(strOut.toString());
    } catch (Exception e2) {
      e2.printStackTrace();
    }
  }

  void printMainMenus(DataOutputStream out) throws Exception {
    try (StringWriter strOut = new StringWriter();
        PrintWriter tempOut = new PrintWriter(strOut)) {

      tempOut.println(BreadCrumb.getBreadCrumbOfCurrentThread().toString());

      for (int i = 0; i < menus.length; i++) {
        tempOut.printf("  %d: %s\n", i + 1, menus[i]);
      }
      tempOut.printf("메뉴를 선택하세요[1..%d](quit: 종료) ", menus.length);
      out.writeUTF(strOut.toString());
    }
  }

  void processMainMenu(DataInputStream in, DataOutputStream out, String request) {
    try {
      int menuNo = Integer.parseInt(request);
      if (menuNo < 1 || menuNo > menus.length) {
        throw new Exception("메뉴 번호가 옳지 않습니다.");
      }

      BreadCrumb breadcrumb = BreadCrumb.getBreadCrumbOfCurrentThread();
      breadcrumb.put(menus[menuNo - 1]);

      handlers.get(menuNo - 1).execute(in, out);

      breadcrumb.pickUp();

      // 하위 메뉴에서 빠져 나오면 현재의 메뉴 경로를 출력한다.
      out.writeUTF(breadcrumb.toString());

    } catch (Exception e) {
      error(out, e);
    }
  }


  private class ServiceProcessor implements Runnable {

    Socket socket;

    public ServiceProcessor(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try (Socket s = this.socket;
          DataOutputStream out = new DataOutputStream(s.getOutputStream());
          DataInputStream in = new DataInputStream(s.getInputStream())) {

        // 접속한 클라이언트의 이동 경로를 보관할 breadcrumb 객체 준비
        BreadCrumb breadcrumb = new BreadCrumb(); // 현재 스레드 보관소에 저장된다.
        breadcrumb.put("메인");

        // 클라이언트에게 환영 메시지를 보낸다.
        welcome(out);

        while (true) {
          // 클라이언트가 보낸 요청 정보를 읽는다.
          String request = in.readUTF();

          if (request.equals("quit")) {
            break;

          } else if (request.equals("menu")) {
            printMainMenus(out);

          } else {
            processMainMenu(in, out, request);
          }
        }
        System.out.println("클라이언트와 접속 종료!");

      } catch (Exception e) {
        System.out.println("클라이언트와 통신하는 중 오류 발생!");
        e.printStackTrace();
      }
    }
  }

}
