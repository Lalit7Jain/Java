<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/jqx.base.css" />" rel="stylesheet">
   
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="http://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">

    <style type="text/css">
        .labels {
            font-size: smaller;
        }
    </style>
  
<title> Application status here! </title>
</head>
<body>
 <jsp:include page="companynav.jsp"></jsp:include>
 <fieldset>
 <div class=container>
  <div class="row">
			<h2>
				
				<p> Candidates application for your listing is shown below</p>		
			</h2>
			<hr>
			</div>
 
 </div><br/><br/>
 </fieldset>
 <c:choose>
 <c:when test="${empty listofapplication}">
 <fieldset>
 <div class=container>
  <div class="row">
			<h2>
				<p> You do not have any application's now </p>	
				<a href="postjob.htm"> Create one now! </a>	
			</h2>
			</div>
 
 </div>
 </fieldset>
 </c:when>
 <c:otherwise>
<div class="container">
	<div class="row">
        <div class="col-md-6">
            <form action="#" method="get">
                <div class="input-group">
                    
                    <input class="form-control" id="system-search" name="q" placeholder="Search for" required>
                    <span class="input-group-btn">
                        <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
                    </span>
                    
                </div>
            </form>
            <br/><br/>
        </div>
		<div class="col-md-12">
    	 <table class="table table-list-search">
                    <thead style="color: white; background: black;">
                        <tr>
                            <td>Job Id</td>
					<td>Title</td>
					<td>Created Date</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Resume Path</td>
					<td>Email</td>
					<td>Phone</td>
					<td>Registration Date</td>
                        </tr>
                    </thead>
                    <tbody>
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
                    </tbody>
                </table>   
                <hr>
		</div>
	</div>
</div>
 <div class="container">
  			<h4>				
				<p> Chart view for Application's. <strong style="color: red;"> Hover for more details </strong></p>		
			</h4>
  <div id='chartContainer' style="width: 860px; height: 600px; margin-bottom: 25px;"></div>
 </div>
 
 </c:otherwise>
 
 </c:choose>
  
 <script>
 $(document).ready(function() {
	    var activeSystemClass = $('.list-group-item.active');

	    //something is entered in search form
	    $('#system-search').keyup( function() {
	       var that = this;
	        // affect all table rows on in systems table
	        var tableBody = $('.table-list-search tbody');
	        var tableRowsClass = $('.table-list-search tbody tr');
	        $('.search-sf').remove();
	        tableRowsClass.each( function(i, val) {
	        
	            //Lower text for case insensitive
	            var rowText = $(val).text().toLowerCase();
	            var inputText = $(that).val().toLowerCase();
	            if(inputText != '')
	            {
	                $('.search-query-sf').remove();
	                tableBody.prepend('<tr class="search-query-sf"><td colspan="6"><strong>Searching for: "'
	                    + $(that).val()
	                    + '"</strong></td></tr>');
	            }
	            else
	            {
	                $('.search-query-sf').remove();
	            }

	            if( rowText.indexOf( inputText ) == -1 )
	            {
	                //hide rows
	                tableRowsClass.eq(i).hide();
	                
	            }
	            else
	            {
	                $('.search-sf').remove();
	                tableRowsClass.eq(i).show();
	            }
	        });
	        //all tr elements are hidden
	        if(tableRowsClass.children(':visible').length == 0)
	        {
	            tableBody.append('<tr class="search-sf"><td class="text-muted" colspan="6">No entries found.</td></tr>');
	        }
	    });
	});
 </script>
 <script src="<c:url value="/resources/js/jqxcore.js" />"></script>
   <script src="<c:url value="/resources/js/jqxdata.js" />"></script>
   <script  src="<c:url value="/resources/js/jqxdraw.js" />"></script>
   <script src="<c:url value="/resources/js/jqxchart.core.js" />"></script>
 <script type="text/javascript">
 $(document).ready(
         function () {
             var source = {
                 datatype: "json",
                 datafields: [{
                     name: 'title',
                     type: 'string'
                 }, {
                     name: 'noofapplications',
                     type: 'int'
                 }],
                 url: '${pageContext.request.contextPath}/chart/applications.htm',
                 type: 'POST',
                 async: true
             };
             var dataAdapter = new $.jqx.dataAdapter(source);
             var settings = {
                 title: "Applications for Job Listing ",
                 description: "  ",
                 padding: {
                     left: 5,
                     top: 5,
                     right: 15,
                     bottom: 5
                 },
                 titlePadding: {
                     left: 90,
                     top: 0,
                     right: 0,
                     bottom: 10
                 },
                 source: dataAdapter,
                 xAxis: {
                     dataField: 'title',
                     displayText: 'Listing Title',
                     gridLines: {
                         visible: true
                     },
                     valuesOnTicks: false,
                     type: 'basic',
                     labels: {
                         class: 'labels',
                         angle: 90,
                         formatFunction: function (value) {
                             return value.replace(/\?/g, '');
                         }
                     },
                     flip: false
                 },
                 colorScheme: 'scheme02',
                 seriesGroups: [{
                     type: 'column',
                     columnsGapPercent: 30,
                     seriesGapPercent: 0,
                     orientation: 'horizontal',
                     valueAxis: {
                         minValue: 0,
                         unitInterval: 5,
                         description: 'No of applications',
                         flip: true
                     },
                     series: [{
                         dataField: 'noofapplications',
                         displayText: 'No of Applications'
                     }]
                 }]
             };
             $('#chartContainer').jqxChart(settings);
         });
 
 </script>
  <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>