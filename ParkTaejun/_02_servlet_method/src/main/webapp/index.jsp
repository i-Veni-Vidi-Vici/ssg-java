<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>2. Servlet Method</title>
</head>
<body>
<h1>2. Servlet Method
</h1>
<br/>
<h2>GET</h2>
<%--GET 방식으로 요청하기 : a 태그 , location.href속성, form[method=get] , open 함수 --%>
<a href="test">GET</a>
<input type="button" value="GET" onclick="location.href = 'test';  ">
<input type="button" value="GET" onclick="window.open('test', '_self' )">
<form action="test" method="get">
    <input type="submit" value="GET">
</form>
<H2>POST</H2>
<form action="test" method="post">
    <input type="submit" value="POST">
</form>
<%--POST방식으로 요청하기 : form[method=post]--%>

<a href="hello-servlet">Hello Servlet</a>
</body>
</html>