/**
 * 
 */
package com.sivalabs.springcart.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.springcart.entities.Category;
import com.sivalabs.springcart.rest.model.CatalogResponse;
import com.sivalabs.springcart.services.CatalogService;

/**
 * @author Siva
 *
 */
@Controller
@RequestMapping("/catalog")
public class CatalogRestService {

	@Autowired
	private CatalogService catalogService;
	
	@ResponseBody
	@RequestMapping(value="/", produces={"application/json"})
	public CatalogResponse getCategories() 
	{
		
		List<Category> categories = catalogService.findAllCategories();
		CatalogResponse response = new CatalogResponse();
		response.setCategories(categories);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", produces={"application/json"})
	public Category getCategory(@PathVariable("id") int id) 
	{
		Category category = catalogService.findCategory(id);
		return category;
	}
}
