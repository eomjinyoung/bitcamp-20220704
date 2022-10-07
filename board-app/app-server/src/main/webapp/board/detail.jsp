<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bitcamp</title>
</head>
<body>
<h1>게시글 상세 정보(JSP + Servlet + EL)</h1>
<form action='update' method="post" enctype="multipart/form-data">
<table border='1'>
  <tr>
    <th>번호</th><td><input name='no' type='number' value='${board.no}' readonly></td>
  </tr>
  <tr>
    <th>제목</th><td><input name='title' type='text' value='${board.title}' size='60'></td>
  </tr>
  <tr>
    <th>내용</th><td><textarea name='content' rows='10' cols='60'>${board.content}</textarea></td>
  </tr>
  <tr>
    <th>조회수</th><td>${board.viewCount}</td>
  </tr>
  <tr>
    <th>작성자</th><td>${board.writer.name}</td>
  </tr>
  <tr>
    <th>등록일</th><td>${board.createdDate}</td>
  </tr>
  <tr>
    <th>첨부파일</th>
    <td>
      <ul>
      <c:forEach items="${board.attachedFiles}" var="file">
        <li>
          <a href="../../board/files/${file.filepath}">${file.filepath}</a>
          [<a href="fileDelete?no=${file.no}">삭제</a>]
        </li>
      </c:forEach>
      </ul>
      파일 추가: <input name='files' type="file" multiple>
    </td>
  </tr>
</table>
<p>
  <button type='submit'>변경</button>
  <a href='delete?no=${board.no}'>삭제</a>
  <a href='list'>목록</a>
</p>
</form>
</body>
</html>