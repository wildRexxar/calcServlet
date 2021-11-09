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
    <title>List of users</title>
</head>
<body>
<form action="/users_list" method="get">
<ul>
    <c:forEach items="${sessionScope.list}" var="user">
        <li><h3>${user}</h3></li>
    </c:forEach>
</ul>
</form>
<p><a href="/user_history"><button>User History</button></a></p>
<p><a href="/update_user_status"><button>Update status</button></a></p>
<p><a href="/delete_user"><button>Delete user</button></a></p>
<p><a href="/userPage"><button>Back</button></a></p>

</body>
</html>
