package com.sivalabs.securitymanager.web;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.securitymanager.domain.Privilege;
import com.sivalabs.securitymanager.service.AdminService;
import com.sivalabs.securitymanager.utils.JSONResponse;


@Controller
public class PrivilegeController
{
	static Logger logger = Logger.getLogger(PrivilegeController.class);
	
	private AdminService adminService;
	
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping("/createPrivilege")
	@ResponseBody
	public JSONResponse createPrivilege(Privilege privilege)
	{
		JSONResponse jsonResponse = new JSONResponse();
		Integer privilegeId = this.adminService.create(privilege);
		privilege.setPrivilegeId(privilegeId);
		jsonResponse.setSuccess(true);
		jsonResponse.setData(privilege);		
		return jsonResponse;
	}
	
	@RequestMapping("/getPrivilegeById")
	@ResponseBody
	public JSONResponse getPrivilegeById(@RequestParam(value="id")int id)
	{
		JSONResponse jsonResponse = new JSONResponse();
		Privilege privilege = this.adminService.getPrivilegeById(id);
		jsonResponse.setSuccess(true);
		jsonResponse.setData(privilege);
		
		return jsonResponse;
	}
	
	@RequestMapping("/getAllPrivileges")
	@ResponseBody
	public JSONResponse getAllPrivileges()
	{
		JSONResponse jsonResponse = new JSONResponse();
		Collection<Privilege> allPrivileges = this.adminService.getAllPrivileges();
		jsonResponse.setSuccess(true);
		jsonResponse.setData(allPrivileges);
		return jsonResponse;
	}
	
	@RequestMapping("/updatePrivilege")
	@ResponseBody
	public JSONResponse updatePrivilege(Privilege privilege)
	{
		JSONResponse jsonResponse = new JSONResponse();
		this.adminService.update(privilege);
		jsonResponse.setSuccess(true);
		jsonResponse.setData(privilege);		
		return jsonResponse;
	}
	
	@RequestMapping("/deletePrivilege")
	@ResponseBody
	public JSONResponse deletePrivilege(Privilege privilege)
	{
		JSONResponse jsonResponse = new JSONResponse();
		this.adminService.delete(privilege);
		jsonResponse.setSuccess(true);
		jsonResponse.setData(privilege);
		return jsonResponse;
	}
}
