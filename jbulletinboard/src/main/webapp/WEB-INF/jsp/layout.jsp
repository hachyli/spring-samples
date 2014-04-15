<%@page import="com.sivalabs.jbb.web.mvc.UserController"%>
<%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<script src="resources/jquery/js/jquery-1.8.2.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	
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
          <a class="brand" href="welcome">JBulletinBoard</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              Logged in as <a href="#" class="navbar-link"><%=UserController.getLoggedinUser().getUsername() %></a>&nbsp;
              <a href="../j_spring_security_logout">Logout</a>
            </p>
            <ul class="nav">
              <li class="active"><a href="welcome">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">Contact</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Sidebar</li>
              <li class="active"><a href="listUsers">Show Users</a></li>
              <li><a href="#">Link</a></li>
              <li><a href="#">Link</a></li>
              <li><a href="#">Link</a></li>
              <li class="nav-header">Sidebar</li>
              <li><a href="#">Link</a></li>
              
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span9">
          
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