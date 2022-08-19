package com.bitcamp.board.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import com.bitcamp.board.domain.Board;

public class BoardDaoProxyTest {

  public static void main(String[] args) throws Exception {
    try (Socket socket = new Socket("127.0.0.1", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())) {

      BoardDaoProxy boardDao = new BoardDaoProxy("board", in, out);

      // 테스트1) 목록 가져오기
      Board[] boards = boardDao.findAll();
      for (Board b : boards) {
        System.out.println(b);
      }
      System.out.println("---------------------------------");


    }
  }

}





