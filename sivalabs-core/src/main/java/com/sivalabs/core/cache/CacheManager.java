/**
 * 
 */
package com.sivalabs.core.cache;

import java.util.List;

/**
 * @author siva
 *
 */
public interface CacheManager 
{
	//public void loadCaches();
	public void loadCache(CacheId cacheId);
	public List<Cache> getCaches();
	public Cache getCache(CacheId cacheId);
	public void reloadCaches();
	public void reloadCache(CacheId cacheId);
	public void clearCaches();
	public void clearCache(CacheId cacheId);
	
	
	
}
