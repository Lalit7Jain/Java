<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Searched Result </title>
</head>
<body>
<div class="container">
 <p> Welcome </p>
 
 </div>
 

	<div id="results">
		<form>
			<table class="table">
				<tr>
					<td>Company</td>
					<td>Title</td>
					<td>Description</td>
					<td>Salary</td>
					<td>Apply</td>
				</tr>

				<c:forEach var="item" items="${requestScope.listing}">
					<tr>
						<td><c:out value="${item}"></c:out></td>
						<td><c:out value="${item.title}"></c:out></td>
						<td><c:out value="${item.description}"></c:out></td>
						<td><c:out value="${item.salary}"></c:out></td>
						<td><a href="#"> Apply </a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>

</body>
</html>