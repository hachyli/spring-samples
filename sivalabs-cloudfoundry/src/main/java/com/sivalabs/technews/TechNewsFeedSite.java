/**
 * 
 */
package com.sivalabs.technews;

/**
 * @author K. Siva Prasad Reddy
 *
 */
public enum TechNewsFeedSite 
{
	JAVALOBBY(1,"JavaLobby","http://www.javalobby.org/rss/rssthreads.jsp?forumid=17"), 
	TSS(2,"TheServerSide.com", "http://feeds.pheedo.com/techtarget/tsscom/home");
	
	private int id;
	private String name;
	private String url;
	
	private TechNewsFeedSite(int id, String name, String url)
	{
		this.id = id;
		this.name = name;
		this.url = url;
	}

	public int getId()
	{
		return id;
	}

	public String getUrl()
	{
		return url;
	}
	
	public String getName()
	{
		return name;
	}

	public static TechNewsFeedSite getTechNewsFeedSiteById(int id)
	{
		TechNewsFeedSite[] values = TechNewsFeedSite.values();
		for (TechNewsFeedSite techNewsFeedSite : values) 
		{
			if( id == techNewsFeedSite.id){
				return techNewsFeedSite;
			}
		}
		return null;
	}
	
}
