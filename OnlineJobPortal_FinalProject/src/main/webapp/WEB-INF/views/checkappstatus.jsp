<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title> Application status here! </title>
</head>
<body>
 
 <div class=container>
  <div class="row">
			<h2>
				
				<c:out value="${sessionScope.user.firstname}"></c:out> . Job search application status below				
			</h2>
			</div>
 
 </div>
 <c:choose>
 <c:when test="${empty listofapplication}">
 <div class=container>
  <div class="row">
			<h2>
				<p> You do not have any application's now </p>	
				<a href="postjob.htm"> Create one now! </a>	
			</h2>
			</div>
 
 </div>
 </c:when>
 <c:otherwise>
 <div id="appstatus">
		<form>
			<table class="table" style="border-bottom-style: ridge; outline-style: solid;border-right-color: orange; ">
				<tr style="background-color: orange; font-size: medium;">					
					<td>Job Id</td>
					<td>Title</td>
					<td>Created Date</td>
					<td>First Name</td>
					<td>Resume Path</td>
					<td>Email</td>
					<td>Phone</td>
					<td>Registration Date</td>
				</tr>

				<c:forEach varStatus="loop" var="item" items="${requestScope.listofapplication}">
					<tr>
						<td><c:out value="${item.jobId}"></c:out></td>
						<td><c:out value="${item.title}"></c:out></td>
						<td><c:out value="${item.createDate}"></c:out></td>
						<td><c:out value="${item.firstname}"></c:out></td>
						<td><c:out value="${item.lastname}"></c:out></td>
						<td><c:out value="${item.path}"></c:out></td>
						<td><c:out value="${item.email}"></c:out></td>
						<td><c:out value="${item.phone}"></c:out></td>						
						<td><c:out value="${item.registrationDate}"></c:out></td>
					</tr>
				</c:forEach>				
			</table>			
		</form>
	</div>
  
 
 </c:otherwise>
 
 </c:choose>
 


</body>
</html>