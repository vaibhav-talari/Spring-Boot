<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>BOOK</title>
</head>

<body>
	<h1>Available Books</h1>
	<form action="searchbook" method="POST">
		Enter Book ID:<input type="number" name="bookid" required="required" />
		<button>Search</button>
	</form>
	<table border="1">
		<spring:url value="/library/" var="contextPath" htmlEscape="true"></spring:url>

		<tr>
			<th>ID</th>
			<th>TITLE</th>
			<th>PRICE</th>
			<th>VOLUME</th>
			<th>PUBLISHED DATE</th>
		</tr>
		<c:if test="${empty singlebook}">
			<tr>
				<td colspan="11" align="center">No record found to display.</td>
			</tr>
		</c:if>
		<c:forEach var="bks" items="${singlebook}">
			<tr>
				<td>${bks.bookid}</td>
				<td>${bks.title}</td>
				<td>${bks.price}</td>
				<td>${bks.volume}</td>
				<td>${bks.publishDate}</td>

			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="${contextPath}addbook">ADD BOOK</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="${contextPath}welcome">MAIN MENU</a>
</body>
</html>
