<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09.11.2021
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>
<form action="/deletePersonalAccount" method="post">
    <p><b>Enter login</b></p>
    <input type="text" name="login" placeholder="Login">
    <p><button>Enter</button></p>
</form>
<p><a href="/users_list"><button>Users list</button></a></p>
<p><a href="/userPage"><button>Back</button></a></p>
</body>
</html>
