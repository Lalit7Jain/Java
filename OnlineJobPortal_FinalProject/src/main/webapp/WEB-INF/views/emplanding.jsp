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
    <link href="<c:url value="/resources/css/jquery.jqplot.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.jqplot.min.js" />"></script>
    <script src="<c:url value="/resources/js/jqplot.barRenderer.js" />"></script>
    <script src="<c:url value="/resources/js/jqplot.categoryAxisRenderer.js" />"></script>
<title>Employer Home</title>
</head>
<body>
<jsp:include page="companynav.jsp"></jsp:include>
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
				<div class="col-sm-3">
					<button class="btn btn-default btn-lg glyphicon glyphicon-plus" id="addjob"> Add Listing!</button>

				</div>
				
				<div class="col-sm-3">
				<form action="managelisting.htm" method="post">
					<button class="btn btn-default btn-lg glyphicon glyphicon-wrench" id="addjob"> Manage my Listing!</button>
					<input type="hidden" name="compId" value="${sessionScope.company.id}">
				</form>
				</div>
				
				<div class="col-sm-6">
				<form action="checkappstatus.htm" method="post">
					<button class="btn btn-default btn-lg glyphicon glyphicon-stats" id="checkstatus"> Check Applications for your listings!</button>
						<input type="hidden" name="compId" value="${sessionScope.company.id}">
				</form>
				</div>
				
			</div>
			<div id="chart1" >
			
			
			</div>
						
<script type="text/javascript">
				$(document)
						.ready(
								function() {
									document.getElementById("addjob").onclick = function() {
										location.href = "postjob.htm";
									};


								});
</script>
			<script>
			$(document).ready(function(){
		        $.jqplot.config.enablePlugins = true;
		        var s1 = [2, 6, 7, 10];
		        var ticks = ['Software Developer', 'UI Developer', 'UX Web Design', 'Project Manager'];
		         
		        plot1 = $.jqplot('chart1', [s1], {
		            // Only animate if we're not using excanvas (not in IE 7 or IE 8)..
		            animate: !$.jqplot.use_excanvas,
		            seriesDefaults:{
		                renderer:$.jqplot.BarRenderer,
		                pointLabels: { show: true }
		            },
		            axes: {
		                xaxis: {
		                    renderer: $.jqplot.CategoryAxisRenderer,
		                    ticks: ticks
		                }
		            },
		            highlighter: { show: false }
		        });
		     
		        $('#chart1').bind('jqplotDataClick', 
		            function (ev, seriesIndex, pointIndex, data) {
		                $('#info1').html('series: '+seriesIndex+', point: '+pointIndex+', data: '+data);
		            }
		        );
		    });
			</script>


		</c:otherwise>
	</c:choose>
	
	
</body>

</html>