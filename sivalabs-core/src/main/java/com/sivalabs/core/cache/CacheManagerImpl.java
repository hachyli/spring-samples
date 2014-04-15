/**
 * 
 */
package com.sivalabs.core.cache;

import java.util.ArrayList;

/**
 * @author siva
 *
 */
public class CacheManagerImpl implements CacheManager 
{
	//private CacheConfig cacheConfig = null;
	private CacheRegistry cacheRegistry = null;
	
	public CacheManagerImpl() {
		//this.cacheConfig = cacheConfig;
		//System.out.println(this.cacheConfig);
		this.cacheRegistry = new CacheRegistry();
		this.loadCaches();
	}
	
	@Override
	public void loadCache(CacheId cacheId) 
	{
		CacheConfig cacheConfig = CacheConfig.getCacheConfig(cacheId);
		if(cacheConfig == null)
		{
			throw new RuntimeException("Invalid CacheId :["+cacheId+"]");
		}
		this.loadCache(cacheConfig);
	}
	
	@Override
	public ArrayList<Cache> getCaches() {
		return this.cacheRegistry.getCaches();
	}
	
	@Override
	public Cache getCache(CacheId cacheId) {
		if(this.cacheNeedsToBuild(cacheId)){
			this.loadCache(cacheId);
		}
		Cache cache = this.cacheRegistry.get(cacheId);
		return cache;
	}
	
	@Override
	public void reloadCaches() 
	{
		this.clearCaches();
		this.loadCaches();
	}
	
	@Override
	public void reloadCache(CacheId cacheId) {
		this.clearCache(cacheId);
		this.loadCache(cacheId);
	}
	
	@Override
	public void clearCaches() {
		this.cacheRegistry.clear();
	}

	@Override
	public void clearCache(CacheId cacheId) {
		this.cacheRegistry.clear(cacheId);
	}
	
	private void loadCaches()
	{
		CacheConfig[] cacheConfigs = CacheConfig.values();
		for (CacheConfig cacheConfig : cacheConfigs) 
		{
			this.loadCache(cacheConfig);
		}
	}
	
	private void loadCache(CacheConfig cacheConfig) 
	{
		Class<? extends Cache> cacheClass = cacheConfig.getCacheClass();
		Cache cache = null;
		try {
			cache = cacheClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getCause().toString());
		}
		cache.setCacheId(cacheConfig.getCacheId());
		cache.setCacheName(cacheConfig.getCacheName());
		cache.setTtl(cacheConfig.getTtl());
		cache.setPreload(cacheConfig.isPreload());
		if(cacheConfig.isPreload())
		{
			cache.load();
		}
		this.cacheRegistry.put(cache.getCacheId(), cache);		
	}
	
	private boolean cacheNeedsToBuild(CacheId cacheId) 
	{
		//check whether it is in registry or time expired
		Cache cache = this.cacheRegistry.get(cacheId);
		return (cache == null || cache.isExpired());
	}


}
