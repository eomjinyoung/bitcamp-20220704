<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h1>회원(JSP + Servlet + EL + JSTL)</h1>

<a href='form'>새 회원</a>
<table border='1'>
  <tr>
    <th>번호</th>
    <th>이름</th>
    <th>이메일</th>
  </tr>
<c:forEach items="${members}" var="member">
  <tr>
    <td>${member.no}</td>
    <td><a href='detail?no=${member.no}'>${member.name}</a></td>
    <td>${member.email}</td>
  </tr>
</c:forEach>
</table>
<p><a href='../../'>메인</a></p>
</body>
</html>



    