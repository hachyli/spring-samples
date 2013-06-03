/**
 * 
 */
package com.sivalabs.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.forum.entities.ConfigParameter;

/**
 * @author Siva
 *
 */
public interface ConfigParamRepository extends JpaRepository<ConfigParameter, Long>
{

}
