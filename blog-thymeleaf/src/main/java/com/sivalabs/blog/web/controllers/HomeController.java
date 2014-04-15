/**
 * 
 */
package com.sivalabs.blog.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sivalabs.blog.services.UserService;

/**
 * @author Siva
 *
 */
@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/","/welcome"})
	public String welcome(Model model) {
		model.addAttribute("users", userService.findAllUsers());
		return "tiles/welcome";
	}

}
