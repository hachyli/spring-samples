/**
 * 
 */
package com.sivalabs.usermgmt.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

/**
 * @author Siva
 *
 */

//@Component("DBInitializer")
public class DBInitializer extends ResourceDatabasePopulator
{
	private static final Logger logger = LoggerFactory.getLogger(DBInitializer.class);
	
	@Value("${init_database}")
	private String enabled = "false";
	
	@PostConstruct
	public void init() {
		addScript(new ClassPathResource("sql/usermgmt.sql"));
	}
	
	@Override
	public void populate(Connection connection) throws SQLException
	{
		if(Boolean.valueOf(enabled))
		{
			logger.info("Executing DBInitializer script.");
			super.populate(connection);
		}
		else
		{
			logger.info("DBInitializer is disabled.");
		}
	}

	
}
