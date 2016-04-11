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

<title> Application status here! </title>
</head>
<body>
 
 <fieldset>
 <div class=container>
  <div class="row">
			<h2>
				
				<p>Hello <c:out value="${sessionScope.company.name}"></c:out> . Job search application status below</p>		
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
                    <!-- USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH -->
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
		</div>
	</div>
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
</body>
</html>