<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SpringCart</title>

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
          <a class="brand" href="#">SpringCart</a>
          
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