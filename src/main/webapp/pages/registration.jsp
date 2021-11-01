<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 27.10.2021
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<c:if test="${sessionScope.userId != null}">
    <c:redirect url="/userPage"/>
</c:if>

<p>Registration</p>

<form action="/registration" method="post">
    <input type="text" name="login" placeholder="Login">
    <input type="password" name="password" placeholder="Password">
    <p><button>Enter</button></p>
</form>

<p><a href="/home"><button>Back</button></a></p>
</body>
</html>