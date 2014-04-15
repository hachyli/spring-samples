package com.sivalabs.securitymanager.web;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.securitymanager.domain.Role;
import com.sivalabs.securitymanager.service.AdminService;
import com.sivalabs.securitymanager.utils.JSONResponse;


@Controller
public class RoleController
{
	static Logger logger = Logger.getLogger(RoleController.class);
	
	private AdminService adminService;
	
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
		
	@RequestMapping("/createRole")
	@ResponseBody
	public JSONResponse createRole(Role role)
	{
		JSONResponse jsonResponse = new JSONResponse();
		Integer roleId = this.adminService.create(role);
		role.setRoleId(roleId);
		jsonResponse.setSuccess(true);
		jsonResponse.setData(role);		
		return jsonResponse;
	}
	
	@RequestMapping("/getRoleById")
	@ResponseBody
	public JSONResponse getRoleById(@RequestParam(value="id")int id)
	{
		JSONResponse jsonResponse = new JSONResponse();
		Role role = this.adminService.getRoleById(id);
		jsonResponse.setSuccess(true);
		jsonResponse.setData(role);
		
		return jsonResponse;
	}
	
	@RequestMapping("/getAllRoles")
	@ResponseBody
	public JSONResponse getAllRoles()
	{
		JSONResponse jsonResponse = new JSONResponse();
		Collection<Role> allRoles = this.adminService.getAllRoles();
		jsonResponse.setSuccess(true);
		jsonResponse.setData(allRoles);		
		return jsonResponse;
	}
	
	@RequestMapping("/updateRole")
	@ResponseBody
	public JSONResponse updateRole(Role role)
	{
		JSONResponse jsonResponse = new JSONResponse();
		this.adminService.update(role);
		jsonResponse.setSuccess(true);
		jsonResponse.setData(role);		
		return jsonResponse;
	}
	
	@RequestMapping("/deleteRole")
	@ResponseBody
	public JSONResponse deleteRole(Role role)
	{
		JSONResponse jsonResponse = new JSONResponse();
		this.adminService.delete(role);
		jsonResponse.setSuccess(true);
		jsonResponse.setData(role);
		return jsonResponse;
	}
}
