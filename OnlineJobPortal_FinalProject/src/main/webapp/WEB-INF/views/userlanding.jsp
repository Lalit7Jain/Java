<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

.scrollabletextbox {
	height: 100px;
	width: 800px;
	font-family: Verdana, Tahoma, Arial, Helvetica, sans-serif;
	font-size: 82%;
	overflow: scroll;
}

.alert-success {
	color: #3c763d;
	background-color: #dff0d8;
	border-color: #d6e9c6;
}

.alert {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
}

.fade {
	opacity: 0;
	-webkit-transition: opacity .15s linear;
	-o-transition: opacity .15s linear;
	transition: opacity .15s linear;
}
</style>
<title>User Home</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty sessionScope.user}">
			<div class=container>
				<div class="jumbotron text-center">
					<p>Sign in before you can search and apply jobs!</p>
					<a href="signin.htm"> Sign In </a> <br /> <br /> <a
						href="register.htm"> No account yet? Register</a>
				</div>
			</div>

		</c:when>
		<c:otherwise>
			<jsp:include page="usernav.jsp"></jsp:include>

			<div class=container>
				<div class="col-sm-6">
					<h2>
						Hi
						<c:out value="${sessionScope.user.firstname}"></c:out>
						! Start your search here
					</h2>

				</div>

			</div>
			<div class=container>
				<div class="col-sm-12">
					<form id="search" action="searchresult.htm" method="get">
						<input type="text" name="text" maxlength="64"
							placeholder="Search for Job's" /> <input type="submit"
							onclick=" return opentable();" name="submit" value="Search" />

					</form>
				</div>
			</div>
			<c:choose>
				<c:when test="${empty listing}">

					<div id="message" class=container>
						<p>Sorry, we did not find any results matching your search!</p>

					</div>
					<br />

				</c:when>
				<c:otherwise>

					<div id="message" class=container>
						<p>
							We found <strong style="color: orange;"><c:out
									value="${fn:length(listing)}"></c:out></strong> results matching your
							search!
						</p>

					</div>
					<br />

					<div id="ajaxResult" class="container alert alert-success fade in"
						style="display: none"></div>
					
					
					<div class="col-md-12">
					<div id="results">
						<form>
							<table class="table">
							<thead  style="color: white; background: black;">
								<tr>
									<td>Job Id</td>
									<td>Company</td>
									<td>Title</td>
									<td>Description</td>
									<td>Salary</td>
									<td>Apply</td>
								</tr>
								</thead>
								<c:forEach varStatus="loop" var="item"
									items="${requestScope.listing}">
									<tr>
										<td><c:out value="${item.id}"></c:out></td>
										<td><c:out value="${item}"></c:out></td>
										<td><c:out value="${item.title}"></c:out></td>
										<td><textarea class="scrollabletextbox"><c:out
													value="${item.description}"></c:out></textarea></td>
										<td><c:out value="${item.salary}"></c:out>$ / Month</td>
										<td><input type="button" id="apply" class="apply"
											value="Apply" /></td>
									</tr>
								</c:forEach>
							</table>
							<input type="hidden" id="userId" value="${sessionScope.user.id}" />
						</form>
					</div>
					</div>

				</c:otherwise>
			</c:choose>


		</c:otherwise>

	</c:choose>
	<script type="text/javascript">
		var xmlHttp;
		var query = "";

		xmlHttp = GetXmlHttpObject();

		$('.apply')
				.click(
						function() {
							var $row = $(this).closest("tr");
							var $applyButton = $row.find("#apply");
							var listId = $(this).closest("tr").find('td:eq(0)')
									.text();
							var listTitle = $(this).closest("tr").find(
									'td:eq(2)').text();
							var userId = document.getElementById("userId").value;
							//alert("Listing id is:" + listId +" " + "User Id is: " + userId );

							query = "action=apply&listId=" + listId
									+ "&userId=" + userId;

							jQuery
									.ajax({

										url : 'applyJob.htm?' + query,
										success : function(result) {

											if (jQuery.trim(result) == "SUCCESS") {
												document
														.getElementById("ajaxResult").style.display = "block";
												document
														.getElementById("ajaxResult").innerHTML = "Congratulations! You have sucessfully applied for the Job Position of : "
														+ "<strong>"
														+ listTitle
														+ "</strong>";

												$row.css('background-color',
														'orange');
												$applyButton.attr('value',
														"Applied");
												$applyButton.prop('disabled',
														true);

											} else {

												alert("Sorry something went wrong! Try again");

											}

										}
									});

						});

		// function applyJob(listingId, rowId){
		// 	 var $row = $(this).closest("tr");
		// 	 var $applyButton = $row.find("#apply");

		// 	 var row = rowId;
		// 	 var listId = listingId;
		// 	 var userId = document.getElementById("userId").value;
		// 	 //alert("Listing id is:" + listingId+" " + "User Id is: " + userId );

		// 	 query = "action=apply&listId=" + listId +"&userId=" + userId;

		// 	 jQuery.ajax({

		// 	 	url: 'applyJob.htm?' + query,
		// 	 	success: function(result){
		// 	 		alert(result);
		// 	 		$row.css('background-color', 'green');
		// 	 		$applyButton.attr('value', "Applied");
		// 	 		$applyButton.prop('disabled', true);
		// 	 	}
		// 	 });

		// }

		function GetXmlHttpObject() {
			var xmlHttp = null;
			try {
				// Firefox, Opera 8.0+, Safari
				xmlHttp = new XMLHttpRequest();
			} catch (e) {
				// Internet Explorer
				try {
					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
				} catch (e) {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
			}
			return xmlHttp;
		}
	</script>

</body>
</html>