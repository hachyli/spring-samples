
package com.sivalabs.springcart;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.springcart.domain.OrderSearchCriteria;
import com.sivalabs.springcart.entities.Address;
import com.sivalabs.springcart.entities.Customer;
import com.sivalabs.springcart.entities.Order;
import com.sivalabs.springcart.entities.OrderItem;
import com.sivalabs.springcart.entities.OrderStatus;
import com.sivalabs.springcart.entities.Payment;
import com.sivalabs.springcart.services.CatalogService;
import com.sivalabs.springcart.services.OrderService;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class OrderServiceTest {

	@Autowired private CatalogService catalogService;
	@Autowired private OrderService orderService;
	
	//@Test
	public void createOrder() {
		System.out.println("============================");
		Customer customer = new Customer();
		customer.setFirstName("Siva");
		customer.setLastName("K");
		customer.setEmail("siva@gmail.com");
		customer.setPassword("siva");
		customer.setPhone("90000510456");
		
		Address billingAddress = new Address();
		billingAddress.setContactName("K. Siva Prasad Reddy");
		billingAddress.setAddrLine1("KP");
		billingAddress.setAddrLine2("BalajiNagar");
		billingAddress.setCity("Hyd");
		billingAddress.setState("AP");
		billingAddress.setCountry("India");
		billingAddress.setZipCode("500072");
		
		Address shippingAddress = new Address();
		shippingAddress.setContactName("K. Siva Prasad Reddy");
		shippingAddress.setAddrLine1("KP");
		shippingAddress.setAddrLine2("BalajiNagar");
		shippingAddress.setCity("Hyd");
		shippingAddress.setState("AP");
		shippingAddress.setCountry("India");
		shippingAddress.setZipCode("500072");
		
		Set<OrderItem> orderItems = new HashSet<OrderItem>();
		OrderItem item1 = new OrderItem();
		item1.setProduct(catalogService.findProduct(1));
		item1.setQuantity(1);
		
		OrderItem item2 = new OrderItem();
		item2.setProduct(catalogService.findProduct(2));
		item2.setQuantity(2);
		
		orderItems.add(item1);
		orderItems.add(item2);
		
		Payment payment = new Payment();
		payment.setCreditCardNumber("123-456-789");
		payment.setCvv("123");
		payment.setExpiryDate(new Date());
		
		Order order = new Order();
		order.setCustomer(customer);
		order.setBillingAddress(billingAddress);
		order.setShippingAddress(shippingAddress);
		order.setOrderItems(orderItems);
		order.setPayment(payment );
		order.setStatus(OrderStatus.VALIDATED);
		
		Order createdOrder = orderService.createOrder(order);
		assertNotNull(createdOrder);
	}
	
	@Test
	public void cancelOrder()
	{
		Order o = orderService.findOrder(1);
		assertNotNull(o);
		orderService.cancelOrder(o);
		o = orderService.findOrder(1);
		assertEquals(OrderStatus.CANCELLED, o.getStatus());
	}
	
	@Test
	public void updateOrderStatus()
	{
		Order o = orderService.findOrder(1);
		assertNotNull(o);
		orderService.updateOrderStatus(o, OrderStatus.ERROR);
		o = orderService.findOrder(1);
		assertEquals(OrderStatus.ERROR, o.getStatus());
	}
	
	@Test
	public void findOrder()
	{
		Order o = orderService.findOrder(1);
		assertNotNull(o);
	}
	
		
	@Test
	public void findOrders()
	{
		System.out.println("===============findOrders========================");
		Integer custId = 5;
		OrderStatus orderStatus = OrderStatus.VALIDATED;
		
		OrderSearchCriteria searchCriteria = new OrderSearchCriteria();
		searchCriteria.setCustomer(new Customer(custId));
		searchCriteria.setOrderStatus(orderStatus);
		
		List<Order> orders = orderService.findOrders(searchCriteria);
		assertNotNull(orders);
		System.err.println(orders);
		for (Order order : orders) {
			System.err.println(order);
		}
	}
}
