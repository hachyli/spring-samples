/**
 * 
 */
package com.sivalabs.springcart.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.springcart.domain.OrderSearchCriteria;
import com.sivalabs.springcart.entities.Order;
import com.sivalabs.springcart.entities.OrderStatus;
import com.sivalabs.springcart.exceptions.SpringCartException;
import com.sivalabs.springcart.repositories.OrderRepository;

/**
 * @author Siva
 *
 */
@Repository
@Service
@Transactional
public class OrderService 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired private OrderRepository orderRepository;

	public Order createOrder(Order order) {
		order.setId(0);
		order.setStatus(OrderStatus.NEW);
		try {
			return orderRepository.save(order);
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new SpringCartException(e.getMostSpecificCause().getMessage());
		}
	}

	public void cancelOrder(Order order) {
		updateOrderStatus(order, OrderStatus.CANCELLED);
	}

	public Order findOrder(int orderId) {
		return orderRepository.findOne(orderId);
	}
	
	public void updateOrderStatus(Order order, OrderStatus status) {
		Order o = findOrder(order.getId());
		if(o != null){
			o.setStatus(status);
		}
	}

	public List<Order> findOrders(OrderSearchCriteria searchCriteria) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Order> c = cb.createQuery(Order.class);
		Root<Order> order = c.from(Order.class);
		c = c.select(order);
		if(searchCriteria.getOrderStatus() != null)
		{
			c.where(cb.equal(order.get("status"), searchCriteria.getOrderStatus()));
		}
		if(searchCriteria.getCustomer() != null)
		{
			c.where(cb.equal(order.get("customer"), searchCriteria.getCustomer()));
		}
		TypedQuery<Order> q = em.createQuery(c);
		return q.getResultList();
	}
}
