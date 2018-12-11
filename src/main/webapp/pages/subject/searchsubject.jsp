<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>SUBJECT</title>
</head>

<body>
	<h1>Available Subjects</h1>
	<form action="searchsubject" method="POST">
		Enter Subject ID:<input type="number" name="subjectid" required="required" />
		<button>Search</button>
	</form>
	<table border="1">
		<spring:url value="/library/" var="contextPath" htmlEscape="true"></spring:url>

		<tr>
			<th>ID</th>
			<th>TITLE</th>
			<th>TIME DURATION</th>

		</tr>
		<c:if test="${empty singlesubject}">
			<tr>
				<td colspan="11" align="center">No record found to display.</td>
			</tr>
		</c:if>
		<c:forEach var="subs" items="${singlesubject}">
			<tr>
				<td>${subs.subjectid}</td>
				<td>${subs.subtitle}</td>
				<td>${subs.duration}</td>

			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="${contextPath}addsubject">ADD SUBJECT</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="${contextPath}welcome">MAIN MENU</a>
</body>
</html>
