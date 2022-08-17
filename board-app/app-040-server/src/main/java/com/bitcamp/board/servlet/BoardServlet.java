/*
 * board 데이터 처리
 */
package com.bitcamp.board.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;
import com.bitcamp.servlet.Servlet;
import com.google.gson.Gson;

public class BoardServlet implements Servlet {

  // 게시글 목록을 관리할 객체 준비
  private BoardDao boardDao;
  private String filename;

  public BoardServlet(String dataName) {
    filename = dataName + ".json";
    boardDao = new BoardDao(filename);

    try {
      boardDao.load();
    } catch (Exception e) {
      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filename);
      e.printStackTrace();
    }
  }

  @Override
  public void service(DataInputStream in, DataOutputStream out) {
    try {

      String command = in.readUTF();
      Board board = null;
      int no = 0;
      String json = null;

      switch (command) {
        case "findAll":
          Board[] boards = boardDao.findAll();
          out.writeUTF(SUCCESS);
          out.writeUTF(new Gson().toJson(boards));
          break;
        case "findByNo":
          no = in.readInt();
          board = boardDao.findByNo(no);
          if (board != null) {
            out.writeUTF(SUCCESS);
            out.writeUTF(new Gson().toJson(board));
          } else {
            out.writeUTF(FAIL);
          }
          break;
        case "insert": 
          json = in.readUTF();
          board = new Gson().fromJson(json, Board.class);
          boardDao.insert(board);
          boardDao.save();
          out.writeUTF(SUCCESS);
          break;
        case "update": 
          json = in.readUTF();
          board = new Gson().fromJson(json, Board.class);
          if (boardDao.update(board)) {
            boardDao.save();
            out.writeUTF(SUCCESS);
          } else {
            out.writeUTF(FAIL);
          }
          break;
        case "delete": 
          no = in.readInt();
          if (boardDao.delete(no)) {
            boardDao.save();
            out.writeUTF(SUCCESS);
          } else {
            out.writeUTF(FAIL);
          }
          break;
        default:
          out.writeUTF(FAIL);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}




