/**
 * 
 */
package com.sivalabs.common.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author skatam
 *
 */

@Controller
public class HomeController 
{
	@RequestMapping("/home")
	public String home() 
	{
		return "home";
	}
}
