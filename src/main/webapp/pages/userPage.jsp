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
</head>
<body>

<c:if test="${sessionScope.id == null}">
    <c:redirect url="/"/>
</c:if>

<p>  Hello ${sessionScope.userId}</p>
<p><a href="/calc"><button>Calculator</button></a></p>
<p><a href="/history"><button>Show History</button></a></p>
<p><a href="/update"><button>Rename login and password</button></a></p>
<p><a href="/delete"><button>Delete account</button></a></p>
<p><a href="/logout"><button>Logout</button></a></p>
</body>
</html>

