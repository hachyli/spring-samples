/**
 * 
 */
package com.sivalabs.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sivalabs.core.cache.CacheTest;
import com.sivalabs.core.config.ConfigurationTest;
import com.sivalabs.core.spring.SpringTest;

/**
 * @author skatam
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( 
		{ 
			ConfigurationTest.class,
			CacheTest.class,
			SpringTest.class
			
		})
public class AllTests 
{
	
}
