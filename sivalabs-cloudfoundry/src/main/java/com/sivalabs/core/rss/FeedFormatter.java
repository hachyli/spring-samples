/**
 * 
 */
package com.sivalabs.core.rss;

import com.sun.syndication.feed.synd.SyndFeed;

/**
 * @author K. Siva Prasad Reddy
 *
 */
public interface FeedFormatter
{
	public String formatFeedContent(SyndFeed feed);
	public FeedItemFormatter getFeedItemFormatter();
}
