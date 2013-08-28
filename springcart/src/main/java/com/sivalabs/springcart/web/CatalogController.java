/**
 * 
 */
package com.sivalabs.springcart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sivalabs.springcart.services.CatalogService;
import com.sivalabs.springcart.services.CustomerService;

/**
 * @author Siva
 *
 */
@Controller
public class CatalogController 
{
	private static Logger logger = LoggerFactory.getLogger(CatalogController.class);
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CatalogService catalogService;
	
	
	@RequestMapping(value={"/","/welcome"}, method=RequestMethod.GET)
	public String welcome(Model model) {
		return "redirect:home";
	}
	
	@RequestMapping(value={"/home"}, method=RequestMethod.GET)
	public String showHome(Model model) {
		logger.debug("Home");
		model.addAttribute("CATEGORIES_KEY", catalogService.findAllCategories());
		return "home";
	}

	
}
