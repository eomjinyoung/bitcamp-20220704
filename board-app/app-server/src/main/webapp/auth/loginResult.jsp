<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bitcamp</title>
<meta http-equiv='Refresh' content='1; url=${empty member ? "form" : "../../"}'>
</head>
<body>
<h1>로그인</h1>
<c:choose>
  <c:when test="${not empty member}">
    <p>로그인 성공입니다!</p>
  </c:when>
  <c:otherwise>
    <p>회원이 존재하지 않습니다!</p>
  </c:otherwise>
</c:choose>
</body>
</html>