<%@ include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SivaLabs</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="resources/css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="resources/smoothmenu/ddsmoothmenu.css" />
<link rel="stylesheet" type="text/css" href="resources/smoothmenu/ddsmoothmenu-v.css" />

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="resources/smoothmenu/ddsmoothmenu.js">


/***********************************************
* Smooth Navigational Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<script type="text/javascript">

ddsmoothmenu.init({
	mainmenuid: "smoothmenu1", //menu DIV id
	orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
	classname: 'ddsmoothmenu', //class added to menu's outer DIV
	//customtheme: ["#1c5a80", "#18374a"],
	contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
})
</script>

</head>

<body>
<div id="container">
	
    <div id="layoutHeader">
    	<h1><a href="#">SivaLabs</a></h1>
        <h2>My Experiments on Technology</h2>
    </div>
    <div id="userBanner">
    	Welcome Guest! &nbsp; 
    	<a href="login.htm">Login</a> &nbsp;
    	<a href="registration.htm">Register</a> &nbsp;
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
    	<!-- 
    	<div id="layoutNavigation">
        	<div class="navTitle"><h3>Navigation</h3></div>
            <ul>
               <li><a href="home.htm">Home</a></li>
                <li><a href="showUser.htm">My Profile</a></li>
                <li><a href="changePwd">Change Password</a></li>
                <li><a href="logout.htm">Logout</a></li>                
            </ul>
        </div>
         -->
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
