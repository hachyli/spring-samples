<%@ include file="taglib.jsp" %>

<div class="tabbable"> <!-- Only required for left/right tabs -->
  <ul class="nav nav-tabs">
    <li class="active"><a href="#tab1" data-toggle="tab">Home</a></li>
    <li><a href="#tab2" data-toggle="tab">Post Buzz</a></li>
  </ul>
  <div class="tab-content">
    <div class="tab-pane active" id="tab1">
      <table class="table table-striped table-bordered table-hover table-condensed">
			<thead>
				<tr class="success">
					<th>Buzz</th>
					<th width="100px;">Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="post" items="${POSTS_KEY}">
						<tr>
							<td>${post.text}</td>
							<td>${post.createdBy.userName}</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
    </div>
    <div class="tab-pane" id="tab2">
      
		<form id="newPostForm" class="form-horizontal" method="post" action="posts">
		<fieldset>
				<legend>New Post Form</legend>
			  <div class="control-group">
			    <label class="control-label" for="inputText">Text</label>
			    <div class="controls">
			      <textarea rows="5" cols="100" name="text" id="text"></textarea>
			    </div>
			  </div>
			  <div class="control-group">
			    <label class="control-label" for="inputPostedBy">Posted By</label>
			    <div class="controls">
			      <input type="text" id="inputPostedBy" name="createdBy.id" placeholder="Enter UserId" value="1">
			    </div>
			  </div>
			  <div class="control-group">
			    <div class="controls">
			      <button type="submit" class="btn btn-primary" id="newPostSubmitBtn">Post</button>
			    </div>
			  </div>
			  <div id="newPostStatus" >
			  </div>
			  </fieldset>
			</form>
			
    </div>
  </div>
</div>

