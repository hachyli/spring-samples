<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>

	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-1.7.2.min.js"/>'></script>
	<link type="text/css" href='<spring:url value="/resources/jquery/css/redmond/jquery-ui-1.8.21.custom.css"/>' rel="stylesheet" />	
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-ui-1.8.21.custom.min.js"/>'></script>
	
	<script type="text/javascript" src='<spring:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
	<link type="text/css" href='<spring:url value="/resources/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet" />
	<link type="text/css" href='<spring:url value="/resources/bootstrap/css/bootstrap-responsive.min.css"/>' rel="stylesheet" />
	
	<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      
      
    </style>
    
	<script>
	$(document).ready(function() {
			$('#loadPostsBtn').click(function () {
				loadPosts();
				return false;
			});

			$('#newPostSubmitBtn').click(function () {
				var newPostForm = $('#newPostForm');
				var text = $.trim($('#text').val());
				var userId = $.trim($('#inputPostedBy').val());
				if(text=='' || userId==''){
					alert("Please enter text and userId values.");
					return false;
				}
				$.ajax({
					type:"POST",
					url:"posts",
					dataType:"json",
					data: newPostForm.serialize(),
					success: function (data) {
												
						//alert(data);
						console.log(data);
						//alert(data.status);
						//var json = $.parseJSON(data);
						if(data.status == 'success'){
							$('#newPostStatus').html('<div id="statusAlert" class="alert"><p class="text-success"><strong>Posted Successfully</strong></p></div>');
							loadPosts();
							$('#statusAlert').fadeOut(4000,"swing");
						} else {
							alert("Unable to process request.");
						}
						
					}
				});
				return false;
			});

			function loadPosts()
			{
				$.ajax({
					type:"GET",
					url:"posts",
					dataType:"json",
					success: function (data) {
												
						//alert(data);
						console.log(data);
						var posts = data.posts;

						var tblHTML = '';
						tblHTML+='<table id="postsTbl" class="table table-striped table-bordered table-hover table-condensed" style="width:850px;">';
						tblHTML+='<thead class="success"><tr class="success"><th>Text</th><th>Posted Date</th></tr></thead>';
						tblHTML+='<tbody>';
						
						for(var i = 0; i < posts.length; i++)
						{
							var post = posts[i];
							tblHTML+='<tr><td>'+post['text']+'</td><td>'+post['createdOn']+'</td></tr>';
						}
						tblHTML+='</tbody>';
						tblHTML+='</table>';

						$('#postsDiv').html(tblHTML);
						/*
						var newTable = document.getElementById('postsTbl');
					    //newTable = oldTable.cloneNode(true);

						$("#postsTbl").empty();
						
						for(var i = 0; i < posts.length; i++){
						    var tr = document.createElement('tr');
					        var td_text = document.createElement('td');
					        td_text.appendChild(document.createTextNode(posts[i]['text']));
					        tr.appendChild(td_text);

					        var td_date = document.createElement('td');
					        td_date.appendChild(document.createTextNode(posts[i]['createdOn']));
					        tr.appendChild(td_date);
					        
						    newTable.appendChild(tr);
						}
						*/
						//oldTable.parentNode.replaceChild(newTable, oldTable);
					}
				});
			}
			loadPosts();
			setInterval(loadPosts, 60000);
		});
	</script>
</head>

<body>


<div class="container-fluid">
      <div class="row-fluid">
        <div class="span4">
          
		<div id="newPostDiv">
		
		
		<form id="newPostForm" class="form-horizontal">
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
			      <input type="text" id="inputPostedBy" name="createdBy.userId" placeholder="Enter UserId" value="1">
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

        </div><!--/span-->
        <div class="span8">
          <form action="#">
		<button id="loadPostsBtn" value="Refresh" class="btn btn-primary">Refresh</button>
	</form>
	<div id="postsDiv"></div>
        </div><!--/span-->
      </div><!--/row-->
      
	</div>
</body>

</html>