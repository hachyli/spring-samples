/**
 * 
 */
package com.sivalabs.springcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sivalabs.springcart.entities.Category;

/**
 * @author Siva
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
