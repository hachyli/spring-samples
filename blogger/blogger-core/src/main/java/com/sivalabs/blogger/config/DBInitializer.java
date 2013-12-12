/**
 * 
 */
package com.sivalabs.blogger.config;

import java.io.Reader;
import java.sql.Connection;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Siva
 * 
 */
@Component
public class DBInitializer
{
	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	public void init()
	{
		try {
			initDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void initDatabase()
	{
		logger.info("Executing blogger.sql script...");
		Connection connection = null;
		Reader reader = null;
		try {
			connection = dataSource.getConnection();
			ScriptRunner scriptRunner = new ScriptRunner(connection);
			reader = Resources.getResourceAsReader("sql/blogger.sql");
			scriptRunner.runScript(reader);
			logger.info("blogger.sql executed successfully");
			connection.commit();
			reader.close();
			scriptRunner.closeConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
