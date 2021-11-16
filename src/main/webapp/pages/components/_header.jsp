<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.11.2021
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.0/font/boots..">
    <style>
        <%@include file="/pages/styles/background-and-navbar.css"%>
    </style>

</head>

<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0" >

                <c:if test="${sessionScope.user == null}">
                    <a class="navbar-brand " href="/">
                        <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor"
                             class="bi bi-house" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                  d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"></path>
                            <path fill-rule="evenodd"
                                  d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"></path>
                        </svg>
                    </a>
                    <li class="nav-item">
                        <a class="nav-link disabled">Hello Guest</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link navbar-dark navbar-nav nav-link" href="/authorization">Sing in</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/registration">Sing up</a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.user != null}">
                    <a class="navbar-brand " href="/userPage">
                        <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor"
                             class="bi bi-house" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                  d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"></path>
                            <path fill-rule="evenodd"
                                  d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"></path>
                        </svg>
                    </a>

                    <c:if test="${sessionScope.user.status == false}">
                        <li class="nav-item">
                            <a class="nav-link disabled">Hello ${sessionScope.user.login}</a>
                        </li>
                    </c:if>

                    <c:if test="${sessionScope.user.status == true}">
                        <li class="nav-item">
                            <a class="nav-link disabled">Hello admin ${sessionScope.user.login}</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/adminService">Admin service</a>
                        </li>
                    </c:if>

                    <li class="nav-item">
                        <a class="nav-link" href="/calc">Calculator</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/listOfResults">Results</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Option
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><a class="dropdown-item" href="/updatePersonalAccount">Update account</a></li>
                            <li><a class="dropdown-item" href="/deletePersonalAccount">Delete account</a></li>
                        </ul>
                    </li>

<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="/updatePersonalAccount">Update account</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="/deletePersonalAccount">Delete account</a>--%>
<%--                    </li>--%>


                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>

                </c:if>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2 margin-search" type="search" placeholder="Search" aria-label="Search">
                <button type="button" class="btn btn-outline-secondary margin-search">Search</button>
            </form>
        </div>
    </div>
</nav>


<script src="https://unpkg.com/@popperjs/core@2"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
