/**
 * 
 */
package com.sivalabs.core.rss;

import com.sun.syndication.feed.synd.SyndEntry;

/**
 * @author K. Siva Prasad Reddy
 *
 */
public class DefaultFeedItemFormatter implements FeedItemFormatter
{

	@Override
	public String format(SyndEntry syndEntry)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Title : "+syndEntry.getTitle());
		sb.append("\nDescription : "+syndEntry.getDescription().getValue());
		sb.append("\n URL : "+syndEntry.getUri());
		return sb.toString();
	}

}
