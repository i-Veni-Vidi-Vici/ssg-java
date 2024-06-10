<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>13. JSP</title>
</head>
<body>
<h1>13. JSP</h1>
<!-- 작성한 jsp는 servlet으로 변환후 클라이언트 요청을 처리하게 된다. -->
<br/>
<form action="menu">
  <div>
    <label for="category">메뉴 카테고리 : </label>
    <select name="category" id="category" required>
      <option value="" disabled selected>선택하세요</option>
      <option value="rice">🍚밥류🍚</option>
      <option value="meat">🥩고기류🥩</option>
      <option value="vegi">🥦채소류🥦</option>
    </select>
  </div>
  <div>
    <button type="submit">확인</button>
  </div>
</form>
</body>
</html>