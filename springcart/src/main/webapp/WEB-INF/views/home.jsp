<%@ include file="taglib.jsp" %>


<c:forEach var="category" items="${CATEGORIES_KEY}">
	
	<table class="table table-striped table-bordered table-hover table-condensed">
		<thead>
			<tr class="success">
				<th>${category.name}</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${category.products}">
			<tr>
				<td>
				<div>
					<p>Title: ${product.name}</p>
					<p>Price: ${product.price}</p>
					<p><img alt="${product.name}" src="resources/images/book_covers/${product.imageUrl}"></p>
					<p><button id="addCartBtn" onclick="javascript:addToCart(${product.id})">Add to Cart</button>
				</div>
				
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</c:forEach>
