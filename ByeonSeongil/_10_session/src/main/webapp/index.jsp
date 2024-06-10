<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>10. Session</title>
</head>
<body>
  <h1>10. Session</h1>
  <br/>
  <form action="session" method="post">
    <table>
      <tr>
        <td>firstName : </td>
        <td><input type="text" name="firstName" id="first-name"></td>
      </tr>
      <tr>
        <td>lastName : </td>
        <td><input type="text" name="lastName" id="last-name"></td>
      </tr>
      <tr>
        <td colspan="2">
          <button type="submit">전송</button>
        </td>
      </tr>
    </table>
  </form>

  <a href="deleteSession">Session 데이터 삭제</a>
</body>
</html>