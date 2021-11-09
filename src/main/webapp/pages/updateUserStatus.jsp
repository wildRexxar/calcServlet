<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09.11.2021
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update user status</title>
</head>
<body>

<c:if test="${sessionScope.user == null}">
    <c:redirect url="/"/>
</c:if>

<form action="/update_user_status" method="post">
    <p><b>Enter login</b></p>
    <input type="text" name="login" placeholder="Login">
    <p><b>Select status</b></p>
    <select name = "status">
        <option value="true">admin</option>
        <option value="false">user</option>
    </select>
    <p><button>Enter</button></p>
</form>
<p><a href="/users_list"><button>Users list</button></a></p>
<p><a href="/userPage"><button>Back</button></a></p>
</body>
</html>
