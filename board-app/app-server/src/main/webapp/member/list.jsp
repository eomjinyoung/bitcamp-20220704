<%@page import="com.bitcamp.board.domain.Member"%>
<%@page import="com.bitcamp.board.dao.MemberDao"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
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
<style>
tr:hover {
  background-color: navy;
  color: white;
}
</style>
</head>
<body>
<h1>회원-JSP</h1>

<a href='form'>새 회원</a>
<% 
try {%>
  <table border='1'>
    <tr>
      <th>번호</th>
      <th>이름</th>
      <th>이메일</th>
    </tr>
<% 
  List<Member> members = memberDao.findAll();
  for (Member member : members) {%>
    <tr>
    <td><%=member.no%></td>
    <td><a href='detail?no=<%=member.no%>'><%=member.name%></a></td>
    <td><%=member.email%></td>
    </tr>
<%     
  }
} catch (Exception e) {%>
  <p>실행 중 오류 발생!</p>
<% 
}%>
</table>
<p><a href='../'>메인</a></p>
</body>
</html>



    