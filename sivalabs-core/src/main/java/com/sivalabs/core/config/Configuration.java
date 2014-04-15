/**
 * 
 */
package com.sivalabs.core.config;

import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @author skatam
 *
 */
public class Configuration extends PropertiesConfiguration
{
	private Configuration()
	{
	}
	
	private Configuration(String configFileName) throws Exception
	{
		super(configFileName);
	}

	public static Configuration build(String configFileName)
	{
		Configuration configuration = null;
		try {
			configuration = new Configuration(configFileName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return configuration;
	}
}
