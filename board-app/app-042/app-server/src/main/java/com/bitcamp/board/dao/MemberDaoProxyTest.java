package com.bitcamp.board.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import com.bitcamp.board.domain.Member;

public class MemberDaoProxyTest {

  public static void main(String[] args) throws Exception {
    try (Socket socket = new Socket("127.0.0.1", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())) {

      MemberDaoProxy memberDao = new MemberDaoProxy("member", in, out);

      // 테스트1) 목록 가져오기
      Member[] members = memberDao.findAll();
      for (Member b : members) {
        System.out.println(b);
      }
      System.out.println("---------------------------------");

      // 테스트2) 상세 데이터 가져오기
      Member member = memberDao.findByEmail("aa@test.com");
      System.out.println(member);
      System.out.println("---------------------------------");

      // 테스트3) 데이터 등록하기
      member = new Member();
      member.name = "ok";
      member.email = "ok@test.com";
      member.createdDate = System.currentTimeMillis();
      member.password = "1111";

      System.out.println(memberDao.insert(member));
      System.out.println("---------------------------------");

      // 데이터 등록 확인
      members = memberDao.findAll();
      for (Member b : members) {
        System.out.println(b);
      }
      System.out.println("---------------------------------");

      // 테스트4) 데이터 변경하기
      member = memberDao.findByEmail("ok@test.com");
      member.name = "hahaha";
      System.out.println(memberDao.update(member));
      System.out.println("---------------------------------");

      // 데이터 변경 확인
      member = memberDao.findByEmail("ok@test.com");
      System.out.println(member);
      System.out.println("---------------------------------");

      // 테스트5) 데이터 삭제하기
      System.out.println(memberDao.delete("ok@test.com"));
      System.out.println("---------------------------------");

      // 데이터 삭제 확인
      members = memberDao.findAll();
      for (Member b : members) {
        System.out.println(b);
      }
      System.out.println("---------------------------------");

      out.writeUTF("exit");
    }
  }

}





