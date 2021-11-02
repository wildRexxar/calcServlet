<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 27.10.2021
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Authorization</title>
</head>
<body>

<c:if test="${sessionScope.id != null}">
    <c:redirect url="/userPage"/>
</c:if>

<p>Authorization</p>

<form action="/authorization" method="post">
    <input type="text" name="login" placeholder="login">
    <input type="password" name="password" placeholder="Password">
    <p><button>Enter</button></p>
</form>

<p><a href="/"><button>Back</button></a></p>

</body>
</html>