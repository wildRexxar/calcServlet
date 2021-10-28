<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 27.10.2021
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Authorization</title>
</head>
<body>
<p>
<form action="/authorization" method="post">
    <input type="text" name="login" placeholder="login">
    <input type="password" name="password" placeholder="Password">
    <button>Enter</button>
</form>
</p>
<p>
<form action="/home">
    <button>Home</button>
</form>
</p>
</body>
</html>