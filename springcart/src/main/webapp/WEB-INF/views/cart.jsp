<%@ include file="taglib.jsp" %>



<table class="table table-striped table-bordered table-hover table-condensed">
	<caption>Your Cart</caption>
	<thead>
		<tr class="success">
			<th>Book</th>
			<th>Quantity</th>
		</tr>
	</thead>
	<tbody>
		<c:set var="cart" value="${ShoppingCart}" scope="session"/>
		<c:forEach var="item" items="${cart.items}">
		<tr>
			<td>${item.product.name}</td>
			<td>${item.quantity}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<form action="checkout" method="post">
	<div>
		<h3>Customer Details</h3>
		<p>Email*: <input type="text" name="customer.email" value="sivaprasadreddy.k@gmail.com"></p>
		<p>Password*: <input type="password" name="customer.password" value="siva"></p>
		<p>FirstName*: <input type="text" name="customer.firstName" value="Siva"></p>
		<p>LastName*: <input type="text" name="customer.lastName" value="K"></p>
		<p>Phone*: <input type="text" name="customer.phone" value="9000510456"></p>
	</div>
	
	<div>
		<h3>Shipping Address</h3>
		<p>ContactName*: <input type="text" name="shippingAddress.contactName" value="K. Siva Prasad Reddy"></p>
		<p>AddrLine1*: <input type="text" name="shippingAddress.addrLine1" value="Kukatpally"></p>
		<p>AddrLine2*: <input type="text" name="shippingAddress.addrLine2" value="Balaji Nagar"></p>
		<p>City*: <input type="text" name="shippingAddress.city" value="Hyderabad"></p>
		<p>State*: <input type="text" name="shippingAddress.state" value="AP"></p>
		<p>ZipCode*: <input type="text" name="shippingAddress.zipCode" value="500072"></p>
		<p>Country*: <input type="text" name="shippingAddress.country" value="India"></p>
	</div>
	
	<div>
		<h3>Billing Address</h3>
		<p>ContactName*: <input type="text" name="billingAddress.contactName" value="K. Siva Prasad Reddy"></p>
		<p>AddrLine1*: <input type="text" name="billingAddress.addrLine1" value="Kukatpally"></p>
		<p>AddrLine2*: <input type="text" name="billingAddress.addrLine2" value="Balaji Nagar"></p>
		<p>City*: <input type="text" name="billingAddress.city" value="Hyderabad"></p>
		<p>State*: <input type="text" name="billingAddress.state" value="AP"></p>
		<p>ZipCode*: <input type="text" name="billingAddress.zipCode" value="500072"></p>
		<p>Country*: <input type="text" name="billingAddress.country" value="India"></p>
	</div>
	
	<div>
		<h3>Payment Details</h3>
		<p>CreditCardNumber*: <input type="text" name="payment.creditCardNumber" value="123-456-789"></p>
		<p>CVV*: <input type="text" name="payment.cvv" value="123"></p>
		<p>Expiry Date*: <input type="text" name="payment.expiryDate" value="2015-12-30"></p>
	</div>
	
	<div>
		<input type="submit" value="Place Order">
	</div>
</form>