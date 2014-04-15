/**
 * 
 */
package com.sivalabs.securitymanager.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.securitymanager.dao.ApplicationDAO;
import com.sivalabs.securitymanager.dao.PrivilegeDAO;
import com.sivalabs.securitymanager.dao.RoleDAO;
import com.sivalabs.securitymanager.dao.UserDAO;
import com.sivalabs.securitymanager.domain.Application;
import com.sivalabs.securitymanager.domain.Privilege;
import com.sivalabs.securitymanager.domain.Role;
import com.sivalabs.securitymanager.domain.User;

/**
 * @author skatam
 *
 */
@Service
@Transactional
public class AdminService
{
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private PrivilegeDAO privilegeDAO;
	private ApplicationDAO applicationDAO;
	
	
	@Autowired
	public void setApplicationDAO(ApplicationDAO applicationDAO) {
		this.applicationDAO = applicationDAO;
	}
	
	@Autowired
	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	@Autowired
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	@Autowired
	public void setPrivilegeDAO(PrivilegeDAO privilegeDAO) {
		this.privilegeDAO = privilegeDAO;
	}
	
	/******************************************************/
	public Integer create(User obj)
	{
		return this.userDAO.save(obj).getUserId();
	}

	public User getUserById(Integer id)
	{
		return this.userDAO.findOne(id);
	}

	public Collection<User> getAllUsers()
	{
		return this.userDAO.findAll();
	}

	public void update(User obj)
	{
		this.userDAO.save(obj);
	}

	public void delete(User obj)
	{
		this.userDAO.delete(obj);
	}

	public void deleteById(Integer id)
	{
		this.userDAO.delete(id);
	}

	public User login(String userName, String password)
	{
		return this.userDAO.login(userName, password);
	}
	
	/******************************************************/
	public List<Application> getAllApplications() 
	{
		return this.applicationDAO.findAll();
	}
	
	public Application getApplication(Integer appId) {
		return this.applicationDAO.findOne(appId);
	}
	
	public Integer create(Application application) {
		return this.applicationDAO.save(application).getAppId();
	}
	
	public void update(Application application) {
		this.applicationDAO.save(application);
	}
	
	public void delete(Integer appId) {
		this.applicationDAO.delete(appId);
	}
	/******************************************************/
	public Integer create(Role obj) {
		return this.roleDAO.save(obj).getRoleId();
	}
	public void update(Role obj) {
		this.roleDAO.save(obj);		
	}
	public void delete(Role obj) {
		this.roleDAO.delete(obj);		
	}
	public Role getRoleById(Integer id)
	{
		return this.roleDAO.findOne(id);
	}

	public Collection<Role> getAllRoles()
	{
		return this.roleDAO.findAll();
	}
	
	/******************************************************/
	public Integer create(Privilege obj) {
		return this.privilegeDAO.save(obj).getPrivilegeId();
	}
	public void update(Privilege obj) {
		this.privilegeDAO.save(obj);
	}
	public void delete(Privilege obj) {
		this.privilegeDAO.delete(obj);	
	}
	public Privilege getPrivilegeById(Integer id)
	{
		return this.privilegeDAO.findOne(id);
	}

	public Collection<Privilege> getAllPrivileges()
	{
		return this.privilegeDAO.findAll();
	}

}
