/**
 * 
 */
package com.sivalabs.core.cache.dynacache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Siva
 *
 */
class CacheRegistry
{
	private Map<String, CacheVO> CACHE_MAP = new ConcurrentHashMap<String, CacheVO>();
	
	public void putCache(CacheVO cacheVO)
	{
		CACHE_MAP.put(cacheVO.getCacheId(), cacheVO);
	}
	
	public CacheVO getCache(String cacheId)
	{
		return CACHE_MAP.get(cacheId);
	}
	
	public List<CacheVO> getAllCaches()
	{
		return new ArrayList<CacheVO>(CACHE_MAP.values());
	}
	public int getCacheCount()
	{
		return CACHE_MAP.size();
	}
}
