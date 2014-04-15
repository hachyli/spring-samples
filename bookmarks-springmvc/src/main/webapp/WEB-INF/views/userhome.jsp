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
			var form = $('#createBookMarkForm');
			if($.trim($('#title').val())==''){
				alert('Please enter Title');
				return false;
			}
			if($.trim($('#url').val())==''){
				alert('Please enter URL');
				return false;
			}
			form.submit();
			/*
			$.ajax( {
			      type: "POST",
			      url: 'createBookMark.htm',
			      data: form.serialize(),
			      success: function( response ) {
			        //alert( response+":"+response.status );
				        if(response == 'success')
					    {
							$('#msg').html('New Bookmark created successfully');
							window.location.replace("userhome.htm");
							
							$('#title').val('');
							$('#url').val();
							$('#description').val('');
							
					    }
				        else
				        {
			        		$('#msg').html('Unable to save New Bookmark');
				        }
			      }
			    } );
		    */
			 //return false;
	    });
	    
	});
	</script>
</head>

<body>
	
	<div class="span3" >
	<h3>New BookMark:</h3>
	<form id="createBookMarkForm" class="form" 
			action="createBookMark.htm" method="post" >
		
		<div class="control-group">
			<div class="controls">
				<input type="text" id="title" name="title" placeholder="Title"  class="span12">
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<input type="text" id="url" name="url" placeholder="URL" class="span12">
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<textarea rows="5" cols="50" id="description" name="description" placeholder="Description" class="span12"></textarea>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<input type="text" id="tagList" name="tagList" placeholder="Tags seperated by commas" class="span12">
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button  class="btn btn-small btn-primary" id="saveBtn">Save</button>
			</div>
		</div>
		<c:if test="${not empty msg }">
			<div id="msg" class="alert alert-error">
				${msg}
			</div>
		</c:if>
	</form>
	</div>
	<div class="span9">
	<h3>BookMarks</h3>
	<!-- 
	<div class="pagination pagination-centered">
	  <ul>
	    <li><a href="#">Prev</a></li>
	    <li><a href="#">1</a></li>
	    <li><a href="#">2</a></li>
	    <li><a href="#">3</a></li>
	    <li><a href="#">4</a></li>
	    <li><a href="#">Next</a></li>
	  </ul>
	</div>
	-->
	<ul class="pager">
	  
	  	<c:if test="${hasPreviousPage eq true }">
	  		<li class="previous">
	  			<a href="userhome.htm?page=${currentPage-1}">&larr; Older</a>
	  		</li>
	  	</c:if>
	    <c:if test="${hasPreviousPage eq false }">
	    	<li class="previous disabled">
	  			<a href="#">&larr; Older</a>
	  		</li>
	  	</c:if>
	  
	  <c:if test="${hasNextPage eq true }">
	  		<li class="next">
	  			<a href="userhome.htm?page=${currentPage+1}">Newer &rarr;</a>
	  		</li>
	  	</c:if>
	    <c:if test="${hasNextPage eq false }">
	    	<li class="next disabled">
	  			<a href="#">Newer &rarr;</a>
	  		</li>
	  	</c:if>
	</ul>
	
	<div>
		<table class="table table-hover table-striped table-bordered">
			
			<tbody>
				<c:if test="${BOOKMARKS != null }">
					<c:forEach items="${BOOKMARKS}" var="bm">
						
						<tr>
							<td>
								<a href="${bm.url}" target="_blank"><font size="4">${bm.title}</font></a><br/>${bm.description}<br/>
								Tags: ${bm.formattedTags}
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<ul class="pager">
	  
	  	<c:if test="${hasPreviousPage eq true }">
	  		<li class="previous">
	  			<a href="userhome.htm?page=${currentPage-1}">&larr; Older</a>
	  		</li>
	  	</c:if>
	    <c:if test="${hasPreviousPage eq false }">
	    	<li class="previous disabled">
	  			<a href="#">&larr; Older</a>
	  		</li>
	  	</c:if>
	  
	  <c:if test="${hasNextPage eq true }">
	  		<li class="next">
	  			<a href="userhome.htm?page=${currentPage+1}">Newer &rarr;</a>
	  		</li>
	  	</c:if>
	    <c:if test="${hasNextPage eq false }">
	    	<li class="next disabled">
	  			<a href="#">Newer &rarr;</a>
	  		</li>
	  	</c:if>
	</ul>
	</div>
	</div>
</body>

</html>