/**
 * 
 */
package com.sivalabs.securitymanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Siva
 *
 */
@Controller
public class WelcomeController 
{
	
	@RequestMapping(value={"/","/index","/welcome","/home"})
	public String welcome(Model model) 
	{
		return "welcome";
	}
	
	@RequestMapping(value="/page")
	public String welcome(@RequestParam(value="view") String viewName) 
	{
		return viewName;
	}
}
