/**
 * 
 */
package com.sivalabs.core.config;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sivalabs.core.config.Configuration;
import com.sivalabs.test.BaseTest;

/**
 * @author skatam
 *
 */
public class ConfigurationTest extends BaseTest
{
	private Configuration configuration;
	
	@Before
	public void before()
	{
		this.configuration = Configuration.build("application.properties");
		System.out.println("Initialized.");
	}
	
	@After
	public void after()
	{
		this.configuration = null;
		System.out.println("Destroyed.");
	}
	
	@Test
	public void testGetStringProperty()
	{
		System.out.println(configuration.getProperty("jdbc.url"));
	}
	
	@SuppressWarnings({"unchecked" })
	@Test
	public void testGetListProperty()
	{
		List<String> envs = configuration.getList("Environments");
		Assert.assertNotNull(envs);
		for (String string : envs) {
			System.out.println("["+string+"]");
		}
	}
}
