<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="http://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<title>Update Profile</title>
</head>
<body>
<jsp:include page="companynav.jsp"></jsp:include>
<c:choose>

		<c:when test="${!(companyupdate == null)}">
			<div class=container>
				<form:form commandName="companyupdate" method="post" >
					<hr>
					<div class="jumbotron text-center">
						<h> Update profile </h>
					</div>
					<table class=table>
						<tr>
							<td>Company Name:</td>
							<td><form:input path="name" size="30"/> <font color="red"><form:errors
										path="name" /></font></td>
						</tr>
						
						<tr>
							<td>Email:</td>
							<td><form:input path="email" size="30" /> <font color="red"><form:errors
										path="email" /></font></td>
						</tr>

						<tr>
							<td>Password:</td>
							<td><form:password path="password" size="30" value="${userupdate.password}"/> <font
								color="red"><form:errors path="password" /></font></td>
						</tr>
						
						
						<tr>
							<td colspan="2"><input type="submit" value="Update" /></td>
							<td colspan="2"><a href="/lalit/emplanding.htm">Back to Search</a></td>
						</tr>
					</table>

				</form:form>
				</div>
		</c:when>
		<c:when test="${!(message == null)}">
				<div class="container">
				 <h3> Your profile is been updated successfully </h3>
				 <a href="/lalit/emplanding.htm" > Back to home  </a>
				</div>
		</c:when>
		<c:otherwise>

			<div class=container>
				<div class="jumbotron text-center">
					
					
					<a href="/lalit" > Home </a>
					
				</div>
			</div>
		</c:otherwise>
		
	</c:choose>

</body>
</html>