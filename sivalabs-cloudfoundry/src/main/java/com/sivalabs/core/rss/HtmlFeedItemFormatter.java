/**
 * 
 */
package com.sivalabs.core.rss;

import com.sun.syndication.feed.synd.SyndEntry;

/**
 * @author K. Siva Prasad Reddy
 *
 */
public class HtmlFeedItemFormatter implements FeedItemFormatter
{

	@Override
	public String format(SyndEntry syndEntry)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("<font size='3.5'><a target='_blank'  href='"+syndEntry.getLink()+"'>"+syndEntry.getTitle()+"</a></font>");
		String description = syndEntry.getDescription().getValue();
		if(description.length() > 256)
		{
			description = description.substring(0, 256)+"...";
		}		
		sb.append("<br/>Description : "+description);
		//sb.append("<br/>URL : "+syndEntry.getUri());
		return sb.toString();
	}

}
