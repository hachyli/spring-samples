package com.sivalabs.forum.services;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.forum.config.AppConfig;
import com.sivalabs.forum.entities.Category;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class CategoryServiceTest
{
	@Autowired
	private CategoryService categoryService;

	@Test
	public void findAll()
	{
		List<Category> categories = categoryService.findAll();
		assertNotNull(categories);
	}

	@Test
	public void findCategory()
	{
		Long catId = 1L;
		Category category = categoryService.findCategory(catId);
		assertNotNull(category);
	}

	@Test
	public void create()
	{
		Category category = new Category(null,"Test Category","Test Category Description",4);
		Category newCategory = categoryService.create(category);
		assertNotNull(newCategory);
	}

	@Test
	public void update()
	{
		Category category = categoryService.findCategory(3L);
		category.setUpdatedOn(new Date());
		categoryService.update(category);
	}

	@Test
	public void delete()
	{
		Long catId = 4L;
		categoryService.delete(catId);
		Category category = categoryService.findCategory(4L);
		assertNull(category);
	}
	
	
}
