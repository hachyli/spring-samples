package com.sivalabs.springcart.web;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.springcart.entities.Customer;
import com.sivalabs.springcart.entities.Order;
import com.sivalabs.springcart.entities.OrderItem;
import com.sivalabs.springcart.entities.Product;
import com.sivalabs.springcart.services.CatalogService;
import com.sivalabs.springcart.services.CustomerService;
import com.sivalabs.springcart.services.OrderService;
import com.sivalabs.springcart.web.model.AjaxResponse;
import com.sivalabs.springcart.web.model.LineItem;
import com.sivalabs.springcart.web.model.ShoppingCart;

/**
 * @author Siva
 *
 */
@Controller
//@RequestMapping("/")
public class CartController implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired private CustomerService customerService;
	@Autowired private CatalogService catalogService;
	@Autowired private OrderService orderService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat , true));
	}
	
	@RequestMapping("/addToCart")
	@ResponseBody
	public AjaxResponse addToCart(@RequestParam("productId") Integer productId, HttpServletRequest request) 
	{
		AjaxResponse ajaxResponse = new AjaxResponse();
		Product product = catalogService.findProduct(productId);
		ShoppingCart shoppingCart = getShoppingCart(request);
		LineItem item = shoppingCart.getLineItem(product.getId());
		if(item!= null){
			item.setQuantity(item.getQuantity()+1);
			logger.info("Increased Product '"+product.getName()+"' quantity to "+item.getQuantity());
			ajaxResponse.setMessage("Increased Product '"+product.getName()+"' quantity to "+item.getQuantity());
		} else {
			item = new LineItem();
			item.setProduct(product);
			item.setQuantity(1);
			shoppingCart.addItem(item);
			logger.info("Added Product '"+product.getName()+"' to Cart.");
			ajaxResponse.setMessage("Added Product '"+product.getName()+"' to Cart.");
		}
		
		return ajaxResponse;
	}
	
	@RequestMapping(value="/getShoppingCart", produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ShoppingCart getShoppingCart(HttpServletRequest request)
	{
		ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("ShoppingCart");
		if(shoppingCart == null)
		{
			shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("ShoppingCart", shoppingCart);
		}
		return shoppingCart;
	}
	
	
	@RequestMapping("/getCartItemCount")
	@ResponseBody
	public AjaxResponse getCartItemCount(HttpServletRequest request)
	{
		AjaxResponse ajaxResponse = new AjaxResponse();
		int count = getShoppingCart(request).getProductsCount();
		ajaxResponse.setMessage(String.valueOf(count));
		return ajaxResponse; 
	}
	@RequestMapping("/showCart")
	public String showCart() {
		return "cart";
	}
	
	@RequestMapping(value="/checkout", method=RequestMethod.POST)
	public String checkout(Order order, HttpServletRequest request) {
		ShoppingCart shoppingCart = getShoppingCart(request);
		
		String email = order.getCustomer().getEmail();
		Customer customer = customerService.findCustomerByEmail(email);
		if(customer != null){
			order.setCustomer(customer);
		}
		List<LineItem> items = shoppingCart.getItems();
		Set<OrderItem> orderItems = new HashSet<OrderItem>();
		for (LineItem lineItem : items) 
		{
			Product product = lineItem.getProduct();
			int quantity = lineItem.getQuantity();
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(product);
			orderItem.setQuantity(quantity);
			orderItems.add(orderItem);
		}
		order.setOrderItems(orderItems);
		Order orderCreated = orderService.createOrder(order);
		logger.info("Order created successfully. OrderId: "+orderCreated.getId());
		request.getSession().removeAttribute("ShoppingCart");
		return "redirect:/cartSubmission";
	}
	
	@RequestMapping("/cartSubmission")
	public String showCartSubmission() {
		return "cartSubmission";
	}
	
}
