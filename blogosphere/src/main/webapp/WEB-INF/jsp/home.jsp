<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">

    
	</script>
</head>
<body>
 	
      <div class="tabbable"> <!-- Only required for left/right tabs -->
		  <ul class="nav nav-tabs">
		    <li class="active"><a href="#tab1" data-toggle="tab">User Details</a></li>
		    <li><a href="#tab2" data-toggle="tab">My Blogs</a></li>
		    <li><a href="#tab3" data-toggle="tab">All Blogs</a></li>
		  </ul>
		  
		  <div class="tab-content">
		    <div class="tab-pane active" id="tab1">
		      
				<form id="userForm" class="form-horizontal" action="#">
					
					<div class="control-group">
						<label class="control-label" for="inputUserId">UserId</label>
						<div class="controls">
							<input type="text" id="inputUserId" name="userId" value="${UserAccount.user.userId}" readonly="readonly">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputUserName">UserName</label>
						<div class="controls">
							<input type="text" id="inputUserName" name="userName" value="${UserAccount.user.userName}" readonly="readonly">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputEmailId">EmailId</label>
						<div class="controls">
							<input type="text" id="inputEmailId" name="emailId" value="${UserAccount.user.emailId}" readonly="readonly">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputFirstName">FirstName</label>
						<div class="controls">
							<input type="text" id="inputFirstName" name="firstName" value="${UserAccount.user.firstName}" readonly="readonly">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="inputLastName">LastName</label>
						<div class="controls">
							<input type="text" id="inputLastName" name="lastName" value="${UserAccount.user.lastName}" readonly="readonly">
						</div>
					</div>
					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn" id="updateUserBtn">Save</button>
						</div>
					</div>
				</form>
		    </div>
		    
		    <div class="tab-pane" id="tab2">
		    	<div>
		    		<p><a href="blogs/createBlog">Create New Blog</a></p>
		    	</div>
		      <c:forEach var="blog" items="${UserAccount.user.blogs}">
		      	<p><a href="blogs/${blog.blogId}">${blog.blogName}</a></p>
		      </c:forEach>
		    </div>
		    
		    <div class="tab-pane" id="tab3">
		    	
		      <c:forEach var="blog" items="${UserAccount.allBlogs}">
		      	<p><a href="blogs/${blog.blogId}">${blog.blogName}</a></p>
		      </c:forEach>
		    </div>
		    
		  </div>
		</div>
          
      
    	
</body>
</html>