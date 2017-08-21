<%--
  Created by IntelliJ IDEA.
  User: ulta
  Date: 06.08.17
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Account</title>
</head>
<body>

    <h1>This Groot is known as ${user.userName}</h1>

    <a href="<c:url value="/" />">Home</a>

    <a href="<c:url value="/UsersList" />">All Groots</a>

    <a href="<c:url value="/topicsList" />">Groot Topics</a>


    <%--<a href="<c:url value="/logout" />">Log Out</a>--%>

</body>
</html>
