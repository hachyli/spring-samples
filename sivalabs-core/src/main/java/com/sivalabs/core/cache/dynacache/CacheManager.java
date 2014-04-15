/**
 * 
 */
package com.sivalabs.core.cache.dynacache;

import java.util.List;

/**
 * @author Siva
 *
 */
public class CacheManager
{
	private CacheConfiguration cacheConfiguration;
	private CacheRegistry cacheRegistry = new CacheRegistry();
	
	public CacheManager(CacheConfiguration cacheConfiguration)
	{
		this.cacheConfiguration = cacheConfiguration;
		this.init();
	}
	
	/*************************Public API **********************************/
	public CacheVO getCache(String cacheId)
	{
		return this.cacheRegistry.getCache(cacheId);
	}
	public Object getCachedObject(String cacheId)
	{
		return this.cacheRegistry.getCache(cacheId).getCache();
	}
	public List<CacheVO> getAllCaches()
	{
		return this.cacheRegistry.getAllCaches();
	}
	
	public void invalidateCache(String cacheId)
	{
		System.out.println("Invalidating cache:"+cacheId);
		
		this.cacheRegistry.getCache(cacheId).invalidate();
	}
	
	public void invalidateAllCaches()
	{
		System.out.println("Invalidating all caches");
		
		List<CacheVO> caches = this.cacheRegistry.getAllCaches();
		for (CacheVO cacheVO : caches)
		{
			cacheVO.invalidate();
		}
	}
	
	public void refreshCache(String cacheId)
	{
		System.out.println("RefreshCache :"+cacheId);
		this.cacheRegistry.getCache(cacheId).loadCache();
	}
	
	public void refreshAllCaches()
	{
		System.out.println("Refreshing all caches");
		List<CacheVO> caches = this.cacheRegistry.getAllCaches();
		for (CacheVO cacheVO : caches)
		{
			cacheVO.loadCache();
		}
	}
	
	/************************ Internal Method  ****************************/
	private void init()
	{
		List<CacheConfigVO> cacheConfigVOs = cacheConfiguration.getCacheConfigVOs();
		for (CacheConfigVO cacheConfigVO : cacheConfigVOs)
		{
			this.initCache(cacheConfigVO);
		}
	}

	private void initCache(CacheConfigVO cacheConfigVO)
	{
		CacheVO cacheVO = new CacheVO(cacheConfigVO);
		this.cacheRegistry.putCache(cacheVO);
	}
	
}
