<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Added comment</title>
    <link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<c:choose>
    <c:when test="${not empty errorMsg }">
        <h2>${errorMsg }</h2>
    </c:when>
    <c:otherwise>
        <ul>
            <li>${comment.body }</li>

            <li>${comment.articleId }</li>
        </ul>
    </c:otherwise>
</c:choose>

<!-- Due PRG pattern this page can be requested as get method only -->
<!-- if there is any error put it into html (see: errorMsg) and remove it from the session -->
<% session.removeAttribute("errorMsg"); %>
<!-- Put the book into html and remove it from the session -->
<% session.removeAttribute("comment"); %>
</body>
</html>