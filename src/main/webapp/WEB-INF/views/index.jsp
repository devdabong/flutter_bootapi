<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <header></header>
  <body>
  Hello bootapi!
  </body>
</html>

<script>
  let user = "${user}";
  let userId = "${user.userId}";
  let userName = "${user.userName}";
  let userEmail = "${user.userEmail}";
  let userPassword = "${user.userPassword}";
  console.log(user);
  console.log(userId);
  console.log(userName);
  console.log(userEmail);
  console.log(userPassword);
</script>