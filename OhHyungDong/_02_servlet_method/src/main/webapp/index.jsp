<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Servlet Method</title>
</head>
<body>
<h1>2. Servlet Method</h1>
<br/>
<h2> GET </h2>
<%--GET방식으로 요청하기 : a태그, loaciton.href속성, form[method = get]--%>
<a href="hello-servlet">Hello Servlet</a>
<h2> POST</h2>
<%--Post방식으로 요청하기 : form[method = post]--%>
<input type = "button" value = "GET" onclick="location.href ='test';">
<input type = "button" value = "GET" onclick="oepn('test','_self')">
<form action = "test" method = "GET">
  <input type = "submit" value = "GET">
</form>
</body>
</html>

