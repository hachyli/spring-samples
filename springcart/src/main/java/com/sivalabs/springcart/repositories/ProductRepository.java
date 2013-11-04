/**
 * 
 */
package com.sivalabs.springcart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sivalabs.springcart.entities.Product;

/**
 * @author Siva
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findByCategoryId(Integer catId);

}
