/**
 * 
 */
package com.sivalabs.springcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sivalabs.springcart.entities.Customer;

/**
 * @author Siva
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("select c from Customer c where c.email=?1 and c.password=?2")
	Customer login(String email, String password);

	Customer findByEmail(String email);

}
