<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <h1>게시글(JSP + Servlet + EL + JSTL)</h1>
  <a href='form'>새 글</a>
  <table border='1'>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>조회수</th>
      <th>작성자</th>
      <th>등록일</th>
    </tr>
<c:forEach items="${boards}" var="board">
    <tr>
      <td>${board.no}</td>
      <td><a href='detail?no=${board.no}'>${board.title == "" ? "(제목없음)" : board.title}</a></td>
      <td>${board.viewCount}</td>
      <td>${board.writer.name}</td>
      <td>${board.createdDate}</td>
    </tr>
</c:forEach>
  </table>
  <p><a href='../../'>메인</a></p>
</body>
</html>



    