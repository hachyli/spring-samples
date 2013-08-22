/**
 * 
 */
package com.sivalabs.springcart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.springcart.entities.Category;
import com.sivalabs.springcart.repositories.CategoryRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class CatalogService 
{
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}

	public Category findCategory(Integer id) {
		return categoryRepository.findOne(id);
	}
	
	
}
