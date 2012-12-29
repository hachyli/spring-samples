<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">

    
	</script>
</head>
<body>
 	
	<form:form id="createPostForm" styleClass="form-horizontal" action="createPost" method="post" commandName="postForm">
		
		<div class="control-group">
			<label class="control-label" for="inputTitle">Title</label>
			<div class="controls">
				<form:input path="post.title"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputContent">Content</label>
			<div class="controls">
				<form:textarea path="post.content"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputTags">Tags</label>
			<div class="controls">
				<form:input path="tags"/>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn" id="saveBtn">Create Post</button>
			</div>
		</div>
		
		<div>
			<p>${postForm.errorMsg}</p>
		</div>
	</form:form>
      
    	
</body>
</html>