<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">

    
	</script>
</head>
<body>
	<h3>${Blog.blog.blogName}</h3> 
	<p><a href="${Blog.blog.blogId}/createPost">Create New Post</a></p>
	<table class="table table-striped table-bordered table-hover">
		
		<thead>
			<tr class="success">
				<td><h4>Post</h4></td>
				<td><h4>Created On</h4></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="post" items="${Blog.blog.posts}">
	      		<tr>
					<td><a href="${Blog.blog.blogId}/posts/${post.postId}">${post.title }</a></td>
					<td>${post.createdOn }</td>
				</tr>
	      </c:forEach> 
		</tbody>
	</table>

    	
</body>
</html>