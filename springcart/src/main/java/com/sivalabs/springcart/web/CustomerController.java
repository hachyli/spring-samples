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

import com.sivalabs.springcart.services.CustomerService;

/**
 * @author Siva
 *
 */
@Controller
public class CustomerController 
{
	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/login/form")
	public String login(Model model) {
		/*User user = new User();
		user.setUserName("admin");
		model.addAttribute("user", user);*/
		return "login";
	}
	
	
}
