/**
 * 
 */
package com.sivalabs.cache.sample;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sivalabs.core.cache.inmemory.AbstractCache;
import com.sivalabs.core.cache.inmemory.CacheConfigVO;

/**
 * @author Siva
 *
 */
public class ConfigurationCache extends AbstractCache<Map<String, String>>
{
	private static final ConfigurationCache CONFIGURATION_CACHE = new ConfigurationCache();
	
	private ConfigurationCache()
	{
		super();
	}
	
	@Override
	protected CacheConfigVO getCacheConfigVO()
	{
		return CacheConfigEnum.CONFIGURATION_CACHE.getCacheConfigVO();
	}
	
	@Override
	protected Map<String, String> getCacheData()
	{
		System.out.println("Loading Cache Data @ "+new Date());
		
		Map<String, String> configurationParams = new HashMap<String, String>();
		configurationParams.put("app.version", "1.0");
		configurationParams.put("loggingLevel", "DEBUG");
		configurationParams.put("App.Code", "SLU");
		
		return configurationParams;
	}
	
	public static String getConfigParamValue(String paramName)
	{
		return CONFIGURATION_CACHE.getCache().get(paramName);
	}

}
