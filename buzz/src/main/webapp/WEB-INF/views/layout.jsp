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
      body {
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
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Buzz</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="posts">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="logout">Logout</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">MyAccount <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li class="divider"></li>
                  <li class="nav-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li>
            </ul>
            <form class="navbar-form pull-right">
              <input class="span2" type="text" placeholder="Email">
              <input class="span2" type="password" placeholder="Password">
              <button type="submit" class="btn">Sign in</button>
            </form>
          </div><!--/.nav-collapse -->
        </div>
      </div>
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