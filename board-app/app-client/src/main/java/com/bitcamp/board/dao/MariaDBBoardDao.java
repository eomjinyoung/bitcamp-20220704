package com.bitcamp.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bitcamp.board.domain.Board;

public class MariaDBBoardDao {

  public int insert(Board board) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111")) {

      if (board.memberNo > 0) { // 회원인 경우
        try (PreparedStatement pstmt = con.prepareStatement(
            "insert into app_board(title,cont,mno) values(?,?,?)")) {
          pstmt.setString(1, board.title);
          pstmt.setString(2, board.content);
          pstmt.setInt(3, board.memberNo);
          return pstmt.executeUpdate();
        }
      } else { // 비회원인 경우
        try (PreparedStatement pstmt = con.prepareStatement(
            "insert into app_board(title,cont,pwd) values(?,?,sha2(?,256))")) {
          pstmt.setString(1, board.title);
          pstmt.setString(2, board.content);
          pstmt.setString(3, board.password);
          return pstmt.executeUpdate();
        }
      }
    }
  }

  public Board findByNo(int no) throws Exception {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement pstmt = con.prepareStatement(
            "select mno,name,email,cdt from app_board where mno=" + no);
        ResultSet rs = pstmt.executeQuery()) {

      if (!rs.next()) {
        return null;
      }

      Board board = new Board();
      board.no = rs.getInt("mno");
      board.name = rs.getString("name");
      board.email = rs.getString("email");
      board.createdDate = rs.getDate("cdt");
      return board;
    }
  }

  public int update(Board board) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement pstmt = con.prepareStatement(
            "update app_board set name=?, email=?, pwd=sha2(?,256) where mno=?")) {

      pstmt.setString(1, board.name);
      pstmt.setString(2, board.email);
      pstmt.setString(3, board.password);
      pstmt.setInt(4, board.no);

      return pstmt.executeUpdate();
    }
  }

  public int delete(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement pstmt1 = con.prepareStatement("delete from app_board where mno=?");
        PreparedStatement pstmt2 = con.prepareStatement("delete from app_board where mno=?")) {

      // 회원이 작성한 게시글을 삭제한다.
      pstmt1.setInt(1, no);
      pstmt1.executeUpdate();

      // 회원을 삭제한다.
      pstmt2.setInt(1, no);
      return pstmt2.executeUpdate();
    }
  }

  public List<Board> findAll() throws Exception {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb","study","1111");
        PreparedStatement pstmt = con.prepareStatement(
            "select mno,name,email from app_board");
        ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Board> list = new ArrayList<>();

      while (rs.next()) {
        Board board = new Board();
        board.no = rs.getInt("mno");
        board.name = rs.getString("name");
        board.email = rs.getString("email");

        list.add(board);
      }

      return list;
    }
  }
}














