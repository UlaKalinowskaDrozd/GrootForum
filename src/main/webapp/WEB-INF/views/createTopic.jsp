<%--
  Created by IntelliJ IDEA.
  User: ulta
  Date: 11.08.17
  Time: 08:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>New Topic</title>
</head>
<body>

    <form:form action="/Groot Forum/createTopic" modelAttribute="topicPostWrapper" method="post">

        Name:
        <form:input path="topic.topicName" id="topicName"></form:input>
        <c:if test="${pageContext.request.method=='POST'}"><form:errors path="topic.topicName" /></c:if>
        <br />
        Text:
        <form:input path="post.text" id="postText"></form:input>
        <c:if test="${pageContext.request.method=='POST'}"><form:errors path="post.text" /></c:if>
        <br />
        <input type="submit" value="OK" />
    </form:form>


    <a href="<c:url value="/UsersList" />">All Groots</a>

    <a href="<c:url value="/topicsList" />">Groot Topics</a>

    <%--<a href="<c:url value="/logout" />">Log Out</a>--%>

</body>
</html>
