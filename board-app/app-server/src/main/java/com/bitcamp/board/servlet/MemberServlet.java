/*
 * 회원 메뉴 처리 클래스
 */
package com.bitcamp.board.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;
import com.bitcamp.servlet.Servlet;
import com.google.gson.Gson;

public class MemberServlet implements Servlet {

  private MemberDao memberDao;
  private String filename;

  public MemberServlet(String dataName) {
    filename = dataName + ".json";
    memberDao = new MemberDao(filename);

    try {
      memberDao.load();
    } catch (Exception e) {
      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filename);
      e.printStackTrace();
    }
  }

  @Override
  public void service(DataInputStream in, DataOutputStream out) {
    try {

      String command = in.readUTF();
      com.bitcamp.board.domain.Member member = null;
      String email = null;
      String json = null;

      switch (command) {
        case "findAll":
          Member[] members = memberDao.findAll();
          out.writeUTF(SUCCESS);
          out.writeUTF(new Gson().toJson(members));
          break;
        case "findByEmail":
          email = in.readUTF();
          member = memberDao.findByEmail(email);
          if (member != null) {
            out.writeUTF(SUCCESS);
            out.writeUTF(new Gson().toJson(member));
          } else {
            out.writeUTF(FAIL);
          }
          break;
        case "insert": 
          json = in.readUTF();
          member = new Gson().fromJson(json, Member.class);
          memberDao.insert(member);
          memberDao.save();
          out.writeUTF(SUCCESS);
          break;
        case "update": 
          json = in.readUTF();
          member = new Gson().fromJson(json, Member.class);
          if (memberDao.update(member)) {
            memberDao.save();
            out.writeUTF(SUCCESS);
          } else {
            out.writeUTF(FAIL);
          }
          break;
        case "delete": 
          email = in.readUTF();
          if (memberDao.delete(email)) {
            memberDao.save();
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




