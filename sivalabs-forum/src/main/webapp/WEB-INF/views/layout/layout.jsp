<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
	<spring:url var="contextRoot" value="/" scope="session"/>
	<spring:url var="resourcesRoot" value="/resources/" scope="session"/>
	<%
		String root = "";//request.getContextPath();
	%>
	
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	<link rel="stylesheet" type="text/css" href="${resourcesRoot}css/style.css" />
	<link rel="stylesheet" type="text/css" href="${resourcesRoot}js/extjs/resources/css/ext-all.css" />
	<script type="text/javascript" src="${resourcesRoot}js/extjs/adapter/ext/ext-base.js"></script>
	<script type="text/javascript" src="${resourcesRoot}js/extjs/ext-all.js"></script>
 
 	<link type="text/css" href="${resourcesRoot}js/jquery/css/smoothness/jquery-ui-1.8.14.custom.css" rel="stylesheet" />	
	<script type="text/javascript" src="${resourcesRoot}js/jquery/js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="${resourcesRoot}js/jquery/js/jquery-ui-1.8.14.custom.min.js"></script>
		
	<script src ="${resourcesRoot}js/util.js" type="text/javascript"></script>
	
</head>
<body>


<CENTER>
	<table width="1000" cellspacing="0" cellpadding="0" border="0">
		<tbody>		  
		 <tr>
		 	<td>
		 		<tiles:insertAttribute name="header" />
		 	</td>
		 </tr>
		<tr>
		 	<td>
		 		<tiles:insertAttribute name="user_context" />
		 	</td>
		 </tr>		 
		 <tr>
		    <td valign="top">
		    	<table width="100%" height="430" cellspacing="1" cellpadding="0" border="0">
		    		<tr bgcolor="#DCE4ED">		    			
		    			<td valign="top">
		    				<tiles:insertAttribute name="body" />		    				
		    			</td>			    			
		    		</tr>
		    	</table>
		    </td>
		 </tr>
		 <tr>
	    	<td>
	    		<tiles:insertAttribute name="footer" />
	   		 </td>
		    </tr>
		</tbody>
	</table>	
</CENTER>
</body>
</html>