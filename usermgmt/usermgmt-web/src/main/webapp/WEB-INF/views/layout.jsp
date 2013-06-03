<!DOCTYPE html>

<%@ include file="taglib.jsp" %>

<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>SivaLabs</title>
	
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-1.7.2.min.js"/>'></script>
	
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
	$(function() {
		
	});
	</script>
	
	<decorator:head/>	
</head>
<body>

	 
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="<spring:url value="userhome.htm"/>">User Management</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              Logged in as <a href="<spring:url value="#"/>" class="navbar-link">${sessionScope['LOGIN_USER'].userName}</a>&nbsp;
              <a href="<spring:url value="logout.htm"/>">Logout</a>
            </p>
            <ul class="nav">
              <li class="active"><a href="<spring:url value="userhome.htm"/>">Home</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
	<div class="container">
		<!-- 
		<div class="hero-unit" style="padding: 15px;">
        <h2>User Management</h2>
        <p>This System used to manage the application Users. </p>
     	</div>
		 -->
      
      <div class="row">
      	<div class="span12">
      	 <decorator:body/>
      	</div>
      </div>
    
    </div>
</body>
</html>