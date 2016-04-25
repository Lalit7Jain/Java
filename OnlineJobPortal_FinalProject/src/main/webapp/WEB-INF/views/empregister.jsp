<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="http://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<c:choose>

		<c:when test="${empty signupSuccess}">
			<div class=container>
				<form:form action="empregister.htm"
					commandName="companyRegistration" method="post">
					<hr>
					<div class="jumbotron text-center">
						<p>Register and create your Job openings!</p>
					</div>
					<div id="message">
					<p style="color: red;"><c:out value="${message}"></c:out>  </p>
					</div>
					<table class=table>

						<tr>
							<td>Company Name:</td>
							<td><form:input path="name" size="30" /> <font color="red"><form:errors
										path="name" /></font></td>
						</tr>
						
						<tr>
							<td>Email:</td>
							<td><form:input path="email" size="30" /> <font color="red"><form:errors
										path="email" /></font></td>
						</tr>

						<tr>
							<td>Password:</td>
							<td><form:password path="password" size="30" /> <font
								color="red"><form:errors path="password" /></font></td>
						</tr>

						<tr>
							<td>Confirm Password:</td>
							<td><form:password path="confirmPassword" size="30" /> <font
								color="red"><form:errors path="confirmPassword" /></font></td>
						</tr>

						<tr>
							<td colspan="2"><input type="submit" value="Register" /></td>
							<td colspan="2"><a href="/lalit">Back to home</a></td>
						</tr>
					</table>

				</form:form>
			</div>
		</c:when>
		<c:otherwise>

			<div class=container>
				<div class="jumbotron text-center">
					<p> Thank you <c:out value="${company.name}"></c:out>! You have successfully registered with us</p>
					

					<a href="emplanding.htm"> Start posting you job applications by signing here!</a>

				</div>
			</div>
		</c:otherwise>

	</c:choose>
</body>
</html>