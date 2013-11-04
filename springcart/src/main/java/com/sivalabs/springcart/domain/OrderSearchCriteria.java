/**
 * 
 */
package com.sivalabs.springcart.domain;

import com.sivalabs.springcart.entities.Customer;
import com.sivalabs.springcart.entities.OrderStatus;

/**
 * @author Siva
 *
 */
public class OrderSearchCriteria 
{
	private Customer customer;
	private OrderStatus orderStatus;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
