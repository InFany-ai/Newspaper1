<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of articles</title>
<link href="css/default.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="jspf/head.jspf"></jsp:include>
 	<c:choose>
 	<c:when test="${empty articles }">
		<h2>No articles found</h2>
 	</c:when>
	<c:otherwise>
	<table class="brd">
	<thead class="tabhead">
		<colcolgroup class="left"/>
		<colcolgroup class="left"/>
		<colcolgroup class="left"/>
		<colcolgroup class="right"/>
		<colcolgroup class="right"/>
		<colcolgroup class="left"/>
		<tr>
			<th class="brd">Article id</th>
			<th class="brd">Title</th>
			<th class="brd">Body</th>
			<th class="brd">Author First name</th>
			<th class="brd">Author Last name</th>
			<th class="brd">Author Age</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="article" items="${articles }">
		<tr>
			<td class="brd">${article.id }</td>
			<td class="brd">${article.title }</td>
			<td class="brd">${article.body }</td>
			<td class="brd right">${article.author.firstName }</td>
			<td class="brd right">${article.author.lastName }</td>
			<td class="brd right">${article.author.age }</td>
		</tr>
		<tr>
			<td colspan="6">
				<h3>Comments:</h3>
				<ul>
					<c:forEach var="comment" items="${article.comment}">
						<li>${comment.body}</li>
					</c:forEach>
				</ul>
			</td>
		</tr>
		<tr>
			<td colspan="6">
				<h3>Tags:</h3>
				<ul>
					<c:forEach var="tag" items="${article.articleTag}">
						<li>${tag.name}</li>
					</c:forEach>
				</ul>
			</td>
		</tr>
		<tr>
			<td colspan="6">
				<h3>Grades:</h3>
				<ul>
					<c:forEach var="grade" items="${article.grade}">
						<li>${grade.value}</li>
					</c:forEach>
				</ul>
			</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	</c:otherwise>
	</c:choose>
</body>
</html>