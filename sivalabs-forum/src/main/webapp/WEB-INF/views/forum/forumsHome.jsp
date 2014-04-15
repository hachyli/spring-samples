<%@include file="../taglib.jsp"%>

<table class="bodyText" width="100%">
  <tr bgcolor="#B0C4DE">
    <th class="bigText" width="200">Forum</th>
    <th class="bigText" width="100">Topics</th>
    <th class="bigText">Last Post</th>
    <th class="bigText" width="250">Moderators</th>
    
  </tr>
	<c:forEach var="forum" items="${forums}">
	 <tr>
	    <td> 
	    	<a href="${contextRoot}forums/${forum.forumId}">
	    		<span class="bigText">${forum.forumName}</span>
	    	</a> 
	    </td>
	    <td>
	    ${forum.topicsCount}
	    </td>
	    <td>
	    ${forum.lastTopicDescription}
	    </td>
	    <td>
	    Siva
	    </td>
	    
	  </tr>
	</c:forEach>
</table>