/**
 * 
 */
package com.sivalabs.securitymanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.securitymanager.domain.Privilege;


/**
 * @author siva
 *
 */
public interface PrivilegeDAO extends JpaRepository<Privilege, Integer>
{

	
}
