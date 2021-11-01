<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 29.10.2021
  Time: 4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<form action="/res" method="post">
    <p>${requestScope.result}</p>
</form>
<p><a href="/calc"><button>Calculator</button></a></p>
<p><a href="/userPage"><button>Back</button></a></p>
</body>
</html>
