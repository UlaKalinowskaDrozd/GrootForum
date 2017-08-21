<%--
  Created by IntelliJ IDEA.
  User: ulta
  Date: 06.08.17
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Groot Topics</title>
</head>
<body>

    <h2>Topics:</h2>

    <c:forEach items="${topicsList}" var="topic" >
        <li id="topicName_<c:out value="topic.topicName"/>">
            <div class="name">
                <a href="<c:url value="/topic/${topic.topicId}" />"><c:out value="${topic.topicName}" /></a>
            </div>
        </li>
    </c:forEach>

    <a href="<c:url value="/UsersList" />">All Groots</a>
    <a href="<c:url value="/login" />">Log In</a>
    <a href="<c:url value="/createTopic" />">New Topic</a>

    <%--<a href="<c:url value="/logout" />">Log Out</a>--%>

</body>
</html>
