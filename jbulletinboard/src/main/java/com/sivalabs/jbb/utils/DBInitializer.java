package com.sivalabs.jbb.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

/**
 * @author Siva
 *
 */
@Component
public class DBInitializer extends ResourceDatabasePopulator
{
	private static final Logger logger = LoggerFactory.getLogger(DBInitializer.class);
	
	@Value("${initialize_database}")
	private String enabled = "false";
	
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
