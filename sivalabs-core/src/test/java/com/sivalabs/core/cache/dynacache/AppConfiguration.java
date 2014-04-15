/**
 * 
 */
package com.sivalabs.core.cache.dynacache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Siva
 *
 */
public class AppConfiguration
{
	private Map<String, Object> config = new HashMap<String, Object>();
	
	public void putConfigParameter(String paramName, Object paramValue)
	{
		config.put(paramName, paramValue);
	}
	
	public Object getConfigParamValue(String paramName)
	{
		return this.config.get(paramName);
	}
}
