<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">

    
	</script>
</head>
<body>
 	
	<form:form id="createBlogForm" styleClass="form-horizontal" action="createBlog" method="post" commandName="blogForm">
		
		<div class="control-group">
			<label class="control-label" for="inputBlogName">BlogName</label>
			<div class="controls">
				<form:input path="blogName"/>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn" id="saveBtn">Create</button>
			</div>
		</div>
		
		<div>
			<p>${blogForm.errorMsg}</p>
		</div>
	</form:form>
      
    	
</body>
</html>