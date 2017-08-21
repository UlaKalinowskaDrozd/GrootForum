<%--
  Created by IntelliJ IDEA.
  User: ulta
  Date: 10.08.17
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Groot Users</title>
</head>
<body>

    <h2>Users:</h2>

    <c:forEach items="${usersList}" var="user" >
        <li id="userName_<c:out value="user.userName"/>">
            <div class="name">
                <a href="<c:url value="/user/${user.userId}" />"><c:out value="${user.userName}" /></a>
            </div>
        </li>
    </c:forEach>

    <a href="<c:url value="/topicsList" />">Groot Topics</a>
    <a href="<c:url value="/signin" />">Sign In</a>
    <a href="<c:url value="/login" />">Log In</a>

    <%--<a href="<c:url value="/logout" />">Log Out</a>--%>

</body>
</html>
