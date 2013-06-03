package com.sivalabs.forum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.forum.entities.Category;
import com.sivalabs.forum.repositories.CategoryRepository;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@Service
@Transactional
public class CategoryService
{
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll()
	{
		return categoryRepository.findAll();
	}
	public Category findCategory(Long catId)
	{
		return categoryRepository.findOne(catId);
	}
	
	public Category create(Category category)
	{
		Category cat  = categoryRepository.findByName(category.getName());
		if(cat != null){
			throw new RuntimeException("Category with Name :["+category.getName()+"] already exist.");
		}
		category.setId(null);
		return categoryRepository.save(category);
	}
	
	public Category update(Category category)
	{
		if(findCategory(category.getId()) == null)
		{
			throw new RuntimeException("Category with id :["+category.getId()+"] doesn't exist.");
		}
		return categoryRepository.save(category);
	}
	
	public void delete(Long catId)
	{
		if(findCategory(catId) == null)
		{
			throw new RuntimeException("Category with id :["+catId+"] doesn't exist.");
		}
		categoryRepository.delete(catId);
	}
}
