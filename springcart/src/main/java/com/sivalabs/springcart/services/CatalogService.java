/**
 * 
 */
package com.sivalabs.springcart.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
		//return em.createQuery("select distinct c from Category c join fetch c.products", Category.class).getResultList();
	}

	public Category findCategory(Integer id) {
		TypedQuery<Category> query = em.createQuery("select distinct c from Category c join fetch c.products where c.id=?1", Category.class);
		query.setParameter(1, id);
		List<Category> categories = query.getResultList();
		if(!categories.isEmpty()){
			return categories.get(0);
		}
		return null;
		//return categoryRepository.findOne(id);
	}
	
	
}
