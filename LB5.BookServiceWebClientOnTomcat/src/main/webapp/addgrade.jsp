<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add grade</title>
</head>
<link href="css/default.css" rel="stylesheet">
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<div>
    <form action="addgrade" method="post" >
        <label for="value">Grade: </label>
        <input type="number" name="value" id="value"/>
        <br/>
        <label for="articleId">Article id: </label>
        <input type="number" name="articleId" id="articleId"/>
        <input type="submit" value="Add" />
    </form>
</div>
</body>
</html>