<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title> Manage Listings! </title>
</head>
<body>
<jsp:include page="companynav.jsp"></jsp:include>

<div class="container">

 </fieldset>
 <c:choose>
 <c:when test="${empty managelistings}">
 <fieldset>
 <div class=container>
  <div class="row">
			<h2>
				<p> You have not posted any listings yet </p>	
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
        <div class="col-md-4"></div>
		<div class="col-md-2">
						<input type="button" class="refresh" value="Refresh" onClick="window.location.reload()"/>
		</div>
					
		<div class="col-md-12">
				<div id="ajaxResult" class="container alert alert-success fade in"
						style="display: none"></div>
					
		</div>
        
		<div class="col-md-12">
    	 <table class="table table-list-search">
                    <thead style="color: white; background: black;">
                        <tr>
                    <td>Listing Id</td>
					<td>Title</td>
					<td>Description</td>
					<td>Salary</td>
					<td>Contact Email</td>
					<td>Contact Phone </td>
					<td>Type </td>
					<td>Update</td>
					<td>Delete</td>
					   </tr>
                    </thead>
                    <tbody>
                        <c:forEach varStatus="loop" var="item" items="${requestScope.managelistings}">
					<tr>
						<td><c:out value="${item.id}"></c:out></td>
						<td><c:out value="${item.title}"></c:out></td>
						<td><c:out value="${item.description}"></c:out></td>
						<td><c:out value="${item.salary}"></c:out></td>
						<td><c:out value="${item.contactEmail}"></c:out></td>
						<td><c:out value="${item.contactPhone}"></c:out></td>
						<td><c:out value="${item.type}"></c:out></td>
						<td><input type="button" id="updateListing" class="updateListing" value="Update"/></td>
						<td><input type="button" id="delete" class="delete"	value="Delete" /></td>
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
 <script type="text/javascript">
 
 $('.delete').click(function() {
		var c = confirm("Are you sure you want to remove the listing?");
		if(c == true){
			var $row = $(this).closest("tr");
			var $withdrawButton = $row.find("#delete");
			var listId = $(this).closest("tr").find('td:eq(0)').text();		

			query = "listId=" + listId;

			jQuery
					.ajax({

						url : '/lalit/company/removelisting.htm?' + query,
						success : function(result) {

							if (jQuery.trim(result) == "SUCCESS") {
								document.getElementById("ajaxResult").style.display = "block";
								document.getElementById("ajaxResult").innerHTML = "You have sucessfully removed the listing with ID: "
										+ "<strong>"
										+ listId
										+ "</strong>";

								$row.css('background-color','orange');
								$withdrawButton.attr('value',"Removed");
								$withdrawButton.prop('disabled',true);

							} else {

								alert("Sorry something went wrong! Try again");

							}

						}
					});
			
		}
	});
 
 </script>
 <script type="text/javascript">
 
 $('.updateListing').click(function() {
	 var listId = $(this).closest("tr").find('td:eq(0)').text();
		//query = "listId=" + listId;
		location.href = "company/" + listId + "/updatelisting.htm";
 });
				
</script>
<jsp:include page="footer.jsp"></jsp:include>

</div>


</body>
</html>