<!DOCTYPE html>
<%@include file="taglib.jsp" %>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href='<spring:url value="resources/css/styles.css"/>' />
<script type="text/javascript" src='<spring:url value="resources/jquery/jquery-1.10.2.js"/>'></script>
<script type="text/javascript" src='<spring:url value="resources/js/app.js"/>'></script>
<script type="text/javascript">
$(document).ready(function() {
	//console.log("ready!");
	$("#loginForm").submit(function( event ) {
		  
		  var userName = $.trim($("#username").val());
		  var password = $.trim($("#password").val());
		  
		  if(userName == '' || password == '')
		  {
				alert("Please enter all mandatory fields");
				event.preventDefault();
				return false;
      	  }		   
	});
});
</script>
</head>
<body>
	<form:form id="loginForm" method="post" action="login" modelAttribute="user" 
		class="form-horizontal" role="form" cssStyle="width: 800px; margin: 0 auto;">
  <h2 class="form-signin-heading">User Login Form</h2>
		<c:if test="${param.error != null}">
                <div class="alert alert-error">
                    Invalid UserName and Password.
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="alert alert-success">
                    You have been logged out.
                </div>
            </c:if>
		<table>
			
			<tr>
				<td>UserName*</td>
				<td><input type="text" id="username" name="username" class="form-control" placeholder="UserName" /></td>
			</tr>
			<tr>
				<td>Password*</td>
				<td><input type="password" id="password" name="password" class="form-control" placeholder="Password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-primary" value="Login"> </td>
			</tr>
		      <tr>
		        <td>New User?</td>
		        <td><a href="register">Register</a> </td>
		      </tr>
		</table>
	</form:form>
	
</body>
</html>