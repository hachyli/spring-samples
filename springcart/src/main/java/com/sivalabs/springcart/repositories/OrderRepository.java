/**
 * 
 */
package com.sivalabs.springcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sivalabs.springcart.entities.Order;

/**
 * @author Siva
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
