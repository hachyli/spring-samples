/**
 * 
 */
package com.sivalabs.springcart.rest.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.http.MediaType.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.springcart.entities.Category;
import com.sivalabs.springcart.rest.model.CatalogResponse;
import com.sivalabs.springcart.services.CatalogService;
import com.sivalabs.springcart.utils.BeanCopyUtils;

/**
 * @author Siva
 *
 */
@Controller
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired
	private CatalogService catalogService;
	
	@ResponseBody
	@RequestMapping(value="/", produces={APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public CatalogResponse getCategories() 
	{
		List<Category> categoriesPojos = new ArrayList<Category>();
		List<Category> categories = catalogService.findAllCategoriesWithProducts();
		for (Category category : categories) {
			categoriesPojos.add(BeanCopyUtils.getCopy(category));
		}
		CatalogResponse response = new CatalogResponse();
		response.setCategories(categoriesPojos);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", produces={APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public Category getCategory(@PathVariable("id") int id) 
	{
		Category category = catalogService.findCategory(id);
		return BeanCopyUtils.getCopy(category);
	}
}
