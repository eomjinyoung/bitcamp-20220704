package com.bitcamp.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;

@Repository 
public class MybatisBoardDao implements BoardDao {

  @Autowired
  DataSource ds;

  @Autowired
  SqlSessionFactory sqlSessionFactory;

  @Override
  public int insert(Board board) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("BoardDao.insert", board);
    }
  }

  @Override
  public Board findByNo1(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

      // 게시글 가져오기
      Board board = sqlSession.selectOne("BoardDao.findByNo", no);

      // 게시글의 첨부파일 가져오기
      List<AttachedFile> attachedFiles = 
          sqlSession.selectList("BoardDao.findFilesByBoard", no);

      board.setAttachedFiles(attachedFiles);

      return board;
    }
  }

  @Override
  public Board findByNo2(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("BoardDao.findByNo", no);
    }
  }

  @Override
  public Board findByNo3(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("BoardDao.findByNo3", no);
    }
  }

  @Override
  public int update(Board board) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "update app_board set title=?, cont=? where bno=?")) {

      pstmt.setString(1, board.getTitle());
      pstmt.setString(2, board.getContent());
      pstmt.setInt(3, board.getNo());

      return pstmt.executeUpdate();
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement("delete from app_board where bno=?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();
    }
  }

  @Override
  public List<Board> findAll() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("BoardDao.findAll");
    }
  }


  @Override
  public int insertFiles(Board board) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.insert("BoardDao.insertFiles", board);
    }
  }

  @Override
  public AttachedFile findFileByNo(int fileNo) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "select bfno, filepath, bno from app_board_file where bfno = " + fileNo);
        ResultSet rs = pstmt.executeQuery()) {

      if (!rs.next()) {
        return null;
      }

      AttachedFile file = new AttachedFile();
      file.setNo(rs.getInt("bfno"));
      file.setFilepath(rs.getString("filepath"));
      file.setBoardNo(rs.getInt("bno"));

      return file;
    }
  }

  @Override
  public List<AttachedFile> findFilesByBoard(int boardNo) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("BoardDao.findFilesByBoard", boardNo);
    }
  }

  @Override
  public int deleteFile(int fileNo) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "delete from app_board_file where bfno=?")) {

      pstmt.setInt(1, fileNo);
      return pstmt.executeUpdate();
    }
  }

  @Override
  public int deleteFiles(int boardNo) throws Exception {
    try (PreparedStatement pstmt = ds.getConnection().prepareStatement(
        "delete from app_board_file where bno=?")) {

      pstmt.setInt(1, boardNo);
      return pstmt.executeUpdate();
    }
  }
}














