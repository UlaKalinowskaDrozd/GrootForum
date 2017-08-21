<%--
  Created by IntelliJ IDEA.
  User: ulta
  Date: 06.08.17
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Topic</title>
</head>

    ${topicPostWrapper.topic.topicName}

    <c:forEach items="${topicPostWrapper.topic.postsList}" var="post" >
        <li id="post_<c:out value="post.postId"/>">
            <div class="date">
                <c:out value="${post.date}" />
            </div>
            <div class="text">
                <c:out value="${post.text}" />
            </div>
        </li>
    </c:forEach>

    <form:form action="/Groot Forum/topic/${topicPostWrapper.topic.topicId}" modelAttribute="topicPostWrapper" method="post">

        Name:
        <form:input path="post.text" id="postText"></form:input>
        <c:if test="${pageContext.request.method=='POST'}"><form:errors path="post.text" /></c:if>
        <br />

        <input type="submit" value="OK" />

    </form:form>

    <a href="<c:url value="/UsersList" />">All Groots</a>

    <a href="<c:url value="/topicsList" />">Groot Topics</a>

    <%--<a href="<c:url value="/logout" />">Log Out</a>--%>

</html>
