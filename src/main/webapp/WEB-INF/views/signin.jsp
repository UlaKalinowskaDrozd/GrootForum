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
    <title>Sign in to Groot Forum</title>
</head>
<body>

    <h1>Sign in:</h1>

    <form:form action="/Groot Forum/signin" modelAttribute="user" method="post">

        Name:
        <form:input path="userName" id="userName"></form:input>
        <c:if test="${pageContext.request.method=='POST'}"><form:errors path="userName" /></c:if>
        <br />

        Email:
        <form:input path="email" id="email"></form:input>
        <c:if test="${pageContext.request.method=='POST'}"><form:errors path="email" /></c:if>
        <br />

        Password:
        <form:input path="password" id="password"></form:input>
        <c:if test="${pageContext.request.method=='POST'}"><form:errors path="password" /></c:if>
        <br />

        <input type="submit" value="Sign in" />
    </form:form>

    <a href="<c:url value="/" />">Home</a>

    <a href="<c:url value="/login" />">Log In</a>

</body>
</html>
