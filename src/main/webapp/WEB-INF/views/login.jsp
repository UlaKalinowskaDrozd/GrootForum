<%--
  Created by IntelliJ IDEA.
  User: ulta
  Date: 06.08.17
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Log in to Groot Forum</title>
</head>
<body>

    <h1>Log in to Groot Forum:</h1>

    <c:set var="loginUrl"><c:url value="/login"/></c:set>
    <form method="post" action="${loginUrl}">
        Name:
        <input type="text" name="username" />
        Password:
        <input type="password" name="password" />

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Log in" />
    </form>

    <a href="<c:url value="/" />">Home</a>
    <a href="<c:url value="/signin" />">Sign In</a>

</body>
</html>
