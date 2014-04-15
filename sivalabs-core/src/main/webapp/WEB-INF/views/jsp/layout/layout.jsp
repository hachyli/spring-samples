<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://sivalabs.blogspot.com/tags" prefix="sl"%>

<%@ include file="../taglib.jsp" %>
<html>
<head>
	<spring:url var="contextRoot" value="/" scope="session"/>
	<spring:url var="resourcesRoot" value="/resources/" scope="session"/>
	
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
	
	<!--  ********** EXTJS ********** -->
	<sl:cssInclude path="resources/js/extjs/resources/css/ext-all.css"/>
	
	<sl:jsInclude path="resources/js/extjs/adapter/ext/ext-base.js"/>
	<sl:jsInclude path="resources/js/extjs/ext-all.js"/>
	
	<!-- ************************************* -->
	
	<!--  ********** JQuery ********** -->
	<sl:cssInclude path="resources/js/jquery/css/smoothness/jquery-ui-1.8.14.custom.css"/>
	
	<sl:jsInclude path="resources/js/jquery/js/jquery-1.5.1.min.js"/>
	<sl:jsInclude path="resources/js/jquery/js/jquery-ui-1.8.14.custom.min.js"/>
	
	<!-- ************************************* -->
	
	<sl:cssInclude path="resources/css/style.css"/>
	<sl:jsInclude path="resources/js/util.js"/>
	
	 
</head>
<body>

<div align="center">
	<table width="1000" cellspacing="0" cellpadding="0" border="1">
		<tbody>		  
		 <tr>
		 	<td colspan="2">
		 		<tiles:insertAttribute name="header" />
		 	</td>
		 </tr>			 
		 <tr>
		 	<td width="20%" valign="top">
		 		<tiles:insertAttribute name="navigation" />
		 	</td>
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
	    	<td colspan="2">
	    		<tiles:insertAttribute name="footer" />
	   		 </td>
		 </tr>
		</tbody>
	</table>	
</div>

</body>
</html>