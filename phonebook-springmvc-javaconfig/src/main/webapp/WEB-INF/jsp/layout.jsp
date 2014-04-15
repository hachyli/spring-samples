<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SivaLabs</title>
	
<link type="text/css" href='<spring:url value="/resources/css/style.css"/>' rel="stylesheet" />
<link type="text/css" href='<spring:url value="/resources/jquery/css/ui-lightness/jquery-ui-1.8.16.custom.css"/>' rel="stylesheet" />	
<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-1.6.2.js"/>'></script>
<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-ui-1.8.16.custom.min.js"/>'></script>
	<script>
	$(function() {
		//alert('jQuery initialized');
	});
	</script>
<decorator:head></decorator:head>
</head>

<body>
<div id="container">
	
    <div id="layoutHeader">
    	<h1><a href="#">SivaLabs</a></h1>
        <h2>My Experiments on Technology</h2>
    </div>
    <div id="userBanner">
    	Welcome <a href="showUser.htm">${LOGIN_USER.fullName}</a> &nbsp; 
    	<a href="logout.htm">Logout</a> &nbsp;
    </div>
    
    <!-- 	
    <div id="layoutMenu">
		<div id="smoothmenu1" class="ddsmoothmenu">
			<ul>
			<li><a href="#">Home</a></li>
			<li><a href="#">Products</a>
			  <ul>
			  <li><a href="#">Scheduler4J</a></li>
			  <li><a href="#">JCommunity</a></li>
			  <li><a href="#">CAAS</a></li>			  
			  </ul>
			</li>
			
			<li><a href="#">Training</a>
				<ul>
				
			<li><a href="#">Java</a>
			  <ul>
			  <li><a href="#">Core Java</a></li>
			  <li><a href="#">Frameworks</a>
			    <ul>
			    <li><a href="#">Hibernate/JPA</a></li>
			    <li><a href="#">Struts2</a></li>
			    <li><a href="#">Spring</a>
					<ul>
			    		<li><a href="#">Spring Core</a></li>
			    		<li><a href="#">SpringMVC</a></li>
			    		<li><a href="#">Spring Security</a></li>
					</ul>
			    </li>
			    <li><a href="#">JavaEE6</a></li>
			    </ul>
			  </li>
			  </ul>
			</li>
			</ul>
			</li>
			<li><a href="#">ContactUs</a></li>
			</ul>
			<br style="clear: left" />
			</div>


    	</div>
    	 -->
    <div id="layoutCenterBody">
    	
    	<div id="layoutNavigation">
        	<div class="navTitle"><h3>Navigation</h3></div>
            <ul>
               <li><a href="home.htm">Home</a></li>
                <li><a href="showUser.htm">My Profile</a></li>
                <li><a href="changePwd.htm">Change Password</a></li>
                <li><a href="phonebook.htm">PhoneBook</a></li>
                <li><a href="logout.htm">Logout</a></li>                
            </ul>
        </div>
        <div id="layoutBodyContent">
        	<decorator:body></decorator:body>
        </div>
    </div>
    <div class="clearer"></div>
    <div id="layoutFooter">
    	<p>
    		Copyright © 2012. <a href="http://sivalabs.blogspot.com" title="SivaLabs">SivaLabs</a>
        </p>
    </div>
</div>
</body>
</html>
