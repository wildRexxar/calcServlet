<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 27.10.2021
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        <%@include file="/pages/styles/inputs.css"%>
    </style>
</head>
<body>

<jsp:include page="../components/_header.jsp"/>

<div class="container-fluid">

    <form action="/registration" method="post">
        <div class="row justify-content-md-center">
            <div class="col col-lg-3 mb-3">
                <label class="margin-input" for="inputPassword4" class="form-label"><h4>Login</h4></label>
                <input name="login" type="text" class="form-control" id="inputPassword4" placeholder="Login">
            </div>
            <div class="col col-lg-3 mb-3">
                <label class="margin-input" for="inputPassword4" class="form-label"><h4>Password</h4></label>
                <input name="password" type="password" class="form-control" id="inputPassword5" placeholder="Password">
            </div>
        </div>

        <div class="row justify-content-md-center">
            <div class="col col-lg-6 mb-3">
                <label for="inputEmail4" class="form-label"><h4>Email</h4></label>
                <input type="email" name="###" class="form-control" id="inputEmail4" placeholder="Email">
            </div>
        </div>

        <div class="row justify-content-md-center">
            <div class="col col-lg-3 mb-3">
                <label for="inputAddress" class="form-label"><h4>First name</h4></label>
                <input type="text" class="form-control" id="inputAddress" placeholder="First name">
            </div>
            <div class="col col-lg-3 mb-3">
                <label for="inputAddress2" class="form-label"><h4>Last name</h4></label>
                <input type="text" class="form-control" id="inputAddress2" placeholder="Last name">
            </div>
        </div>

        <div class="d-grid gap-2 col-6 mx-auto">
            <button class="btn btn-primary" type="submit">Sing up</button>
        </div>
    </form>

    <div class="row justify-content-md-center">
        <div class="col-6">
            <c:if test="${requestScope.message1 != null}">
                <div class="alert alert-success role=alert">
                        ${requestScope.message1}
                </div>
            </c:if>

            <c:if test="${requestScope.message2 != null}">
                <div class="alert alert-danger role=alert">
                        ${requestScope.message2}
                </div>
            </c:if>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>