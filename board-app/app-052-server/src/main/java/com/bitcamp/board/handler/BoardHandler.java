/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board.handler;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;

public class BoardHandler {

  private BoardDao boardDao;

  public BoardHandler(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  public void list(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<style>");
    out.println("tr:hover {");
    out.println("  background-color: navy;");
    out.println("  color: white;");
    out.println("}");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");
    out.println("<a href='form'>새 글</a>");
    out.println("<table border='1'>");
    out.println("  <tr>");
    out.println("    <th>번호</th>");
    out.println("    <th>제목</th>");
    out.println("    <th>조회수</th>");
    out.println("    <th>작성자</th>");
    out.println("    <th>등록일</th>");
    out.println("  </tr>");

    List<Board> boards = boardDao.findAll();
    for (Board board : boards) {
      out.println("<tr>");
      out.printf("  <td>%d</td>", board.no);
      out.printf("  <td><a href='detail?no=%d'>%s</a></td>", board.no, board.title);
      out.printf("  <td>%d</td>", board.viewCount);
      out.printf("  <td>%d</td>", board.memberNo);
      out.printf("  <td>%s</td>", board.createdDate);
      out.println("</tr>");
    }

    out.println("</table>");
    out.println("<p><a href='/'>메인</a></p>");
    out.println("</body>");
    out.println("</html>");
  }

  public void detail(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 상세 정보</h1>");

    int boardNo = Integer.parseInt(paramMap.get("no"));
    Board board = boardDao.findByNo(boardNo);

    if (board == null) {
      out.println("<p>해당 번호의 게시글이 없습니다.</p>");

    } else {
      out.println("<form action='update'>");
      out.println("<table border='1'>");
      out.println("  <tr>");
      out.printf("    <th>번호</th><td><input name='no' type='number' value='%d' readonly></td>", board.no);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>제목</th><td><input name='title' type='text' value='%s' size='60'></td>", board.title);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>내용</th><td><textarea name='content' rows='10' cols='60'>%s</textarea></td>", board.content);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>조회수</th><td>%d</td>", board.viewCount);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>작성자</th><td>%d</td>", board.memberNo);
      out.println("  </tr>");
      out.println("  <tr>");
      out.printf("    <th>등록일</th><td>%s</td>", board.createdDate);
      out.println("  </tr>");
      out.println("</table>");
      out.println("<p>");
      out.println("  <button type='submit'>변경</button>");
      out.printf("  <a href='delete?no=%d'>삭제</a>", board.no);
      out.println("</p>");
      out.println("</form>");
    }

    out.println("</body>");
    out.println("</html>");
  }

  public void delete(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<meta http-equiv='Refresh' content='1; url=list'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 삭제</h1>");

    int no = Integer.parseInt(paramMap.get("no"));

    if (boardDao.delete(no) == 0) {
      out.println("<p>해당 번호의 게시글이 없습니다.</p>");

    } else {
      out.println("<p>해당 게시글을 삭제했습니다.</p>");
    }

    out.println("</body>");
    out.println("</html>");

  }

  public void update(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<meta http-equiv='Refresh' content='1; url=list'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 변경</h1>");

    Board board = new Board();
    board.no = Integer.parseInt(paramMap.get("no"));
    board.title = paramMap.get("title");
    board.content = paramMap.get("content");

    if (boardDao.update(board) == 0) {
      out.println("<p>해당 번호의 게시글이 없습니다.</p>");

    } else {
      out.println("<p>해당 게시글을 변경했습니다.</p>");
    }

    out.println("</body>");
    out.println("</html>");
  }

  public void form(Map<String, String> paramMap, PrintWriter out) {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 입력</h1>");

    out.println("<form action='add'>");
    out.println("<table border='1'>");
    out.println("  <tr>");
    out.println("    <th>제목</th><td><input name='title' type='text' size='60'></td>");
    out.println("  </tr>");
    out.println("  <tr>");
    out.println("    <th>내용</th><td><textarea name='content' rows='10' cols='60'></textarea></td>");
    out.println("  </tr>");
    out.println("  <tr>");
    out.println("    <th>작성자</th><td><input name='writerNo' type='number' size='5'></td>");
    out.println("  </tr>");
    out.println("</table>");
    out.println("<p>");
    out.println("  <button type='submit'>등록</button>");
    out.println("  <a href='list'>목록</a>");
    out.println("</p>");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");

  }

  public void add(Map<String,String> paramMap, PrintWriter out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<meta http-equiv='Refresh' content='1; url=list'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 입력</h1>");

    Board board = new Board();
    board.title = paramMap.get("title");
    board.content = paramMap.get("content");
    board.memberNo = Integer.parseInt(paramMap.get("writerNo"));

    if (boardDao.insert(board) == 0) {
      out.println("<p>게시글을 등록할 수 없습니다!</p>");

    } else {
      out.println("<p>게시글을 등록했습니다.</p>");
    }

    out.println("</body>");
    out.println("</html>");

  }


}




