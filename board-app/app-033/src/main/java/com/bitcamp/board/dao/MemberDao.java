package com.bitcamp.board.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.bitcamp.board.domain.Member;

// 회원 목록을 관리하는 역할
//
public class MemberDao {

  List<Member> list = new LinkedList<Member>();
  String filename;

  public MemberDao(String filename) {
    this.filename = filename;
  }

  public void load() throws Exception {
    try (FileInputStream in = new FileInputStream(filename)) {

      int size = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();

      for (int i = 0; i < size; i++) {
        Member member = new Member();
        member.no = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();

        int len = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();
        byte[] bytes = new byte[len];
        in.read(bytes);
        member.name = new String(bytes, "UTF-8");

        len = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();
        bytes = new byte[len];
        in.read(bytes);
        member.email = new String(bytes, "UTF-8");

        len = (in.read() << 24) + (in.read() << 16) + (in.read() << 8) + in.read();
        bytes = new byte[len];
        in.read(bytes);
        member.password = new String(bytes, "UTF-8");

        member.createdDate = 
            (((long)in.read()) << 56) + 
            (((long)in.read()) << 48) +
            (((long)in.read()) << 40) +
            (((long)in.read()) << 32) +
            (((long)in.read()) << 24) +
            (((long)in.read()) << 16) +
            (((long)in.read()) << 8) +
            ((in.read()));

        list.add(member);
      }
    } // try () ==> try 블록을 벗어나기 전에 in.close()가 자동으로 실행된다.
  }

  public void save() throws Exception {
    try (FileOutputStream out = new FileOutputStream(filename)) {

      out.write(list.size() >> 24);  
      out.write(list.size() >> 16);
      out.write(list.size() >> 8);
      out.write(list.size());

      for (Member member : list) {
        out.write(member.no >> 24);  
        out.write(member.no >> 16);
        out.write(member.no >> 8);
        out.write(member.no);

        byte[] bytes = member.name.getBytes("UTF-8"); 
        out.write(bytes.length >> 24);
        out.write(bytes.length >> 16);
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        bytes = member.email.getBytes("UTF-8"); 
        out.write(bytes.length >> 24);
        out.write(bytes.length >> 16);
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        bytes = member.password.getBytes("UTF-8"); 
        out.write(bytes.length >> 24);
        out.write(bytes.length >> 16);
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        out.write((int)(member.createdDate >> 56));
        out.write((int)(member.createdDate >> 48));
        out.write((int)(member.createdDate >> 40));
        out.write((int)(member.createdDate >> 32));
        out.write((int)(member.createdDate >> 24));
        out.write((int)(member.createdDate >> 16));
        out.write((int)(member.createdDate >> 8));
        out.write((int)(member.createdDate));
      }
    } // try () ==> try 블록을 벗어나기 전에 out.close()가 자동으로 실행된다.
  }

  public void insert(Member member) {
    list.add(member);
  }

  public Member findByEmail(String email) {
    for (int i = 0; i < list.size(); i++) {
      Member member = list.get(i);
      if (member.email.equals(email)) {
        return member;
      }
    }
    return null;
  }

  public boolean delete(String email) {
    for (int i = 0; i < list.size(); i++) {
      Member member = list.get(i);
      if (member.email.equals(email)) {
        return list.remove(i) != null;
      }
    }
    return false;
  }

  public Member[] findAll() {
    Iterator<Member> iterator = list.iterator();

    Member[] arr = new Member[list.size()];

    int i = 0;
    while (iterator.hasNext()) {
      arr[i++] = iterator.next(); 
    }
    return arr;
  }
}














