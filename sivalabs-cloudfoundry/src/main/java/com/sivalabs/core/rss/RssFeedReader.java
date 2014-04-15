/**
 * 
 */
package com.sivalabs.core.rss;

import java.net.URL;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * @author K. Siva Prasad Reddy
 *
 */
public class RssFeedReader
{
	public static SyndFeed getFeed(URL url) throws Exception
	{
		XmlReader reader = new XmlReader(url);
		return new SyndFeedInput().build(reader);
	}
}
