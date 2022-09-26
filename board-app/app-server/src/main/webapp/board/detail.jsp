<%@page import="com.bitcamp.board.domain.Board"%>
<%@page import="com.bitcamp.board.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
<h1>게시글 상세 정보-JSP</h1>
<% 
int boardNo = Integer.parseInt(request.getParameter("no"));

try {
  Board board = boardDao.findByNo(boardNo);

  if (board == null) {
%>
    <p>해당 번호의 게시글이 없습니다.</p>
<% 
  } else {
%>
    <form action='update'>
    <table border='1'>
      <tr>
        <th>번호</th><td><input name='no' type='number' value='<%=board.no%>' readonly></td>
      </tr>
      <tr>
        <th>제목</th><td><input name='title' type='text' value='<%=board.title%>' size='60'></td>
      </tr>
      <tr>
        <th>내용</th><td><textarea name='content' rows='10' cols='60'><%=board.content%></textarea></td>
      </tr>
      <tr>
        <th>조회수</th><td><%=board.viewCount%></td>
      </tr>
      <tr>
        <th>작성자</th><td><%=board.memberNo%></td>
      </tr>
      <tr>
        <th>등록일</th><td><%=board.createdDate%></td>
      </tr>
    </table>
    <p>
      <button type='submit'>변경</button>
      <a href='delete?no=<%=board.no%>'>삭제</a>
    </p>
    </form>
<% 
  }
} catch (Exception e) {
%>
  <p>실행 중 오류 발생!</p>
<%
}
%>

</body>
</html>