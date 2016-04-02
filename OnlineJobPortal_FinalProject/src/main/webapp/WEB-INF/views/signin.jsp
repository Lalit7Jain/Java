<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Sign In</title>
</head>
<body >

<div class="container">
 <div style="color: orange; background-color: inherit;" class="jumbotron text-center">
						<p> Please Sign In below your account credentials to explore more!</p>
</div>

<div class = "container">
	<form:form action="signin.htm" commandName="user"
			method="post">
		
<!-- 			<div class="jumbotron text-center"> -->
<!-- 				<h1> Sign in! </h1> -->
<!-- 			</div> -->
			<table width="100" class="table" style="border-style: dashed; font-style: italic; color: black;table-layout: auto; " align="center">
				<tr>
					<td>Email Id:</td>
					<td><form:input path="email" size="30" /> <font color="red"><form:errors
								path="email" /></font></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><form:password path="password" size="30" /> <font color="red"><form:errors
								path="password" /></font></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" value="Sign In" /></td>
					<td><a href="/lalit">Back to home</a></td>
				</tr>
			</table>
			<i>No account yet?</i><a href="register.htm"><i>Register here</i></a>
		</form:form>
	
</div>

</div>

</body>
</html>