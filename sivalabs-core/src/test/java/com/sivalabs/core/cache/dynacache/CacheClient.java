/**
 * 
 */
package com.sivalabs.core.cache.dynacache;

import com.sivalabs.core.cache.dynacache.CacheConfigVO;
import com.sivalabs.core.cache.dynacache.CacheConfiguration;
import com.sivalabs.core.cache.dynacache.CacheManager;


/**
 * @author Siva
 *
 */
public class CacheClient
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		CacheConfiguration cacheConfiguration = new CacheConfiguration();
		cacheConfiguration.setCacheGroupName("Test_Configuration");
		cacheConfiguration.setDefaultCacheRefreshInterval(30*1000);
		CacheConfigVO cacheConfigVO=new CacheConfigVO(
										"AppConfiguration", 
										"Application Configuration", 
										"com.ftd.osp.utilities.sample.AppConfigCacheLoader", 
										60*1000, 
										true);
		cacheConfiguration.addCacheConfigVO(cacheConfigVO);
		CacheManager cacheManager = new CacheManager(cacheConfiguration);
		AppConfiguration appConfiguration = (AppConfiguration) cacheManager.getCachedObject("AppConfiguration");
		System.out.println(appConfiguration.getConfigParamValue("author"));
		sleep(120*1000);
		cacheManager.invalidateCache("AppConfiguration");
		appConfiguration = (AppConfiguration) cacheManager.getCachedObject("AppConfiguration");
		sleep(13000);
		cacheManager.refreshCache("AppConfiguration");
	}
	
	static void sleep(long millis)
	{
		try
		{
			Thread.sleep(millis);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
