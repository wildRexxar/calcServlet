<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 28.10.2021
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>History</title>
</head>
<body>
<p>Result History</p>

<c:if test="${sessionScope.id == null}">
    <c:redirect url="/"/>
</c:if>

<ul>
    <c:forEach items="${requestScope.results}" var="result">
        <li>${result}</li>
    </c:forEach>
</ul>

<p><a href="/userPage"><button>Back</button></a></p>

</body>
</html>