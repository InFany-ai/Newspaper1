<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Article Details</title>
    <link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<c:choose>
    <c:when test="${not empty errorMsg}">
        <h2>${errorMsg}</h2>
    </c:when>
    <c:otherwise>
        <ul>
            <li>Title: ${article.title}</li>
            <li>Body: ${article.body}</li>
            <li>Author First Name: ${article.author.firstName}</li>
            <li>Author Last Name: ${article.author.lastName}</li>
            <li>Tags:
                <c:forEach var="articleTag" items="${article.articleTag}">
                    ${articleTag.name}
                </c:forEach>
            </li>
        </ul>
        <h3>Comments:</h3>
        <ul>
            <c:forEach var="comment" items="${article.comment}">
                <li>${comment.body}</li>
            </c:forEach>
        </ul>
        <h3>Grades:</h3>
        <ul>
            <c:forEach var="grade" items="${article.grade}">
                <li>${grade.value}</li>
            </c:forEach>
        </ul>
    </c:otherwise>
</c:choose>

<!-- Due PRG pattern, remove error message and article from session after displaying -->
<% session.removeAttribute("errorMsg"); %>
<% session.removeAttribute("article"); %>
</body>
</html>
