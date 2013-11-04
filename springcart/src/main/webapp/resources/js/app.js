$(document).ready(function() {
	updateCartItemCount();
	
	$("#viewCartLabel").click(function(){
		//alert(1);
		updateCartItemDetails();
	});
});

function addToCart(productId)
{
	$.ajax({
		type:"POST",
		dataType: 'json',
		url:"addToCart",
		data:{ productId: productId },
		success:function(response) {
			
			updateCartItemCount();
			alert(response.message);
		}
	});
}

function updateCartItemCount()
{
	$.ajax({
		type:"GET",
		dataType: 'json',
		url:"getCartItemCount",
		success:function(response) {
			$("#viewCartLabel").html("Cart("+response.message+")");
		}
	});
}

function updateCartItemDetails()
{
	$.ajax({
		type:"GET",
		dataType: 'json',
		url:"getShoppingCart",
		success:function(response) {
			var cartItemsHtml = "";
			var count = response.items.length;
			for( var i=0; i< count; i++)
			{
				var item = response.items[i];
				cartItemsHtml = cartItemsHtml+ "<p> Title: "+item.product.name+", Quantity: "+item.quantity+"</p>";
			}
			$("#cartItemDetails").html(cartItemsHtml);
		}
	});
}