<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>11. Filter</title>
</head>
<body>
  <h1>11. Filter</h1>
  <br/>
  <a href="first/lifecycle">Filter 생명주기</a>

  <%-- (jsp주석) --%>
  <%-- 스크립틀릿 jsp문법 --%>
  <% if(session.getAttribute("loginMember") == null) { %>

    <h2>회원가입</h2>
    <form action="member/regist" method="post">
      <label>아이디 : </label>
      <input type="text" name="userId">
      <br>
      <label>비밀번호 : </label>
      <input type="password" name="password">
      <br>
      <label>이름 : </label>
      <input type="text" name="name">
      <br>
      <button type="submit">가입하기</button>
    </form>

    <h2>로그인</h2>
    <form action="member/login" method="post">
      <label>아이디 : </label>
      <input type="text" name="userId">
      <br>
      <label>비밀번호 : </label>
      <input type="password" name="password">
      <br>
      <button type="submit">로그인하기</button>
    </form>

  <% } else { %>
    <!-- 로그인 성공했다면, session객체 loginMember속성으로 참조가 가능하다. -->
    <%-- EL jsp문법 --%>
    <h2>${loginMember.name}님, 안녕하세요.</h2>

  <% } %>
</body>
</html>