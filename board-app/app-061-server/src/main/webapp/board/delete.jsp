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
<meta http-equiv='Refresh' content='1; url=list'>
</head>
<body>
<h1>게시글 삭제-JSP</h1>
<% 
try {
  int no = Integer.parseInt(request.getParameter("no"));

  if (boardDao.delete(no) == 0) {
%>
    <p>해당 번호의 게시글이 없습니다.</p>
<% 
  } else {
%>
    <p>해당 게시글을 삭제했습니다.</p>
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