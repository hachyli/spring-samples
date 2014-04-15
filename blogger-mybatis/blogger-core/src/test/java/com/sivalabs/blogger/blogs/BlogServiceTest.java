package com.sivalabs.blogger.blogs;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.blogger.config.AppConfig;
import com.sivalabs.blogger.domain.Blog;
import com.sivalabs.blogger.domain.Comment;
import com.sivalabs.blogger.domain.Post;
import com.sivalabs.blogger.domain.User;

/**
 * @author Siva
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class BlogServiceTest
{
	@Autowired
	private BlogService blogService;

	@Test
	public void selectBlogs()
	{
		List<Blog> blogs = blogService.selectBlogs();
		for (Blog blog : blogs) {
			System.err.println(blog);
		}
	}

	@Test
	public void selectBlogById()
	{
		int blogId = 1;
		Blog blog = blogService.selectBlogById(blogId);
		System.err.println(blog);
	}

	@Test
	public void selectBlogPosts()
	{
		int blogId = 1;
		List<Post> posts = blogService.selectBlogPosts(blogId);
		for (Post post : posts) {
			System.err.println(post);
		}
	}

	@Test
	public void selectPostComments()
	{
		int postId = 1;
		List<Comment> comments = blogService.selectPostComments(postId);
		for (Comment comment : comments) {
			System.err.println(comment);
		}
	}

	@Test
	public void createBlog()
	{
		Blog blog = new Blog(0, "TestBlog", "My Test Blog");
		User user = new User(1);
		blog.setUser(user);
		blogService.createBlog(blog);
		System.out.println(blog.getId());
	}

}
