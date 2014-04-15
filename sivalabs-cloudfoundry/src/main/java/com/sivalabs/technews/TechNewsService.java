/**
 * 
 */
package com.sivalabs.technews;

import java.net.URL;

import org.springframework.stereotype.Service;

import com.sivalabs.core.rss.RssFeedReader;
import com.sun.syndication.feed.synd.SyndFeed;

/**
 * @author K. Siva Prasad Reddy
 *
 */
@Service
public class TechNewsService
{
	public SyndFeed getFeed(URL url) throws Exception
	{
		return RssFeedReader.getFeed(url);
	}
}
