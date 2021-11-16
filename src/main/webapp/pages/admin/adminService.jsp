<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09.11.2021
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin service</title>
<%--    <meta http-equiv="Refresh" content="1" />--%>
</head>
<body>
<ol>
    <c:forEach var="user" items="${sessionScope.listOfUsers}" >
        <p>
            ${user}
        </p>
        <form action="/updateUserStatus" method="post">
            <input type="text" name="login" value="${user.login}">
            <button type="submit" name="status" value="true">set admin</button>
            <button type="submit" name="status" value="false">set user</button>
        </form>

        <form action="/deleteUser" method="post">
            <button name="login" value="${user.login}">delete account</button>
        </form>

        <form action="/userHistory" method="post">
            <button name="login" value="${user.login}">show history</button>
        </form>
    </c:forEach>
</ol>

<p><a href="/userPage"><button>Back</button></a></p>

</body>
</html>