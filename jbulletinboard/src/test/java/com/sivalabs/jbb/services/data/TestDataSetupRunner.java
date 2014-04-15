package com.sivalabs.jbb.services.data;

import java.util.Set;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.sivalabs.jbb.entities.Category;
import com.sivalabs.jbb.entities.User;
import com.sivalabs.jbb.services.ForumService;
import com.sivalabs.jbb.services.UserService;

/**
 * @author Siva
 *
 */
public class TestDataSetupRunner
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		GenericApplicationContext ctx = new GenericApplicationContext();
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
		xmlReader.loadBeanDefinitions(new ClassPathResource("spring/applicationContext.xml"));
		ctx.refresh();
		
		UserService userService = ctx.getBean(UserService.class);
		ForumService forumService = ctx.getBean(ForumService.class);
		
		Set<Category> categories = TestDataProvider.getCategories();
		for (Category category : categories)
		{
			try
			{
				forumService.createCategory(category);
			} catch (Exception e)
			{
			}
		}
		
		Set<User> users = TestDataProvider.getUsers();
		for (User user : users)
		{
			try
			{
				userService.createUser(user);
			} catch (Exception e)
			{
			}
		}
		
		
	}

}
