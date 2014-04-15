/**
 * 
 */
package com.sivalabs.core.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author siva
 *
 */
public class CacheRegistry 
{
	private Map<CacheId, Cache> registry = new HashMap<CacheId, Cache>();
	
	public void put(CacheId cacheId, Cache cache) {
		this.registry.put(cacheId, cache);
	}
	public Cache get(CacheId cacheId) {
		return this.registry.get(cacheId);
	}
	public ArrayList<Cache> getCaches(){
		return new ArrayList<Cache>(this.registry.values());
	}
	public void clear() {
		this.registry.clear();		
	}
	public void clear(CacheId cacheId) {
		this.registry.remove(cacheId);		
	}
}
