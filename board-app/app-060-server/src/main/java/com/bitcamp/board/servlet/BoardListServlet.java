package com.bitcamp.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;

@WebServlet(value="/board/list")
public class BoardListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardDao boardDao;

  @Override
  public void init() throws ServletException {
    boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();

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

    try {
      List<Board> boards = boardDao.findAll();

      out.println("<table border='1'>");
      out.println("  <tr>");
      out.println("    <th>번호</th>");
      out.println("    <th>제목</th>");
      out.println("    <th>조회수</th>");
      out.println("    <th>작성자</th>");
      out.println("    <th>등록일</th>");
      out.println("  </tr>");

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
    } catch (Exception e) {
      out.println("<p>실행 중 오류 발생!</p>");
    }
    out.println("<p><a href='../welcome'>메인</a></p>");
    out.println("</body>");
    out.println("</html>");
  }

}




