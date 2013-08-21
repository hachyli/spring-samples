package com.sivalabs.springcore;

import java.util.Properties;

/**
 * @author Siva
 *
 */
public class DataSourceFactory
{
	Properties properties;
	DataSourceFactory(Properties properties)
	{
		this.properties = properties;
	}
	
	public DataSource getMySQLDataSource()
	{
		System.out.println("------->"+properties);
		DataSource dataSource = new DataSource();
		dataSource.setDsName("mySQL");
		return dataSource;
	}

	public DataSource getOracleDataSource()
	{
		DataSource dataSource = new DataSource();
		dataSource.setDsName("Oracle");
		return dataSource;
	}
}
