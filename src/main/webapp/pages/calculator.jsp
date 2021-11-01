<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 28.10.2021
  Time: 5:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<c:if test="${sessionScope.userId == null}">
    <c:redirect url="/"/>
</c:if>

<form action="/calc" method="post">
    <p><b>Enter number 1</b></p>
    <input type="text" name="num" placeholder="Number 1"><Br>
    <p><b>Enter number 2</b></p>
    <input type="text" name="num" placeholder="Number 2"><Br>
    <p><b>Сhoose action</b></p>
    <input type="radio" name="operation" value="PLUS">+<Br>
    <input type="radio" name="operation" value="MINUS">-<Br>
    <input type="radio" name="operation" value="MULTIPLE">*<Br>
    <input type="radio" name="operation" value="DIVIDED">/</p>
    <p><button>Enter</button></p>
</form>

<p><a href="/userPage"><button>Back</button></a></p>

</body>
</html>