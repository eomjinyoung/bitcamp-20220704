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
<h1>회원 입력-JSP</h1>

<form action='add' method="post">
<table border='1'>
  <tr>
    <th>이름</th><td><input name='name' type='text' size='60'></td>
  </tr>
  <tr>
    <th>이메일</th><td><input name='email' type='email' size='60'></td>
  </tr>
  <tr>
    <th>암호</th><td><input name='password' type='password' size='10'></td>
  </tr>
</table>
<p>
  <button type='submit'>등록</button>
  <a href='list'>목록</a>
</p>
</form>

</body>
</html>