<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>6. Forward Responsed</title>
</head>
<body>
<h1>forward response</h1>
<form action = "menu">
  <div>
    <label for = "category">메뉴 카테고리 : </label>
    <select name ="category" id="category">
      <option value = "" disabled selected></option>
      <option value = "rice">밥</option>
      <option value = "meat">고기</option>
      <option value = "vegi">채소</option>
    </select>
  </div>
  <div>
    <button type = "submit">확인</button>
  </div>
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>