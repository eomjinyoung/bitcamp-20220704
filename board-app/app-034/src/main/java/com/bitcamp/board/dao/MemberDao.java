package com.bitcamp.board.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import com.bitcamp.board.domain.Member;
import com.bitcamp.util.DataInputStream;
import com.bitcamp.util.DataOutputStream;

// 회원 목록을 관리하는 역할
//
public class MemberDao {

  List<Member> list = new LinkedList<Member>();
  String filename;

  public MemberDao(String filename) {
    this.filename = filename;
  }

  public void load() throws Exception {
    try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
      int size = in.readInt();
      for (int i = 0; i < size; i++) {
        Member member = new Member();
        member.no = in.readInt();
        member.name = in.readUTF();
        member.email = in.readUTF();
        member.password = in.readUTF();
        member.createdDate = in.readLong();
        list.add(member);
        System.out.println("============>");
      }
    } // try () ==> try 블록을 벗어나기 전에 in.close()가 자동으로 실행된다.
  }

  public void save() throws Exception {
    try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
      out.writeInt(list.size());
      for (Member member : list) {
        out.writeInt(member.no);
        out.writeUTF(member.name);
        out.writeUTF(member.email);
        out.writeUTF(member.password);
        out.writeLong(member.createdDate);
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














