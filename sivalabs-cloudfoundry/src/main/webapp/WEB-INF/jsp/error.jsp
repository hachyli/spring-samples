<%@page isErrorPage="true" %>
<%@page import="java.io.PrintWriter" %>

<script type="text/javascript">
function toggleStackTrace(){
	var isVisible = document.getElementById("stackTrace").style.display;
	if(isVisible!='none'){
		document.getElementById("stackTrace").style.display="none";
	}else{
		document.getElementById("stackTrace").style.display = "block";
	}
}

</script>
<p><a href="page.do?view=welcome">Home</a></p>

<h2>
<span style="color: red">Some problem encountered.</span><br/>
</h2>

<div>
<%=exception.getMessage()%>
</div>

<br/><br/>
<h2>StackTrace:</h2>
<input type="button" value="Show/Hide" onclick="javascript:toggleStackTrace();"/>
<div id="stackTrace" style="display: none;">
<div style="overflow: scroll; height: 300;">
<% exception.printStackTrace(new PrintWriter(out)); %>
</div>
</div>


