<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>2. Servlet Method</title>
</head>
<body>
  <h1>2. Servlet Method</h1>
  <br/>
  <h2>GET</h2>
  <%-- GET방식으로 요청하기 : a태그, location.href속성, form[method=get], open함수 --%>
  <a href="test">GET</a>
  <input  type="button" value="GET" onclick="location.href='test;'">
  <input  type="button" value="GET" onclick="window.open('test', '_self')">
  <form action="test" method="get">
    <input type="submit" value="GET">
  </form>
  <h2>POST</h2>
  <%-- POST방식으로 요청하기 : form[method=post] --%>
  <form action="test" method="post">
    <input type="submit" value="POST">
  </form>
</body>
</html>