<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="http://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="companynav.jsp"></jsp:include>
	<c:choose>
	<c:when test="${empty listingname}">
	<div class=container>
			<hr>
			<div class="jumbotron text-center">
				<h> Post an add of your job description, and will find the right candidates for you</h>
			</div>
		<form:form action="postjob.htm" commandName="companyListing" method="post">
			
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table class=table>
				<tr>
					<td>Company Name:</td>
					<td><form:input path="name" value="${sessionScope.company.name}" disabled="true" size="30" /> <font color="red"><form:errors
								path="name" /></font></td>
				</tr>

				<tr>
					<td>Job Title:</td>
					<td><form:input path="title" size="30" /> <font color="red"><form:errors cssClass="error" path="title" /></font></td>
				</tr>

				<tr>
					<td>Description:</td>
					<td><form:textarea rows="40" cols="100" path="description" /> <font color="red"><form:errors
								path="description" placeholder="Add Job description here"/></font></td>
				</tr>

				<tr>
					<td>Salary :</td>
					<td><form:input path="salary" size="30" placeholder="Monthly estimate in $"/> <font color="red"><form:errors
								path="salary" /></font></td>
				</tr>

				<tr>
					<td>City Id:</td>
					<td><form:input path="cityId" size="30" /> <font color="red"><form:errors
								path="cityId" /></font></td>
				</tr>

				<tr>
					<td>Town Id:</td>
					<td><form:input path="townId" size="30" /> <font color="red"><form:errors
								path="townId" /></font></td>
				</tr>

				<tr>
					<td>Contact Email:</td>
					<td><form:input path="contactEmail" size="30" /> <font
						color="red"><form:errors path="contactEmail" /></font></td>
				</tr>

				<tr>
					<td>Contact Name:</td>
					<td><form:input path="contactName" size="30" /> <font
						color="red"><form:errors path="contactName" /></font></td>
				</tr>

				<tr>
					<td>Phone Number:</td>
					<td><form:input path="contactPhone" size="10" /> <font
						color="red"><form:errors path="contactPhone" /></font></td>
				</tr>

				<tr>
					<td>Job Type:</td>
					<td><form:input path="type" placeholder="Type 1 for Permanent and 2 for Temporary"/></td>
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
					<p> Thank you! You have successfully posted a Listing for: </p><b><c:out value="${listingname.title}"></c:out></b>
					<h> Now, its our duty to get you the right candidates which matches your requirements</h>
					
					<a href="emplanding.htm" > You can check the status of application's here </a>
					
				</div>
			</div>
	
	</c:otherwise>
</c:choose>
</body>
</html>