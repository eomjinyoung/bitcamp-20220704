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
<h1>로그인</h1>

<form action='login' method="post">
<table border='1'>
  <tr>
    <th>이메일</th><td><input name='email' type='email' size='30' value="${cookie.email.value}"></td>
  </tr>
  <tr>
    <th>암호</th><td><input name='password' type='password' size='20'></td>
  </tr>
</table>
<input type="checkbox" name="saveEmail">이메일 저장<br>
<p>
  <button type='submit'>로그인</button>
  <a href='../../'>취소</a>
</p>
</form>

</body>
</html>