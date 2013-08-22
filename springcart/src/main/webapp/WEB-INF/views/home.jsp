<%@ include file="taglib.jsp" %>


<table class="table table-striped table-bordered table-hover table-condensed">
<thead>
	<tr class="success">
		<th>Category</th>
	</tr>
</thead>
<tbody>
	<c:forEach var="category" items="${CATEGORIES_KEY}">
	<tr>
		<td>${category.name}</td>
	</tr>
</c:forEach>
	</tbody>
</table>
    