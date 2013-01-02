package com.sivalabs.bookmarks.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.bookmarks.entities.BookMark;
import com.sivalabs.bookmarks.entities.Tag;
import com.sivalabs.bookmarks.entities.User;
import com.sivalabs.bookmarks.services.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class UserServiceTest
{
	@Autowired private UserService userService;
	@Autowired private BookMarkService bookMarkService;
	
	
	//@Test
	public void testFindAllusers() {
		List<User> users = userService.findAllUsers();
		Assert.assertNotNull(users);
		for (User user : users) {
			System.err.println(user);
		}
	}
	//@Test
	public void testCreateBookmark()
	{
		BookMark bookMark = new BookMark();
		bookMark.setTitle("Javalobby");
		bookMark.setUrl("www.javalobby.com");
		bookMark.setUser(new User(1));
		bookMark.getTags().add(new Tag(null, "java"));
		bookMark.getTags().add(new Tag(null, "web"));
		bookMark.getTags().add(new Tag(null, "community"));
		
		bookMarkService.create(bookMark);
		
	}
	
	@Test
	public void testGetBookmarksByTag()
	{
		String tagName = "java";
		List<BookMark> bookMarks = bookMarkService.getBookMarksByTag(tagName );
		System.err.println(bookMarks.size());
		
		tagName = "java-ee";
		bookMarks = bookMarkService.getBookMarksByTag(tagName);
		System.err.println(bookMarks.size());
		
	}
}
