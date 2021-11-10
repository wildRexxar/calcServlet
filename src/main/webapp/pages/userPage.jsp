<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 28.10.2021
  Time: 6:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User page</title>
</head>
<body>

<c:if test="${sessionScope.user.status == true}">
    <p> Admin № ${sessionScope.user.id}</p>
    <p><a href="/adminService">
        <button>List of users</button>
    </a></p>
</c:if>

<c:if test="${sessionScope.user.status != true}">
    <p> User № ${sessionScope.user.id}</p>
</c:if>

<p><a href="/calc" onclick="myFunction()">
    <button>Calculator</button>
</a></p>
<p><a href="/listOfResults">
    <button>Show History</button>
</a></p>
<p><a href="/updatePersonalAccount">
    <button>Rename login and password</button>
</a></p>
<p><a href="/deletePersonalAccount">
    <button>Delete account</button>
</a></p>
<p><a href="/logout">
    <button>Logout</button>
</a></p>
</body>
</html>

