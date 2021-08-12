<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<form action="/languages/delete/${language.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
	</form>
	<form:form action ="/languages/${language.id}" method="post" modelAttribute="language" >
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path ="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input path ="name"/>
			</p>
			<p>
				<form:label path ="creator">Creator:</form:label>
				<form:errors path="creator"/>
				<form:input path ="creator"/>
			</p>
			<p>
				<form:label path ="version">Version:</form:label>
				<form:errors path="version"/>
				<form:input path ="version"/>
			</p>
			<button>Submit</button>
	</form:form>

</body>
</html>