/**
 * 
 */
package com.sivalabs.securitymanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.securitymanager.domain.Application;


/**
 * @author siva
 *
 */
public interface ApplicationDAO extends JpaRepository<Application, Integer>
{

	
}
