/**
 * 
 */
package com.sivalabs.core.rss;

import java.net.URL;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RssFeedReader
{

	public static void main(String[] args) throws Exception
	{
		String urlString = null;
		urlString = "http://viralpatel.net/blogs/feed";
		urlString = "http://www.vogella.de/article.rss";
		urlString = "http://feeds.pheedo.com/techtarget/tsscom/home";
		//urlString = "http://www.javalobby.org/rss/rssthreads.jsp?forumid=17";
		
		URL url = new URL(urlString);
		XmlReader reader = null;

		try {

			reader = new XmlReader(url);
			SyndFeed feed = new SyndFeedInput().build(reader);
			System.out.println("Feed Title: " + feed.getAuthor());
			
			for (Iterator i = feed.getEntries().iterator(); i.hasNext();) 
			{
				SyndEntry entry = (SyndEntry) i.next();
				//System.out.println(entry.getTitle());
				//System.out.println(ToStringBuilder.reflectionToString(entry));
				printEntry(entry);
			}
		} 
		finally 
		{
			if (reader != null)
				reader.close();
		}
	}
	
	private static void printEntry(SyndEntry entry)
	{
		System.out.println("=========================");
		System.out.println("Title="+entry.getTitle());
		System.out.println("Description="+entry.getDescription().getValue());
		System.out.println("URI="+entry.getUri());
		System.out.println(entry.getLink());
		/*System.out.println("="+);
		System.out.println("="+);
		System.out.println("="+);
		*/
	}
}
