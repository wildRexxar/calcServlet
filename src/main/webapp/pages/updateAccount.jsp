<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 30.10.2021
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
</head>
<body>

<c:if test="${sessionScope.user == null}">
    <c:redirect url="/"/>
</c:if>

<p>Update</p>

<form action="/update" method="post">
    <p><b>Enter new name</b></p>
    <input type="text" name="login" placeholder="New login"><Br>
    <p><b>Enter new password</b></p>
    <input type="text" name="password" placeholder="New password">
    <p><button>Enter</button></p>
</form>

<p><a href="/userPage"><button>Back</button></a></p>

</body>
</html>