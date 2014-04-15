/**
 * 
 */
package com.sivalabs.securitymanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.securitymanager.domain.Role;


/**
 * @author siva
 *
 */
public interface RoleDAO extends JpaRepository<Role, Integer>
{

	
}
