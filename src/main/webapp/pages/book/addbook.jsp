<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>BOOK</title>
</head>
<style>
.error {
	color: #ff0000;
}
</style>
<body class="container">
	<h1 class="text-center">PLEASE ENTER BOOK DETAILS</h1>
	<hr>
	<form:form method="POST" action="addbook" modelAttribute="bookadd">
		<div class="form-group">
			<form:label path="bookid">BOOK-ID:</form:label>
			<form:input type="number" class="form-control" path="bookid"
				placeholder="Enter Book ID" />
			<form:errors path="bookid" cssClass="error" />
		</div>

		<div class="form-group">
			<form:label path="title">BOOK-TITLE:</form:label>
			<form:input type="text" class="form-control" path="title"
				placeholder="Enter Book Title" />
			<form:errors path="title" cssClass="error" />
		</div>
		<div class="form-group">
			<form:label path="price">BOOK-PRICE:</form:label>
			<form:input type="number" class="form-control" path="price"
				placeholder="Enter Book Price" />
			<form:errors path="price" cssClass="error" />
		</div>
		<div class="form-group">
			<form:label path="volume">BOOK-VOLUME:</form:label>
			<form:input type="number" class="form-control" path="volume"
				placeholder="Enter Book Volume" />
			<form:errors path="volume" cssClass="error" />
		</div>
		<div class="form-group">
			<form:label path="publishDate">BOOK-PUBLISHED DATE:</form:label>
			<form:input type="date" class="form-control" path="publishDate"
				placeholder="Enter Book Published Date (DD/MM/YYYY)" />
			<form:errors path="publishDate" cssClass="error" />
		</div>


		<br>
		<button type="submit" class="btn btn-outline-dark">ADD BOOK</button>
	</form:form>
</body>
</html>
