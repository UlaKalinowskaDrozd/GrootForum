<%--
  Created by IntelliJ IDEA.
  User: ulta
  Date: 06.08.17
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Groot Forum</title>

</head>
    <body>

        <h1>Welcome to Groot forum</h1>

        <a href="<c:url value="/topicsList" />">Groot Topics</a>
        <a href="<c:url value="/UsersList" />">All Groots</a>
        <a href="<c:url value="/signin" />">Sign In</a>
        <a href="<c:url value="/login" />">Log In</a>

    </body>
</html>
