<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
	
	<link type="text/css" href='<spring:url value="/resources/jquery/css/redmond/jquery-ui-1.8.21.custom.css"/>' rel="stylesheet" />	
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-1.7.2.min.js"/>'></script>
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-ui-1.8.21.custom.min.js"/>'></script>
	<script>
	$(function() {

		$("#saveBtn").click(function() {
			var form = $('#createUserForm');
			if($.trim($('#userName').val())==''){
				alert('Please enter UserName');
				return false;
			}
			if($.trim($('#password').val())==''){
				alert('Please enter Password');
				return false;
			}
			if($.trim($('#firstName').val())==''){
				alert('Please enter FirstName');
				return false;
			}
			form.submit();
			
	    });
	    
	});
	</script>
</head>

<body>
	
	<div class="span6" style="background-color: #f5f5f5;">
	<c:if test="${not empty msg }">
			<div id="msg" class="alert alert-error">
				${msg}
			</div>
		</c:if>
	<h3>Create User:</h3>
	<form:form id="createUserForm" class="form-horizontal" 
			action="createUser.htm" method="post" commandName="user">
		<div class="control-group">
			<label class="control-label" for="UserName">UserName*</label>
			<div class="controls">
				<form:input path="userName" id="userName" />
			</div>
		</div>
		
		<div class="control-group">
		<label class="control-label" for="password">Password*</label>
			<div class="controls">
				<form:password path="password" id="password"  />
			</div>
		</div>
		
		<div class="control-group">
		<label class="control-label" for="firstName">FirstName*</label>
			<div class="controls">
				<form:input path="firstName" id="firstName" />
			</div>
		</div>
		<div class="control-group">
		<label class="control-label" for="lastName">LastName</label>
			<div class="controls">
				<form:input path="lastName" id="lastName" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="emailId">Email</label>
			<div class="controls">
				<form:input path="emailId" id="emailId" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="disabled">Disabled</label>
			<div class="controls">
				<form:select path="disabled" id="disabled">
					<form:option value="false">False</form:option>
					<form:option value="true">True</form:option>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button  class="btn btn-primary" id="saveBtn">Save</button>
				<a href="userhome.htm" class="btn">Back</a>
			</div>
		</div>
		
	</form:form>
	</div>
	
</body>

</html>