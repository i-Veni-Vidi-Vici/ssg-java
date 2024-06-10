<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>카테고리별 메뉴</title>
</head>
<body>
<h1>카테고리별 메뉴</h1>
<h2>선택하신 카테고리는 ${param.category}입니다.</h2>
<ul><%
    List<String> menus = (List<String>) request.getAttribute("menus");
    // out : 응답이 제공하는 출력스트림 PrintWriter
    out.println(menus.stream().reduce("", (html, menu) -> html + "<li>" + menu + "</li>"));
%></ul>
<button type="button" onclick="history.back();">뒤로가기</button>
</body>
</html>
