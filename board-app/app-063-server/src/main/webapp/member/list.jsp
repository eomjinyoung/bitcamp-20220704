<%@page import="com.bitcamp.board.domain.Member"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%>
<%@ page import="java.util.List"%>
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
<h1>회원(JSP + Servlet + EL)</h1>

<a href='form'>새 회원</a>
<table border='1'>
  <tr>
    <th>번호</th>
    <th>이름</th>
    <th>이메일</th>
  </tr>
<% 
List<Member> members = (List<Member>) request.getAttribute("members");
for (Member member : members) {
  pageContext.setAttribute("member", member);
%>
  <tr>
    <td>${member.no}</td>
    <td><a href='detail?no=${member.no}'>${member.name}</a></td>
    <td>${member.email}</td>
  </tr>
<%     
}
%>
</table>
<p><a href='../'>메인</a></p>
</body>
</html>



    