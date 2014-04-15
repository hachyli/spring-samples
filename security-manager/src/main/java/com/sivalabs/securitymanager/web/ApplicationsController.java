/**
 * This software is developed by author of http://sivalabs.blogspot.com.
 * This is a freeware. You can use it, change it, redistribute it.
 */
package com.sivalabs.securitymanager.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.securitymanager.domain.Application;
import com.sivalabs.securitymanager.service.AdminService;
import com.sivalabs.securitymanager.utils.JSONResponse;

/**
 * @author K. Siva Prasad Reddy
 * Date  : Aug 11, 2011
 *
 */
@Controller
public class ApplicationsController
{
	
	@Autowired private AdminService adminService;
	
	@RequestMapping("/listApplications")
	@ResponseBody
	public JSONResponse listApplications()
	{
		Collection<Application> applications = this.adminService.getAllApplications();
		return new JSONResponse(applications);
	}
}
