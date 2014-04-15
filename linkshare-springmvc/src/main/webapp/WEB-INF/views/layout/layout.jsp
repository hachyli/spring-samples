<%@page import="com.sivalabs.linkshare.web.controllers.BaseController"%>
<%@page import="com.sivalabs.linkshare.web.controllers.ControllerHelper"%>
<%@page import="com.sivalabs.linkshare.entities.User"%>
<%@ include file="../taglib.jsp" %>

<html>
<head>
	<title><decorator:title default="Welcome!" /></title>
	<link rel="stylesheet" href='<spring:url value="/resources/css/style.css"/>'>
	
	<link type="text/css" href='<spring:url value="/resources/css/style.css"/>' rel="stylesheet" />
	<link type="text/css" href='<spring:url value="/resources/jquery/css/ui-lightness/jquery-ui-1.8.16.custom.css"/>' rel="stylesheet" />	
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-1.6.2.js"/>'></script>
	<script type="text/javascript" src='<spring:url value="/resources/jquery/js/jquery-ui-1.8.16.custom.min.js"/>'></script>
	<script>
	$(function() {
		$( "input:submit" ).button();
		$( "#siteLogo").mouseover(function(){
			$(this).addClass('cursor');
		});
		$( "#siteLogo").click(function(){
			window.location = '<spring:url value="/home.htm"/>';
		});
	});
	</script>
	
	<decorator:head/>
</head>
<body>
<div align="center">
<div class="site">
	<table class="tbl">
		<tbody>		  
		 <tr>
		 	<td colspan="2" class="header" >
		 		<span id="siteLogo">SivaLabs LinkShare</span>
		 	</td>
		 </tr>	
		 <tr>
		 	<td colspan="2" class="userBanner">
		 		<span class="textLabel">
				 <%
				 	boolean userLoggedin = BaseController.isUserLoggedIn(session);
				 	if(userLoggedin)
				 	{  		
				 		User user = BaseController.getLoggedInUser(session);
				 	%>
				 		Welcome <a class="link" href='<spring:url value="/showUserProfile.htm"/>'>
				 					<%=user.getFirstname()%> <%=user.getLastname()%>
				 				</a> &nbsp; | <a class="link" href='<spring:url value="/logout.htm"/>'>Logout</a>
				 	<%}
				 	else
				 	{ %> 	
				 	
					<a class="link" href='<spring:url value="/login.htm"/>'>Login</a> | 
					<a class="link" href='<spring:url value="/registration.htm"/>'>Register</a>
				
				 	<%}
				 %>
				 </span>
		 	</td>
		 </tr>
		 <tr>
		    <td valign="top" colspan="2">
		    	<table class="tbl">
		    		<tr>
		    			<td valign="top" class="workPanel">
		    				<decorator:body/>
		    			</td>
		    		</tr>
		    	</table>
		    </td>
		 </tr>
		 <tr class="footer" height="25">
	    	<td colspan="2">
	    		<a class="link" href="http://www.sivalabs.blogspot.com" target="_blank">
					http://www.sivalabs.blogspot.com. Version 1.0
				</a>
	   		 </td>
		 </tr>
		</tbody>
	</table>	
</div>
</div>
</body>
</html>