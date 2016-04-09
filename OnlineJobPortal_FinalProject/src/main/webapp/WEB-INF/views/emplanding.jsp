<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Employer Landing</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty sessionScope.company}">
			<div class=container>
				<div class="jumbotron text-center">
				<p>Sign in before you can add Jobs! </p>
				<a href="empsignin.htm"> Sign In </a> <br/> <br/>
				<a href="empregister.htm"> No account yet? Register</a>
				</div>
			</div>

		</c:when>
		<c:otherwise>

			<div class=container>
				<div class="jumbotron text-center">
					<p>
						Welcome
						<c:out value="${sessionScope.company.name}"></c:out>
						! Add jobs and check your application status here
					</p>
				</div>
			</div>

			<div class="row text-center slideanim">
				<div class="col-sm-6">
					<button class="btn btn-default btn-lg" id="addjob">Add a
						Job Opening!</button>

				</div>
				<form>
				<div class="col-sm-6">
					<button class="btn btn-default btn-lg" id="checkstatus">Check
						status of your application</button>

				</div>
				<input type="hidden" name="l" value="${sessionScope.company.id}">
				</form>
			</div>
			<script type="text/javascript">
				$(document)
						.ready(
								function() {
									document.getElementById("addjob").onclick = function() {
										location.href = "postjob.htm";
									};

									document.getElementById("checkstatus").onclick = function() {
										location.href = "checkappstatus.htm";
									};

								});
			</script>


		</c:otherwise>
	</c:choose>
</body>
</html>