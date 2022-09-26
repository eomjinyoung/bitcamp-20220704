<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.bitcamp.board.dao.BoardDao"%>
<%@ page import="com.bitcamp.board.domain.Board"%>

<%! 
BoardDao boardDao;

// init(ServletConfig) 메서드에 코드를 넣고 싶으면 
// 다음과 같이 JspPage.jspInit() 메서드를 오버라이딩 하라!
public void jspInit() {
  boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bitcamp</title>
<style>
tr:hover {
  background-color: navy;
  color: white;
}
</style>
</head>
<body>
  <h1>게시글-JSP</h1>
  <a href='form'>새 글</a>
<% 
try {
  List<Board> boards = boardDao.findAll();
%>
  <table border='1'>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>조회수</th>
      <th>작성자</th>
      <th>등록일</th>
    </tr>
<% 
  for (Board board : boards) {
%>
    <tr>
      <td><%=board.no%></td>
      <td><a href='detail?no=<%=board.no%>'><%=board.title%></a></td>
      <td><%=board.viewCount%></td>
      <td><%=board.memberNo%></td>
      <td><%=board.createdDate%></td>
    </tr>
<%   
  }
%>
  </table>
<%   
} catch (Exception e) {
%>
  <p>실행 중 오류 발생!</p>
<%     
}
%>
  <p><a href='../'>메인</a></p>
</body>
</html>



    