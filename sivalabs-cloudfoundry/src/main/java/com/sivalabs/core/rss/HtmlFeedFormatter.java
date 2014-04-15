/**
 * 
 */
package com.sivalabs.core.rss;

import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;

/**
 * @author K. Siva Prasad Reddy
 *
 */
public class HtmlFeedFormatter implements FeedFormatter
{
	@SuppressWarnings("unchecked")
	@Override
	public String formatFeedContent(SyndFeed feed)
	{
		StringBuilder sb = new StringBuilder();
		List<SyndEntry> entries = feed.getEntries();
		for (SyndEntry syndEntry : entries) 
		{
			sb.append(this.getFeedItemFormatter().format(syndEntry));
			sb.append("<br/><br/>");
		}
		return sb.toString();
	}

	@Override
	public FeedItemFormatter getFeedItemFormatter()
	{
		return new HtmlFeedItemFormatter();
	}

}
