package com.sivalabs.securitymanager.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.securitymanager.domain.User;
import com.sivalabs.securitymanager.service.AdminService;
import com.sivalabs.securitymanager.utils.JSONResponse;


@Controller
public class UserController
{
	private static Logger logger = Logger.getLogger(UserController.class);
	
	private AdminService adminService;
	
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public JSONResponse doLogin(@ModelAttribute("login") User loginBean,
							HttpServletRequest request, 
							HttpServletResponse response) throws Exception 
				
	{
		JSONResponse jsonResponse = new JSONResponse();
		
		String userName = loginBean.getUsername();
		String password = loginBean.getPassword();
		//User user = UsersTable.login(userName, password);
		User user = this.adminService.login(userName, password);
		
		if(user != null) {
			logger.info("User authenticated successfully");
			request.getSession().setAttribute("LOGGEDIN_USER", user);
			jsonResponse.setSuccess(true);
		} 
		else {
			logger.error("User authentication failed");
			jsonResponse.setSuccess(false);
			jsonResponse.addFieldError("password", "Invalid Username and Password");
			jsonResponse.setErrorMsg("For now only Admin can login !!!!");
		}
		return jsonResponse;
	}
	
	@RequestMapping("/createUser")
	@ResponseBody
	public JSONResponse createUser(User user)
	{
		JSONResponse jsonResponse = new JSONResponse();
		Integer userId = this.adminService.create(user);
		user.setUserId(userId);
		jsonResponse.setSuccess(true);
		jsonResponse.setData(user);		
		return jsonResponse;
	}
	
	@RequestMapping("/getUserById")
	@ResponseBody
	public JSONResponse getUserById(@RequestParam(value="userId")int id)
	{
		JSONResponse jsonResponse = new JSONResponse();
		User user = this.adminService.getUserById(id);
		jsonResponse.setSuccess(true);
		jsonResponse.setData(user);
		
		return jsonResponse;
	}
	
	@RequestMapping("/getAllUsers")
	@ResponseBody
	public JSONResponse getAllUsers()
	{
		JSONResponse jsonResponse = new JSONResponse();
		Collection<User> allUsers = this.adminService.getAllUsers();
		jsonResponse.setSuccess(true);
		jsonResponse.setData(allUsers);		
		return jsonResponse;
	}
	
	@RequestMapping("/searchUsers")
	@ResponseBody
	public JSONResponse searchUsers(@RequestParam("searchName") String searchName)
	{
		System.out.println("SearchName ="+searchName);
		JSONResponse jsonResponse = new JSONResponse();
		Collection<User> allUsers = this.adminService.getAllUsers();
		jsonResponse.setSuccess(true);
		jsonResponse.setData(allUsers);		
		return jsonResponse;
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public JSONResponse updateUser(User user)
	{
		JSONResponse jsonResponse = new JSONResponse();
		this.adminService.update(user);
		jsonResponse.setSuccess(true);
		jsonResponse.setData(user);		
		return jsonResponse;
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public JSONResponse deleteUser(User user)
	{
		JSONResponse jsonResponse = new JSONResponse();
		this.adminService.delete(user);
		jsonResponse.setSuccess(true);
		jsonResponse.setData(user);
		return jsonResponse;
	}
}
