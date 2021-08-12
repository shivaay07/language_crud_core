<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index page</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${langList}" var="oneLang">
				<tr>
					<td><a href="/languages/${oneLang.id}"><c:out value="${oneLang.name}"/></a></td>
					<td><c:out value="${oneLang.creator}"/></td>
					<td><c:out value="${oneLang.version}"/></td>
					<td><a href="/languages/edit/${oneLang.id}/">Edit</a></td>
					<td>
						<form action="/languages/delete/${oneLang.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form:form action ="/create/lang" method="post" modelAttribute="language" >
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
	<form action="/languages/delete/${language.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	</form>
</body>
</html>