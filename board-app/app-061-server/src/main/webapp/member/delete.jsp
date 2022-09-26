<%@page import="com.bitcamp.board.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
MemberDao memberDao;

public void jspInit() {
  memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
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
<h1>회원 삭제-JSP</h1>
<% 
try {
  int no = Integer.parseInt(request.getParameter("no"));

  if (memberDao.delete(no) == 0) {%>
    <p>해당 번호의 회원이 없습니다.</p>
<% 
  } else {%>
    <p>해당 회원을 삭제했습니다.</p>
<% 
  }
} catch (Exception e) {%>
  <p>실행 중 오류 발생!</p>
<% 
}%>

</body>
</html>