<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-1.8.2.js"/>'></script>
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
          <a class="brand" href="<spring:url value="/web/welcome"/>">Blogosphere</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              Logged in as <a href="<spring:url value="/web/home"/>" class="navbar-link">${sessionScope['LOGIN_USER'].firstName} ${sessionScope['LOGIN_USER'].lastName}</a>&nbsp;
              <a href="<spring:url value="/web/logout"/>">Logout</a>
            </p>
            <ul class="nav">
              <li class="active"><a href="<spring:url value="/web/home"/>">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">Contact</a></li>
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
          </div><!--/row-->
          
        </div><!--/span-->
      </div><!--/row-->

      <hr>

      <footer>
        <p>&copy; SivaLabs 2012</p>
      </footer>

    </div>
    	
</body>
</html>