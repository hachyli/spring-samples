package com.sivalabs.bookmarks.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sivalabs.bookmarks.entities.BookMark;
import com.sivalabs.bookmarks.services.BookMarkService;
import com.sivalabs.bookmarks.services.HibernateDetachUtility;
import com.sivalabs.bookmarks.services.HibernateDetachUtility.SerializationType;

/**
 * @author Siva
 *
 */
@Controller
public class BookmarksRESTService
{

	@Autowired private BookMarkService bookMarkService;
	
	@RequestMapping(value="services/bookmarks")
	@ResponseBody
	public List<BookMark> getBookmarksByTag(@RequestParam("tag") String tagName)
	{
		List<BookMark> detachedBookMarks = new ArrayList<BookMark>();
		List<BookMark> bookMarks = bookMarkService.getBookMarksByTag(tagName);
		for (BookMark  bm : bookMarks)
		{
			//BookMark bookMark = new BookMark(bm.getId(), bm.getTitle(), bm.getUrl(), bm.getDescription());
			//detachedBookMarks.add(bookMark);
			try
			{
				HibernateDetachUtility.nullOutUninitializedFields(bm, SerializationType.SERIALIZATION);
				detachedBookMarks.add(bm);
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
		return detachedBookMarks;
	}
}
