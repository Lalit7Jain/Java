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
<title>Register here! First time user</title>
</head>
<body>
	<c:choose>

		<c:when test="${empty signupSuccess}">
			<div class=container>
				<form:form action="register.htm" commandName="userRegistration"
					method="post" enctype='multipart/form-data'>
					<hr>
					<div class="jumbotron text-center">
						<h> Signup for all the latest job posting available by
						established companies</h>
					</div>
					<div id=message>
						<p style="color: red;"><c:out value="${message}"></c:out></p>
					</div>
					<table class=table>
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
							<td>Title</td>
							<td><form:select path="title" id="title">
									<option>Please Select</option>
									<option>Mr</option>
									<option>Ms</option>
									<option>Miss</option>
									<option>Mrs</option>
									<option>Dr</option>
									<option>Prof</option>
								</form:select></td>
						</tr>

						<tr>
							<td>First Name:</td>
							<td><form:input path="firstName" size="30" /> <font
								color="red"><form:errors path="firstName" /></font></td>
						</tr>

						<tr>
							<td>Last Name:</td>
							<td><form:input path="lastName" size="30" /> <font
								color="red"><form:errors path="lastName" /></font></td>
						</tr>

						<tr>
							<td>Phone Number:</td>
							<td><form:input path="phone" size="10" /> <font color="red"><form:errors
										path="phone" /></font></td>
						</tr>

						<tr>
							<td>Upload Resume:</td>
							<td><form:input path="resume" type="file" /> <font
								color="red"><form:errors path="resume" /></font>
								<p>We accept .PDF / .DOCX / .DOC / .TXT / .RTF / .WP files
									up to 2Mb</p></td>

						</tr>

						<tr>
							<td>Susbscribe:</td>
							<td><form:checkbox path="subscribe" value="true" /> I'd
								like to subscribe to newsletter and receive the latest
								information about this site.</td>
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
					<h> Thank you! You have sucessfully registered with us</h>
					<p> Now, its our duty to get you the right companies which matches your skill</p>
					
					<a href="userlanding.htm" > Till that time, you can search jobs here</a>
					
				</div>
			</div>
		</c:otherwise>
		
	</c:choose>
</body>
</html>