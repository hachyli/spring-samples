/**
 * 
 */
package com.sivalabs.core.rss;

import com.sun.syndication.feed.synd.SyndEntry;

/**
 * @author K. Siva Prasad Reddy
 *
 */
public interface FeedItemFormatter
{
	public String format(SyndEntry syndEntry);
}
