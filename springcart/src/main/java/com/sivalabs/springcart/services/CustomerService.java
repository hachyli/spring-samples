/**
 * 
 */
package com.sivalabs.springcart.services;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.springcart.entities.Customer;
import com.sivalabs.springcart.repositories.CustomerRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class CustomerService 
{
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Customer findCustomer(Integer custId) 
	{
		return customerRepository.findOne(custId);
	}
	
	public Customer login(String email, String password) 
	{
		return customerRepository.login(email, password);
	}
	
	public void updateCustomer(Customer customer) 
	{
		Customer c = findCustomer(customer.getId());
		if(c != null)
		{
			customer.setUpdatedOn(new Date());
			em.merge(customer);
		}
	}

	public Customer createCustomer(Customer customer) {
		customer.setId(0);
		return customerRepository.save(customer);
	}

	public Customer findCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
}
