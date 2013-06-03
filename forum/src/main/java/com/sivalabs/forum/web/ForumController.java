package com.sivalabs.forum.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sivalabs.forum.entities.Category;
import com.sivalabs.forum.services.CategoryService;
import com.sivalabs.forum.services.ForumService;

/**
 * @author K. Siva Prasad Reddy
 * Date : 02-Jun-2013
 */
@Controller
public class ForumController
{
	@Autowired private CategoryService categoryService;
	@Autowired private ForumService forumService;
	
	@RequestMapping(value={"/","/forums"})
	public String home(Model model) 
	{
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "home";
	}
}
