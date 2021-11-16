<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 27.10.2021
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Authorization</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        <%@include file="/pages/styles/inputs.css"%>
    </style>
</head>

<body>
<jsp:include page="../components/_header.jsp"/>

<div class="container-fluid">

    <div class="row justify-content-md-center">
        <div class="col col-lg-3">
            <form class="row g-2" action="/authorization" method="post">
        <div class="form-group">
            <label class="margin-input" for="exampleInputEmail1"><h4>Login</h4></label>
            <input type="text" name="login" class="form-control" id="exampleInputEmail1" placeholder="Enter login">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1"><h4>Password</h4></label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>
                <button type="submit" class="btn btn-primary">Sing in</button>
    </form>
            <c:if test="${requestScope.message != null}">
                <div class="alert alert-danger role=alert">
                    ${requestScope.message}
                </div>
            </c:if>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>