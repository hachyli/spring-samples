/**
 * 
 */
package com.sivalabs.springcart;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.springcart.entities.Category;
import com.sivalabs.springcart.services.CatalogService;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class CatalogServiceTest {

	@Autowired
	private CatalogService catalogService;
	
	@Test
	public void getCategories() {
		List<Category> categories = catalogService.findAllCategories();
		for (Category category : categories) {
			System.out.println(category);
		}
	}
}
