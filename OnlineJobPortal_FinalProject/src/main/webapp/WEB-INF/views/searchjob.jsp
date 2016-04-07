<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="http://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<style>
#search {
	float: right;
	margin-top: 9px;
	width: 250px;
}

.search {
	padding: 5px 0;
	width: 230px;
	height: 30px;
	position: relative;
	left: 10px;
	float: left;
	line-height: 22px;
}

.search input {
	position: absolute;
	width: 0px;
	float: Left;
	margin-left: 210px;
	-webkit-transition: all 0.7s ease-in-out;
	-moz-transition: all 0.7s ease-in-out;
	-o-transition: all 0.7s ease-in-out;
	transition: all 0.7s ease-in-out;
	height: 30px;
	line-height: 18px;
	padding: 0 2px 0 2px;
	border-radius: 1px;
}

.search:hover input, .search input:focus {
	width: 200px;
	margin-left: 0px;
}

.btn {
	height: 30px;
	position: absolute;
	right: 0;
	top: 5px;
	border-radius: 1px;
}

.scrollabletextbox {
    height:100px;
    width:800px;
    font-family: Verdana, Tahoma, Arial, Helvetica, sans-serif;
    font-size: 82%;
    overflow:scroll;
}
</style>
<title>Search jobs</title>

</head>


<body>


	<div class=container>
		<div class="row">
			<h2>
				Hi
				<c:out value="${sessionScope.user.firstname}"></c:out>
				! Start your search here
			</h2>
			<div>
				<form id="search" action="searchresult.htm" method="get">
					<input type="text" name="text" maxlength="64" placeholder="Search" />
					<input type="submit" name="submit" value="Search" />
					
				</form>
			</div>
		</div>
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
						<td><textarea class="scrollabletextbox"><c:out value="${item.description}"></c:out></textarea></td>
						<td><c:out value="${item.salary}"></c:out>$ / Month</td>
						<td><a href="#"> Apply </a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	




</body>
</html>