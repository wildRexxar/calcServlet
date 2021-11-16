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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        <%@include file="/pages/styles/inputs.css"%>
    </style>
</head>
<body>

<jsp:include page="../components/_header.jsp"/>

<div class="container-fluid">
    <form action="/calc" method="post">
        <div class="row justify-content-md-center">
            <div class="col-2">
                <div class="input-group mb-3 margin-search">
                    <h4>Enter number1</h4>
                </div>
            </div>
            <div class="col-2">
                <div class="input-group mb-3 margin-search">
                    <h4>Enter number2</h4>
                </div>
            </div>
            <div class="row justify-content-md-center">
                <div class="col-2">
                    <div class="input-group mb-3">
                        <input type="text" name="num" placeholder="Number 1" class="form-control"
                               aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default">
                    </div>
                </div>
                <div class="col-2">
                    <div class="input-group mb-3">
                        <input type="text" name="num" placeholder="Number 2" class="form-control"
                               aria-label="Sizing example input"
                               aria-describedby="inputGroup-sizing-default">
                    </div>
                </div>
            </div>

            <div class="row justify-content-md-center margin-but">
                <div class="col-1">
                    <button type="submit" name="operation" class="btn btn-outline-danger" value="PLUS">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-plus-lg" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                  d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z"></path>
                        </svg>
                    </button>
                </div>

                <div class="col-1">
                    <button type="submit" name="operation" class="btn btn-outline-danger" value="MINUS">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-plus-lg" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                  d="M2 8a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11A.5.5 0 0 1 2 8Z">
                            </path>
                        </svg>
                    </button>
                </div>

                <div class="col-1">
                    <button type="submit " name="operation" class="btn btn-outline-danger" value="MULTIPLE">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-plus-lg" viewBox="0 0 16 16">
                            <path d="M8 9.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z">
                            </path>
                        </svg>
                    </button>
                </div>

                <div class="col-1">
                    <button type="submit" name="operation" class="btn btn-outline-danger" value="DIVIDED">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-plus-lg" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                  d="M13.854 2.146a.5.5 0 0 1 0 .708l-11 11a.5.5 0 0 1-.708-.708l11-11a.5.5 0 0 1 .708 0Z">
                            </path>
                        </svg>
                    </button>
                </div>
            </div>

            <div class="row justify-content-md-center">
                <div class="col-1">
                    <c:if test="${requestScope.result != null}">
                        <div class="alert alert-danger role=alert">
                                ${requestScope.result}
                        </div>
                    </c:if>
                    <c:if test="${requestScope.error != null}">
                        <div class="alert alert-danger role=alert">
                                ${requestScope.result}
                        </div>
                    </c:if>
                </div>
            </div>

        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>