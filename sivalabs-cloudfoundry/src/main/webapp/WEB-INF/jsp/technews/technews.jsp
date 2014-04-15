<%@page import="com.sivalabs.technews.TechNewsFeedSite"%>
<%@include file="../taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SivaLabs : TechNews</title>
</head>
<body>
<div style="height: 600px; overflow: auto; ">
	
	<%
	TechNewsFeedSite[] techNewsFeedSites = TechNewsFeedSite.values();
	for(int i=0; i< techNewsFeedSites.length; i++)
	{%>
		<p><a href="techNewsFeed.htm?siteId=<%=techNewsFeedSites[i].getId()%>"><%=techNewsFeedSites[i].getName() %> </a> </p>
	<%}
	%>
</div>
</body>
</html>