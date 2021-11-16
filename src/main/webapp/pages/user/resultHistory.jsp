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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        <%@include file="../styles/result.css"%>
    </style>
</head>
<body>
<jsp:include page="../components/_header.jsp"/>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-8">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col" class="text-color text-type"><h3>Result</h3></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.listOfResults}" var="result">
                    <tr><td class="text-color"><h5>${result}</h5></td></tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>