/**
 * 
 */
package com.sivalabs.jbb.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.jbb.entities.Category;
import com.sivalabs.jbb.entities.Forum;
import com.sivalabs.jbb.services.ForumService;

/**
 * @author Siva
 *
 */
@Controller
@RequestMapping(value="/categories", produces="application/json")
public class CategoryRestService {
	
	@Autowired
	private ForumService  forumService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	@ResponseBody
	public List<Category> getCategories() 
	{
		return forumService.findAllCategories();
	}
	
	@RequestMapping(value="/{categoryId}", method=RequestMethod.GET)
	@ResponseBody
	public Category getCategory(@PathVariable("categoryId") Integer categoryId) 
	{
		return forumService.findCategoryById(categoryId);
	}
	
	@RequestMapping(value="/{categoryId}/forums", method=RequestMethod.GET)
	@ResponseBody
	public List<Forum> getCategoryForums(@PathVariable("categoryId") Integer categoryId) 
	{
		return forumService.findForumsByCategory(categoryId);
	}
}
