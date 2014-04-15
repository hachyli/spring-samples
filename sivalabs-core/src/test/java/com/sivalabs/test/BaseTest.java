/**
 * 
 */
package com.sivalabs.test;

import org.junit.After;
import org.junit.Before;

/**
 * @author skatam
 *
 */
public class BaseTest
{
	@Before
	public void before()
	{
		System.out.println("Initialized.");
	}
	
	@After
	public void after()
	{
		System.out.println("Destroyed.");
	}
}
