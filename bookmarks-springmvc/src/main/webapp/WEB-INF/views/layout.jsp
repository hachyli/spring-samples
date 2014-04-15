<!DOCTYPE html>

<%@ include file="taglib.jsp" %>

<html lang="en">
<head>
	<title>SivaLabs</title>
	
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-1.8.2.js"/>'></script>
	<!-- 
	<link type="text/css" href='<spring:url value="/resources/jquery/css/redmond/jquery-ui-1.8.21.custom.css"/>' rel="stylesheet" />	
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-ui-1.8.21.custom.min.js"/>'></script>
	 -->
	
	<script type="text/javascript" src='<spring:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
	<link type="text/css" href='<spring:url value="/resources/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet" />
	
	<style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
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
          <a class="brand" href="<spring:url value="userhome.htm"/>">BookMarks</a>
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

    <div class="container-fluid">
      <div class="row-fluid">
        
        <div class="span12">
          
          <div class="row-fluid">
            <decorator:body/>
          </div>
          
        </div>
      </div>

      <hr>

      <footer>
        <p>&copy; SivaLabs 2012</p>
      </footer>

    </div>
    
</body>
</html>