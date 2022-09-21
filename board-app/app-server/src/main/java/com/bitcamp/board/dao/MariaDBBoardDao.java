package com.bitcamp.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.bitcamp.board.domain.Board;

public class MariaDBBoardDao implements BoardDao {

  Connection con;

  //DAO가 사용할 의존 객체 Connection을 생성자의 파라미터로 받는다.
  public MariaDBBoardDao(Connection con) {
    this.con = con;
  }

  @Override
  public int insert(Board board) throws Exception {
    try (PreparedStatement pstmt = con.prepareStatement(
        "insert into app_board(title,cont,mno) values(?,?,?)")) {
      pstmt.setString(1, board.title);
      pstmt.setString(2, board.content);
      pstmt.setInt(3, board.memberNo);
      return pstmt.executeUpdate();
    }
  }

  @Override
  public Board findByNo(int no) throws Exception {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select bno,title,cont,mno,cdt,vw_cnt from app_board where bno=" + no);
        ResultSet rs = pstmt.executeQuery()) {

      if (!rs.next()) {
        return null;
      }

      Board board = new Board();
      board.no = rs.getInt("bno");
      board.title = rs.getString("title");
      board.content = rs.getString("cont");
      board.memberNo = rs.getInt("mno");
      board.createdDate = rs.getDate("cdt");
      board.viewCount = rs.getInt("vw_cnt");

      return board;
    }
  }

  @Override
  public int update(Board board) throws Exception {
    try (PreparedStatement pstmt = con.prepareStatement(
        "update app_board set title=?, cont=? where bno=?")) {

      pstmt.setString(1, board.title);
      pstmt.setString(2, board.content);
      pstmt.setInt(3, board.no);

      return pstmt.executeUpdate();
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (PreparedStatement pstmt = con.prepareStatement("delete from app_board where bno=?")) {

      pstmt.setInt(1, no);
      return pstmt.executeUpdate();
    }
  }

  @Override
  public List<Board> findAll() throws Exception {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select bno,title,mno,cdt,vw_cnt from app_board");
        ResultSet rs = pstmt.executeQuery()) {

      ArrayList<Board> list = new ArrayList<>();

      while (rs.next()) {
        Board board = new Board();
        board.no = rs.getInt("bno");
        board.title = rs.getString("title");
        board.memberNo = rs.getInt("mno");
        board.createdDate = rs.getDate("cdt");
        board.viewCount = rs.getInt("vw_cnt");

        list.add(board);
      }

      return list;
    }
  }
}














