<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bitcamp</title>
</head>
<body>
<h1>게시글 입력-JSP</h1>

<form action='add' method="post" enctype="multipart/form-data">
<table border='1'>
  <tr>
    <th>제목</th><td><input name='title' type='text' size='60'></td>
  </tr>
  <tr>
    <th>내용</th><td><textarea name='content' rows='10' cols='60'></textarea></td>
  </tr>
  <tr>
    <th>첨부파일</th><td><input name='files' type="file" multiple></td>
  </tr>
</table>
<p>
  <button type='submit'>등록</button>
  <a href='list'>목록</a>
</p>
</form>

</body>
</html>