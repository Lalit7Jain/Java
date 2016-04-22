<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

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
<title>My Applications</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty myapplicationlist}">
			<fieldset>
				<div class=container>
					<div class="row">
						<h2>
							<p style="color: red;"> You are not authorized for this access! Please sign in below to authenticate </p>
							<a href="/lalit/signin.htm"> Sign In! </a>
						</h2>
					</div>

				</div>
			</fieldset>


		</c:when>
		<c:otherwise>
		<jsp:include page="usernav.jsp"></jsp:include>
			<c:if test="${empty noofapplication}">
				<fieldset>
					<div class=container>
						<div class="row">
							<h2>
								<p>You have not applied for any application's yet!</p>
								<a href="userlanding.htm"> Start Applying here</a>
							</h2>
						</div>

					</div>
				</fieldset>

			</c:if>
			
			
			<div class="container">
				<div class="row">
				 <br/>
				 <br/>
				 <p>   You have applied for <c:out value="${ noofapplication }"></c:out> jobs </p>
				<hr/>
				</div>
				<div class="row">
					<div class="col-md-6">
						<form action="#" method="get">
							<div class="input-group">

								<input class="form-control" id="system-search" name="q"
									placeholder="Search for" required> <span
									class="input-group-btn">
									<button type="submit" class="btn btn-default">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</span>

							</div>
						</form>
						<br />
						<br />
					</div>
					<div class="col-md-4"></div>
					<div class="col-md-2">
						<input type="button" class="refresh" value="Refresh" onClick="window.location.reload()"/>
					</div>
					
					<div class="col-md-12">
					<div id="ajaxResult" class="container alert alert-success fade in"
						style="display: none"></div>
					
					</div>
					
					
					
					<div class="col-md-12">
						<table class="table table-list-search" id="applicationtable">
							<thead style="color: white; background: black;">
								<tr>
									<td>Application Id</td>
									<td>Job Id</td>
									<td>Company Name</td>
									<td>Title</td>
									<td>Creation Date</td>
									<td>Salary</td>
									<td>Withdraw Application</td>
								</tr>
							</thead>
							<tbody>
								<c:forEach varStatus="loop" var="item"
									items="${requestScope.myapplicationlist}">
									<tr>
										<td><c:out value="${item.appId}"></c:out></td>
										<td><c:out value="${item.jobId}"></c:out></td>
										<td><c:out value="${item.name}"></c:out></td>
										<td><c:out value="${item.createDate}"></c:out></td>
										<td><c:out value="${item.title}"></c:out></td>
										<td><c:out value="${item.salary}"></c:out></td>
										<td><input type="button" id="withdraw" class="withdraw"
											value="Withdraw Application" /></td>
									</tr>
									
								</c:forEach>
							</tbody>
						</table>
						<td colspan="2"><a href="/lalit/userlanding.htm">Back to Search</a></td>
						<hr>
					</div>
				</div>
			</div>
			
		</c:otherwise>
	</c:choose>
	<script>
		$(document)
				.ready(
						function() {
							var activeSystemClass = $('.list-group-item.active');

							//something is entered in search form
							$('#system-search')
									.keyup(
											function() {
												var that = this;
												// affect all table rows on in systems table
												var tableBody = $('.table-list-search tbody');
												var tableRowsClass = $('.table-list-search tbody tr');
												$('.search-sf').remove();
												tableRowsClass
														.each(function(i, val) {

															//Lower text for case insensitive
															var rowText = $(val)
																	.text()
																	.toLowerCase();
															var inputText = $(
																	that)
																	.val()
																	.toLowerCase();
															if (inputText != '') {
																$(
																		'.search-query-sf')
																		.remove();
																tableBody
																		.prepend('<tr class="search-query-sf"><td colspan="6"><strong>Searching for: "'
																				+ $(
																						that)
																						.val()
																				+ '"</strong></td></tr>');
															} else {
																$(
																		'.search-query-sf')
																		.remove();
															}

															if (rowText
																	.indexOf(inputText) == -1) {
																//hide rows
																tableRowsClass
																		.eq(i)
																		.hide();

															} else {
																$('.search-sf')
																		.remove();
																tableRowsClass
																		.eq(i)
																		.show();
															}
														});
												//all tr elements are hidden
												if (tableRowsClass
														.children(':visible').length == 0) {
													tableBody
															.append('<tr class="search-sf"><td class="text-muted" colspan="6">No entries found.</td></tr>');
												}
											});
						});
	</script>
	<script type="text/javascript">
	
	$(".refresh").click(function(){
		//window.location.reload();
		//document.getElementById("applicationtable").refresh();
	});
	
	$('.withdraw').click(function() {
		var c = confirm("Are you sure you want to withdraw the application?");
		if(c == true){
			var $row = $(this).closest("tr");
			var $withdrawButton = $row.find("#withdraw");
			var appId = $(this).closest("tr").find('td:eq(0)').text();		

			query = "action=withdraw&appId=" + appId;

			jQuery
					.ajax({

						url : '/lalit/withdrawapplication.htm?' + query,
						success : function(result) {

							if (jQuery.trim(result) == "SUCCESS") {
								document.getElementById("ajaxResult").style.display = "block";
								document.getElementById("ajaxResult").innerHTML = "You have sucessfully withdrawn the application with ID: "
										+ "<strong>"
										+ appId
										+ "</strong>";

								$row.css('background-color','orange');
								$withdrawButton.attr('value',"Withdraw");
								$withdrawButton.prop('disabled',true);

							} else {

								alert("Sorry something went wrong! Try again");

							}

						}
					});
			
		}
	});
	
	
	
	</script>

</body>
</html>