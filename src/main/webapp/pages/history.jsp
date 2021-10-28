<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 28.10.2021
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
    <p>Result History</p>
</head>
<body>
<p>
<form action="/userPage" method = "post">
    <button>Back</button>
    <p>
        ${requestScope.message}
    </p>
</form>
</p>
</body>
</html>
