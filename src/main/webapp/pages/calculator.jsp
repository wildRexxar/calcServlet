<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 28.10.2021
  Time: 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculator" method="get">

    <p><b>Enter number 1</b></p>
        <input type="text" name="num" placeholder="Number 1" ><Br>
    <p><b>Enter number 2</b></p>
        <input type="text" name="num" placeholder="Number 2" ><Br>

    <p><b>Сhoose action</b></p>
    <p><input type="radio" name="operation" value="PLUS">+<Br>
        <input type="radio" name="operation" value="MINUS">-<Br>
        <input type="radio" name="operation" value="MULTIPLE">*<Br>
        <input type="radio" name="operation" value="DIVIDED">/</p>

    <p>  <button> Enter </button> </p>

    <p>${requestScope.result}</p>
</form>

<p>
<form action="/userPage">
    <button>Back</button>
</form>
</p>
</body>
</html>
