<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/lalit">Online Job Portal</a>
    </div>
    <ul class="nav navbar-nav">.
      <li class="active"><a href="/lalit/userlanding.htm">Home</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    	<c:choose>
    		<c:when test="${empty user}">
    			<li><a href="/lalit/register"><span class="glyphicon glyphicon-user"></span> Register </a></li>
    			<li><a href="/lalit/signin"><span class="glyphicon glyphicon-user"></span> Sign In </a></li>
    		</c:when>
    		<c:otherwise>
    			<li><a href="#" ><span class="glyphicon glyphicon-user"></span> Welcome, <c:out value="${sessionScope.user.firstname}"></c:out> </a></li>    			
      			<li><a href="user/<c:out value="${sessionScope.user.id}"></c:out>/update.htm"><span class="glyphicon glyphicon-pencil"></span> Update Profile </a></li>
      			<li><a href="user/<c:out value="${sessionScope.user.id}"></c:out>/myappliedjob.htm"><span class="glyphicon glyphicon-eye-open"></span> My Applications </a></li>
      			<li><a href="user/<c:out value="${sessionScope.user.id}"></c:out>/logout.htm"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>   		
    		
    		</c:otherwise>    	
    	</c:choose>
      
    </ul>
  </div>
</nav>
<!-- <script type="text/javascript">
$(document).ready(function(){
   
    
    document.getElementById("signin").onclick = function () {
        location.href = "signin.htm";
    };
    
    document.getElementById("empsignin").onclick = function () {
        location.href = "empsignin.htm";
    };
    
    document.getElementById("empregister").onclick = function () {
        location.href = "empregister.htm";
    };
    
});
</script>  -->

  
</body>
</html>
