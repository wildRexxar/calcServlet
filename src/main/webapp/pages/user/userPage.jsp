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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.0/font/boots..">
</head>
<body>

<jsp:include page="../components/_header.jsp"/>

<img class="d-block w-100" src="https://7themes.su/_ph/30/275498755.jpg" alt="First slide">


<c:if test="${sessionScope.user.status == true}">
    <p><a href="/adminService">
        <button>List of users</button>
    </a></p>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>

