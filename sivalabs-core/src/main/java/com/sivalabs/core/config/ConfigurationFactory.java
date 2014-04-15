/**
 * 
 */
package com.sivalabs.core.config;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

/**
 * @author skatam
 *
 */
public class ConfigurationFactory
{
	public static PropertiesConfiguration getPropertiesConfiguration(String fileName)
	{
		PropertiesConfiguration configuration = null;
		try {
			configuration = new PropertiesConfiguration(fileName);
		} catch (ConfigurationException e) {
			throw new RuntimeException(e);
		}
		return configuration;
	}
	
	public static XMLConfiguration  getXMLConfiguration (String fileName)
	{
		XMLConfiguration configuration = null;
		try {
			configuration = new XMLConfiguration (fileName);
		} catch (ConfigurationException e) {
			throw new RuntimeException(e);
		}
		return configuration;
	}
}
