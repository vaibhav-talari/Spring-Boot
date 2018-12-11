<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<title>Home</title>
</head>
<body>
<div style="text-align:center">
<h1>Main Menu</h1>
<hr>
<spring:url value="/library/" var="contextPath" htmlEscape="true" />
<h2><a href="${contextPath}addbook">Add Book </a></h2>
<br>
<h2><a href="${contextPath}addsubject">Add Subject</a></h2>
<br>
<h2><a href="${contextPath}delete">Delete Book</a></h2>
<br>
<h2><a href="${contextPath}deletesub">Delete Subject</a></h2>
<br>
<h2><a href="${contextPath}searchbook">Search Book</a></h2>
<br>
<h2><a href="${contextPath}searchsubject">Search Subject</a></h2>
</div>
</body>
</html>
