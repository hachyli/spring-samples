/**
 * 
 */
package com.sivalabs.technews;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sivalabs.core.rss.HtmlFeedFormatter;
import com.sun.syndication.feed.synd.SyndFeed;

/**
 * @author K. Siva Prasad Reddy
 *
 */
@Controller
public class TechNewsController
{
	@Autowired
	private TechNewsService techNewsService;
	
	@RequestMapping("technews")
	public String showTechNews()
	{
		return "technews/technews";
	}
	
	@RequestMapping("techNewsFeed")
	public String showTechNewsFeed(Model model, @RequestParam("siteId") int siteId)
	{
		//String javalobbyFeedUrl = "http://www.javalobby.org/rss/rssthreads.jsp?forumid=17";
		try {
			TechNewsFeedSite newsFeedSite = TechNewsFeedSite.getTechNewsFeedSiteById(siteId);
			URL url = new URL(newsFeedSite.getUrl());
			SyndFeed feed = this.techNewsService.getFeed(url);
			HtmlFeedFormatter feedFormatter = new HtmlFeedFormatter();
			String feedContent = feedFormatter.formatFeedContent(feed);
			model.addAttribute("FEED_SITE",newsFeedSite);
			model.addAttribute("FEED_CONTENT", feedContent);			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "technews/techNewsFeed";
	}
}
