/**
 * 
 */
package com.sivalabs.springcart.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.springcart.entities.Category;
import com.sivalabs.springcart.entities.Product;
import com.sivalabs.springcart.repositories.CategoryRepository;
import com.sivalabs.springcart.repositories.ProductRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class CatalogService 
{
	@Autowired private CategoryRepository categoryRepository;
	@Autowired private ProductRepository productRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}

	public List<Category> findAllCategoriesWithProducts() {
		return em.createQuery("select distinct c from Category c join fetch c.products", Category.class).getResultList();
	}
	
	public Category findCategory(Integer id) {
		return categoryRepository.findOne(id);
	}

	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public List<Product> findProductsByCategory(Integer catId) {
		return productRepository.findByCategoryId(catId);
	}

	public Product findProduct(Integer productId) {
		return productRepository.findOne(productId);
	}

	public Category createCategory(Category c) {
		c.setId(0);
		return categoryRepository.saveAndFlush(c);
	}

	public Product createProduct(Product p) {
		p.setId(0);
		return productRepository.saveAndFlush(p);
	}
	
	
}
