<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buzz</title>

	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-1.7.2.min.js"/>'></script>
	<link type="text/css" href='<spring:url value="/resources/jquery/css/redmond/jquery-ui-1.8.21.custom.css"/>' rel="stylesheet" />	
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-ui-1.8.21.custom.min.js"/>'></script>

	<script type="text/javascript" src='<spring:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
	<link type="text/css" href='<spring:url value="/resources/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet" />
	<link type="text/css" href='<spring:url value="/resources/bootstrap/css/bootstrap-responsive.min.css"/>' rel="stylesheet" />

	<style type="text/css">
      body 
      {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      
    </style>
    
	<script>

	</script>
</head>

<body>

 <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          
          <a class="brand" href="#">Buzz</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="posts">Home</a></li>
              <li><a href="#about">About</a></li>
              
            </ul>
            
            <ul class="nav pull-right">
            	<li>
            	<form class="navbar-search" action="">
                <input type="text" name="query" class="search-query span2" placeholder="Search">
            	</form>
            	</li>
            	
               <li><a href="#myModal" data-toggle="modal">PostBuzz</a></li>
               <li><a href="logout">Logout</a></li>
               <li class="divider-vertical"></li>
               <li class="dropdown">
                 <a href="#" class="dropdown-toggle" data-toggle="dropdown">MyAccount<b class="caret"></b></a>
                 <ul class="dropdown-menu">
                   <li><a href="#">View Profile</a></li>
                   <li><a href="#">Settings</a></li>
                   <li class="divider"></li>
                   <li><a href="logout">Logout</a></li>
                 </ul>
               </li>
             </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
	
	<!-- Modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" 
			aria-labelledby="myModalLabel" aria-hidden="true">
		<form id="newPostForm" class="form-horizontal" method="post" action="posts">
	  <div class="modal-header">
	    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	    <h3 id="myModalLabel">Post Buzz</h3>
	  </div>
	  <div class="modal-body">
		
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
			  
			  <div id="newPostStatus" >
			  </div>
			  </fieldset>
			

	  </div>
	  <div class="modal-footer">
	    <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
	    <button type="submit" class="btn btn-primary" id="newPostSubmitBtn">Post</button>
	  </div>
	  </form>
	</div>

    <div class="container">

      <!-- Main hero unit for a primary marketing message or call to action -->
      <!-- 
      <div class="hero-unit">
        <h2>Welcome To SivaLabs</h2>
        <p>Learn and share.</p>
      </div>
       -->
	<decorator:body/>
		
      <hr>

      <footer>
        <p>&copy; SivaLabs 2013</p>
      </footer>

    </div> <!-- /container -->


</body>

</html>