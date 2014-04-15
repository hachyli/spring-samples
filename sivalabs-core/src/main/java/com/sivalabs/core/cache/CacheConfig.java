/**
 * 
 */
package com.sivalabs.core.cache;

/**
 * @author siva
 *
 */
public enum CacheConfig 
{
	COUNTRIES_CACHE(CacheId.COUNTRIES_CACHE_ID, "COUNTRIES_CACHE",CountriesCache.class,3,true);
	
	private CacheId cacheId;
	private String cacheName;
	private Class<? extends Cache> cacheClass;
	private long ttl;
	private boolean preload;
	
	private CacheConfig(CacheId cacheId, String cacheName, 
			Class<? extends Cache> cacheClass,
			long ttl, boolean preload) 
	{
		this.cacheId = cacheId;
		this.cacheName = cacheName;
		this.cacheClass = cacheClass;
		this.ttl = ttl;
		this.preload = preload;
	}

	public static CacheConfig getCacheConfig(CacheId cacheId) 
	{
		CacheConfig[] cacheConfigs = CacheConfig.values();
		for (CacheConfig cacheConfig : cacheConfigs) {
			if(cacheId == cacheConfig.getCacheId()){
				return cacheConfig;
			}
		}
		return null;
	}
	public CacheId getCacheId() {
		return cacheId;
	}

	public String getCacheName() {
		return cacheName;
	}

	public Class<? extends Cache> getCacheClass() {
		return cacheClass;
	}

	public long getTtl() {
		return ttl;
	}

	public boolean isPreload() {
		return preload;
	}
	
}
