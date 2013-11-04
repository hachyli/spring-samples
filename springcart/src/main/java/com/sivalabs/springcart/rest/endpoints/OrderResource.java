/**
 * 
 */
package com.sivalabs.springcart.rest.endpoints;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.springcart.entities.Order;
import com.sivalabs.springcart.exceptions.SpringCartException;
import com.sivalabs.springcart.rest.model.GenericResponse;
import com.sivalabs.springcart.services.CatalogService;
import com.sivalabs.springcart.services.CustomerService;
import com.sivalabs.springcart.services.OrderService;

/**
 * @author Siva
 *
 */
@Controller
@RequestMapping("/orders")
public class OrderResource 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired private CatalogService catalogService;
	@Autowired private OrderService orderService;
	@Autowired private CustomerService customerService;
	
	@ResponseBody
	@RequestMapping(value="/{id}", produces={APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public Order getOrder(@PathVariable("id") int orderId) 
	{
		Order order = null;
		order = orderService.findOrder(orderId);
		return order;
	}
	
	@ResponseBody
	@RequestMapping(value="/", method=RequestMethod.POST, 
					consumes={APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public GenericResponse createOrder(@RequestBody Order order) 
	{
		GenericResponse response = new GenericResponse();
		try {
			order = orderService.createOrder(order);
			//response.addData("OrderId", order.getId());
			response.setMessage("Order placed successfully. Order Id: "+order.getId());
		} catch (SpringCartException e) {
			logger.error(e.getMessage(), e);
			response.setSuccess(false);
			response.addErrorr(e.getMessage());
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, 
					produces={APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public GenericResponse cancelOrder(@PathVariable("id") int orderId) 
	{
		GenericResponse response = new GenericResponse();
		try {
			orderService.cancelOrder(new Order(orderId));
			//response.addData("OrderId", orderId);
			response.setMessage("Order ["+orderId+"] cancelled successfully");
		} catch (SpringCartException e) {
			logger.error(e.getMessage(), e);
			response.setSuccess(false);
			response.addErrorr(e.getMessage());
		}
		return response;
	}
	
	
	
}
