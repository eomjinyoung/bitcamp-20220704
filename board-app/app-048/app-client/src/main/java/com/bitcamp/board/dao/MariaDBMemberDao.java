package com.bitcamp.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bitcamp.board.domain.Member;

public class MariaDBMemberDao {

  Connection con;

  // DAO가 사용할 의존 객체 Connection을 생성자의 파라미터로 받는다.
  public MariaDBMemberDao(Connection con) {
    this.con = con;
  }

  public int insert(Member member) throws Exception {
    try (PreparedStatement pstmt = con.prepareStatement(
        "insert into app_member(name,email,pwd) values(?,?,sha2(?,256))")) {

      pstmt.setString(1, member.name);
      pstmt.setString(2, member.email);
      pstmt.setString(3, member.password);

      return pstmt.executeUpdate();
    }
  }

  public Member findByNo(int no) throws Exception {

    try (PreparedStatement pstmt = con.prepareStatement(
        "select mno,name,email,cdt from app_member where mno=" + no);
        ResultSet rs = pstmt.executeQuery()) {

      if (!rs.next()) {
        return null;
      }

      Member member = new Member();
      member.no = rs.getInt("mno");
      member.name = rs.getString("name");
      member.email = rs.getString("email");
      member.createdDate = rs.getDate("cdt");
      return member;
    }
  }

  public int update(Member member) throws Exception {
    try (PreparedStatement pstmt = con.prepareStatement(
        "update app_member set name=?, email=?, pwd=sha2(?,256) where mno=?")) {

      pstmt.setString(1, member.name);
      pstmt.setString(2, member.email);
      pstmt.setString(3, member.password);
      pstmt.setInt(4, member.no);

      return pstmt.executeUpdate();
    }
  }

  public int delete(int no) throws Exception {
    try (PreparedStatement pstmt1 = con.prepareStatement("delete from app_board where mno=?");
        PreparedStatement pstmt2 = con.prepareStatement("delete from app_member where mno=?")) {

      // 회원이 작성한 게시글을 삭제한다.
      pstmt1.setInt(1, no);
      pstmt1.executeUpdate();

      // 회원을 삭제한다.
      pstmt2.setInt(1, no);
      return pstmt2.executeUpdate();
    }
  }

  public List<Member> findAll() throws Exception {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select mno,name,email from app_member");
        ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Member> list = new ArrayList<>();

      while (rs.next()) {
        Member member = new Member();
        member.no = rs.getInt("mno");
        member.name = rs.getString("name");
        member.email = rs.getString("email");

        list.add(member);
      }

      return list;
    }
  }
}














