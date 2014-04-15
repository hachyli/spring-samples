package com.sivalabs.core.cache;

import com.sivalabs.cache.sample.ConfigurationCache;

public class CacheTestClient
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(ConfigurationCache.getConfigParamValue("app.version"));
		//sleep(8);
		System.out.println(ConfigurationCache.getConfigParamValue("App.Code"));
		//sleep(5);
		System.out.println(ConfigurationCache.getConfigParamValue("App.Code"));
	}
	public static void sleep(long seconds){
		try
		{
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
