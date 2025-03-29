<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>2. Servlet Method</title>
</head>
<body>
<h1>2. Servlet Method</h1>
<br/>
<h2>Get</h2>
<!-- Get방식으로 요청하기 : a태그, location.href속성, form[method=get] -->
<a href="test">Get</a>
<input type="button" value="GET" onclick="location.href = 'test';">
<input type="button" value="GET" onclick="window.open('test','_self')">
<form action="test" method="get">
  <input type="submit" value="GET">
</form>

<h2>Post</h2>
<!-- Post방식으로 요청하기 : form[method=post]-->
<form action="test" method="POST">
  <input type="submit" value="POST">
</form>
</body>
</html>