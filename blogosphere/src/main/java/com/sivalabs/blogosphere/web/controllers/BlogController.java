/**
 * 
 */
package com.sivalabs.blogosphere.web.controllers;

import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sivalabs.blogosphere.BlogosphereException;
import com.sivalabs.blogosphere.domain.Blog;
import com.sivalabs.blogosphere.domain.Comment;
import com.sivalabs.blogosphere.domain.Post;
import com.sivalabs.blogosphere.domain.Tag;
import com.sivalabs.blogosphere.domain.User;
import com.sivalabs.blogosphere.service.BlogService;
import com.sivalabs.blogosphere.web.views.BlogView;
import com.sivalabs.blogosphere.web.views.NewBlogForm;
import com.sivalabs.blogosphere.web.views.NewPostForm;
import com.sivalabs.blogosphere.web.views.PostView;

/**
 * @author Siva
 *
 */
@Controller
@RequestMapping("/blogs")
public class BlogController 
{

	@Autowired private BlogService blogService;
	
	
	User getLoginUser(HttpServletRequest request)
	{
		return (User) request.getSession().getAttribute("LOGIN_USER");
	}
	
	@RequestMapping(value="/{blogId}",method=RequestMethod.GET)
	public String showBlog(@PathVariable("blogId") Integer blogId, Model model) 
	{
		Blog blog = this.blogService.getBlogById(blogId); 
		BlogView blogView = new BlogView();
		blogView.setBlog(blog);
		model.addAttribute("Blog", blogView);
		return "blog";
	}
	
	@RequestMapping(value="/createBlog",method=RequestMethod.GET)
	public String createBlogForm(Model model) 
	{
		NewBlogForm blogForm = new NewBlogForm();
		model.addAttribute("blogForm",blogForm);
		return "createBlog";
	}
	
	@RequestMapping(value="/createBlog",method=RequestMethod.POST)
	public String createBlog(@ModelAttribute("blogForm") NewBlogForm blogForm, Model model, HttpServletRequest request ) 
	{
		Blog blog = new Blog();
		blog.setBlogName(blogForm.getBlogName());
		blog.setCreatedOn(new Date());
		blog.setOwner(getLoginUser(request));
		
		try {
			this.blogService.createBlog(blog);
		} catch (BlogosphereException e) {
			blogForm.setErrorMsg(e.getMessage());
			return "createBlog";
		}
		
		return "redirect:/web/home";
	}
	
	@RequestMapping(value="/{blogId}/createPost",method=RequestMethod.GET)
	public String createPostForm(@PathVariable("blogId") Integer blogId, Model model) 
	{
		NewPostForm postForm = new NewPostForm();
		
		model.addAttribute("postForm", postForm);
		return "createPost";
	}
	
	@RequestMapping(value="/{blogId}/createPost",method=RequestMethod.POST)
	public String createPost(@ModelAttribute("postForm") NewPostForm postForm,@PathVariable("blogId") Integer blogId,
							Model model, HttpServletRequest request ) 
	{
		String view = "createPost";
		try 
		{
			Post post = postForm.getPost();
			Blog blog = new Blog();
			blog.setBlogId(blogId);
			post.setBlog(blog);
			post.setCreatedOn(new Date());
			String tagsString = postForm.getTags();
			if(StringUtils.trimToNull(tagsString)!=null){
				StringTokenizer tokenizer = new StringTokenizer(tagsString, ",");
				while(tokenizer.hasMoreTokens())
				{
					String token = tokenizer.nextToken();
					if(!StringUtils.isBlank(token))
					{
						Tag tag = new Tag();
						tag.setTagId(Integer.parseInt(token.trim()));
						post.getTags().add(tag);
					}
				}
			}
			
			this.blogService.createPost(post );
			view = "redirect:/web/blogs/"+post.getBlog().getBlogId();
		} catch (BlogosphereException e) {
			postForm.setErrorMsg(e.getMessage());
			return view;
		}
		
		return view;
	}
	
	@RequestMapping(value="/{blogId}/posts/{postId}", method=RequestMethod.GET)
	public String showPost(@PathVariable("blogId") Integer blogId, @PathVariable("postId") Integer postId, Model model) 
	{
		Post post = this.blogService.getPostById(postId);
		PostView  postView = new PostView();
		postView.setPost(post);
		model.addAttribute("postView", postView);
		return "post";
	}

	@RequestMapping(value="/{blogId}/posts/{postId}/comments/createComment", method=RequestMethod.POST)
	public String createComment(@PathVariable("blogId") Integer blogId, @PathVariable("postId") Integer postId, 
			@ModelAttribute("postView") PostView postView, Model model, HttpServletRequest request) 
	{
		String view = "post";
		Comment comment = postView.getNewComment();
		comment.setCreatedBy(this.getLoginUser(request));
		comment.setCreatedOn(new Date());
		try {
			this.blogService.createComment(comment);
			view = "redirect:/web/blogs/"+blogId+"/posts/"+postId;
		} catch (BlogosphereException e) {
			postView.setErrorMsg(e.getMessage());
			e.printStackTrace();
		}
		
		
		return view;
	}
}
