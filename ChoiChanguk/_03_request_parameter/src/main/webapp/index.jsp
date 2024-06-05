<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>3. Request Parameter</title>
</head>
<body>
<h1>3. Request Parameter</h1>
<br/>

<h1>3. Request Parameter</h1>

<h2>GET</h2>
<form action="test" method="get">
  <label>이름 : </label><input type="text" name="name" value="홍길동">
  <br>
  <label>나이 : </label><input type="number" name="age" value="33">
  <br>
  <label>생일 : </label><input type="date" name="birthday" value="1999-09-09">
  <br>
  <label>성별 : </label>
  <input type="radio" name="gender" id="male" value="M" checked><label for="male" >남자</label>
  <input type="radio" name="gender" id="female" value="F" checked><label for="female">여자</label>
  <br>
  <label>국적 : </label>
  <select name="national">
    <option value="ko" selected>한국</option>
    <option value="ch">중국</option>
    <option value="jp">일본</option>
    <option value="etc">기타</option>
  </select>
  <br>
  <label>취미 : </label>
  <input type="checkbox" name="hobbies" id="movie" value="movie" checked>
  <label for="movie">영화</label>

  <input type="checkbox" name="hobbies" id="music" value="music">
  <label for="music">음악</label>

  <input type="checkbox" name="hobbies" id="sleep" value="sleep" checked>
  <label for="sleep">취침</label>
  <br>

  <input type="submit" value="GET 요청">
</form>
<a href="test?name=홍길동&age=33&married=true">GET요청</a>

<h2>POST</h2>
<form action="test" method="post">
  <label>이름 : </label><input type="text" name="name" value="홍길동">
  <br>
  <label>나이 : </label><input type="number" name="age" value="33">
  <br>
  <label>생일 : </label><input type="date" name="birthday" value="1999-09-09">
  <br>
  <label>성별 : </label>
  <input type="radio" name="gender" id="male2" value="M" checked><label for="male" >남자</label>
  <input type="radio" name="gender" id="female2" value="F" checked><label for="female">여자</label>
  <br>
  <label>국적 : </label>
  <select name="national">
    <option value="ko" selected>한국</option>
    <option value="ch">중국</option>
    <option value="jp">일본</option>
    <option value="etc">기타</option>
  </select>
  <br>
  <label>취미 : </label>
  <input type="checkbox" name="hobbies" id="movie2" value="movie" checked>
  <label for="movie">영화</label>

  <input type="checkbox" name="hobbies" id="music2" value="music">
  <label for="music">음악</label>

  <input type="checkbox" name="hobbies" id="sleep2" value="sleep" checked>
  <label for="sleep">취침</label>
  <br>

  <input type="submit" value="POST 요청">
</form>
</body>
</html>