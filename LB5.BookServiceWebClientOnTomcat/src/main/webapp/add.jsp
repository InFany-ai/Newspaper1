<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of books</title>
<link href="css/default.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="jspf/head.jspf"></jsp:include>
 	<div>
 		<form action="add" method="post">
			<label for="title">Title:</label>
			<input type="text" name="title" id="title" required/>
			<br/>

			<label for="articleBody">Body:</label>
			<textarea name="articleBody" id="articleBody" required></textarea>
			<br/>

			<h3>Author</h3>
			<label for="firstName">First name:</label>
			<input type="text" id="firstName" name="firstName" required/>
<br/>
			<label for="lastName">Last name:</label>
			<input type="text" id="lastName" name="lastName" required/>
			<br/>

			<label for="age">Age:</label>
			<input type="number" id="age" name="age" required/>
			<br/>

			<h3>Article tags</h3>
			<label for="countAt">Count article tags:</label>
			<input type="number" id="countAt" name="countAt" required/>

			<div id="articleTags">
				<!-- JavaScript can be used to dynamically add input fields for article tags based on the count -->
			</div>

			<input type="submit" value="Add" />
 		</form>

		<script>
			document.addEventListener("DOMContentLoaded", function () {
				const countAtInput = document.getElementById("countAt");
				const articleTagsContainer = document.getElementById("articleTags");

				countAtInput.addEventListener("input", function () {
					const count = parseInt(countAtInput.value);
					articleTagsContainer.innerHTML = ""; // Clear previous input fields

					for (let i = 1; i <= count; i++) {
						const articleTagDiv = document.createElement("div");

						const label = document.createElement("label");
						label.htmlFor = "articleTag" + i;
						label.innerText = "Article Tag " + i;
						articleTagDiv.appendChild(label);

						const inputField = document.createElement("input");
						inputField.type = "text";
						inputField.name = "articleTag" + i;
						inputField.id = "articleTag" + i;
						articleTagDiv.appendChild(inputField);

						articleTagsContainer.appendChild(articleTagDiv);
					}
				});
			});
		</script>
 	</div>
</body>
</html>