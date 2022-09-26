<%@page import="com.bitcamp.board.domain.Member"%>
<%@page import="com.bitcamp.board.dao.MemberDao"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
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
<h1>회원 입력-JSP</h1>
<% 
try {
  Member member = new Member();
  member.name = request.getParameter("name");
  member.email = request.getParameter("email");
  member.password = request.getParameter("password");

  if (memberDao.insert(member) == 0) {%>
    <p>회원을 등록할 수 없습니다!</p>
<% 
  } else {%>
    <p>회원을 등록했습니다.</p>
<% 
  }
} catch (Exception e) {%>
  <p>실행 중 오류 발생!</p>
<% 
}%>

</body>
</html>