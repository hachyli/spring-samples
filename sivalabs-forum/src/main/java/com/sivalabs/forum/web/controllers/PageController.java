/**
 * 
 */
package com.sivalabs.forum.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author skatam
 *
 */
@Controller
public class PageController
{
	@RequestMapping("/page")
	public ModelAndView showPage(@RequestParam("view") String view)
			throws ServletException, IOException 
	{
		return new ModelAndView(view);
	}
	
}
