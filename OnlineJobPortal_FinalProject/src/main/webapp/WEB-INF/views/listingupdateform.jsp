<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Update listing </title>
</head>
<body>
<jsp:include page="companynav.jsp"></jsp:include>
<c:choose>

<c:when test="${!(message == null)}">
				<div class="container">
				 <h3> Your listing is been updated successfully </h3>
				 <a href="/lalit/emplanding.htm" > Back to home  </a>
				</div>
		</c:when>
		<c:when test="${empty listingupdate}">
<div class=container>
 <p> Something went wrong! Could not retrieve listing </p>
</div>

</c:when>
<c:otherwise>
<div class=container>
				<form:form commandName="listingupdate" method="post">
					<hr>
					<div class="jumbotron text-center">
						<h> Update Listing </h>
					</div>
					<table class="table">
				<tr>
					<td>Listing Id:</td>
					<td><form:input path="id" size="30" disabled="true" /> <font color="red"><form:errors
								path="id" /></font></td>
				</tr>
				
				<tr>
					<td>Created Date:</td>
					<td><form:input path="createDate" size="30" disabled="true" /> <font color="red"><form:errors
								path="createDate" /></font></td>
				</tr>
					
				<tr>
					<td>Job Title:</td>
					<td><form:input path="title" size="30" /> <font color="red"><form:errors
								path="title" /></font></td>
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
					<td colspan="2"><input type="submit" value="Update" /></td>
					<td colspan="2"><a href="/lalit/emplanding.htm">Back to home</a></td>
				</tr>
					</table>

				</form:form>
				</div>



</c:otherwise>
</c:choose>

</body>
</html>