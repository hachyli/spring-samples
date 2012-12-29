<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">

    
	</script>
</head>
<body>
	<h3>${postView.post.title}</h3> 
	<p>
		${postView.post.content}
	</p>
	<table class="table table-striped table-bordered table-hover">
		<tbody>
			<c:forEach var="comment" items="${postView.post.comments}">
	      		<tr>
	      			<td>
	      				${comment.content}<br/>
	      				${comment.createdBy.userName}<br/>
	      				${comment.createdOn}
	      			</td>
	      		</tr>
	      </c:forEach> 
		</tbody>
	</table>

<div>
	<form:form id="createCommentForm" styleClass="form-horizontal" action="${postView.post.postId}/comments/createComment" method="post" commandName="postView">
		
		<input type="hidden" name="newComment.postId" value="${postView.post.postId}">
		<div class="control-group">
			<label class="control-label" for="inputTitle">Title</label>
			<div class="controls">
				<form:input path="newComment.title"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputContent">Content</label>
			<div class="controls">
				<form:textarea path="newComment.content"/>
			</div>
		</div>
		
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn" id="saveBtn">Create Comment</button>
			</div>
		</div>
		
		<div>
			<p>${postView.errorMsg}</p>
		</div>
	</form:form>
</div>
    	
</body>
</html>