package com.sivalabs.blogosphere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.blogosphere.BlogosphereException;
import com.sivalabs.blogosphere.domain.Blog;
import com.sivalabs.blogosphere.domain.Comment;
import com.sivalabs.blogosphere.domain.Post;
import com.sivalabs.blogosphere.domain.Tag;
import com.sivalabs.blogosphere.domain.User;
import com.sivalabs.blogosphere.repositories.BlogRepository;
import com.sivalabs.blogosphere.repositories.CommentRepository;
import com.sivalabs.blogosphere.repositories.PostRepository;
import com.sivalabs.blogosphere.repositories.TagRepository;
import com.sivalabs.blogosphere.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class BlogService //implements BlogRepository, PostRepository, CommentRepository
{
	//@Autowired private SqlSession sqlSession;
	@Autowired private UserRepository userRepository;
	@Autowired private BlogRepository blogRepository;
	@Autowired private PostRepository postRepository;
	@Autowired private CommentRepository commentRepository;
	@Autowired private TagRepository tagRepository;
	
	//************************* Blog Methods ***************//
	public Blog createBlog(Blog blog)
	{
		if(blogRepository.blogNameExists(blog.getBlogName()))
		{
			throw new BlogosphereException("Blog Name ["+blog.getBlogName()+"] is already in use.");
		}
		blogRepository.createBlog(blog);
		return blog;
	}
	
	public List<Blog> getAllBlogs()
	{
		return blogRepository.getAllBlogs();
	}
	
	public List<Blog> getUserBlogs(Integer userId)
	{
		User owner = userRepository.getUserById(userId);
		 List<Blog> blogs = blogRepository.getUserBlogs(userId);
		 for (Blog blog : blogs) {
			blog.setOwner(owner);
		}
		 return blogs;
	}
	
	public Blog getBlogById(Integer blogId)
	{
		Blog blog = blogRepository.getBlogById(blogId);
		if(blog == null){
			return null;
		}
		User owner = userRepository.getUserById(blog.getOwner().getUserId());
		blog.setOwner(owner);
		List<Post> posts = postRepository.getPostsByBlogId(blogId);
		blog.setPosts(posts);
		return blog;
	}
	
	
	//************************* Post Methods ***************//
	public Post createPost(Post post)
	{
		postRepository.createPost(post);
		List<Tag> tags = post.getTags();
		for (Tag tag : tags) {
			tagRepository.insertPostTag(post.getPostId(), tag.getTagId());
		}
		return post;
	}
	
	public Post getPostById(Integer postId)
	{
		Post post = postRepository.getPostById(postId);
		if(post == null){
			return null;
		}
		Blog blog = blogRepository.getBlogById(post.getBlog().getBlogId());
		post.setBlog(blog);
		post.setComments(commentRepository.getCommentsByPostId(postId));
		post.setTags(tagRepository.getTagsByPostId(postId));
		return post;	
	}
	
	public List<Post> getPostsByBlogId(Integer blogId)
	{
		Blog blog = blogRepository.getBlogById(blogId);
		
		List<Post> posts = postRepository.getPostsByBlogId(blogId);
		for (Post post : posts) 
		{
			post.setBlog(blog);
		}
		return posts;
	}
	
	public Post updatePost(Post post)
	{
		postRepository.updatePost(post);
		//TODO Add/remove Tags
		return post;
	}

	public void deletePost(Integer postId)
	{
		tagRepository.deletePostTags(postId);
		this.deleteCommentsByPostId(postId);
		postRepository.deletePost(postId);
	}
	
	//************************* Comment Methods ***************//
	
	public Comment createComment(Comment comment)
	{
		commentRepository.createComment(comment);
		return comment;
	}
	
	public List<Comment> getCommentsByPostId(Integer postId)
	{
		Post post = postRepository.getPostById(postId);
		List<Comment> comments = commentRepository.getCommentsByPostId(postId);
		for (Comment comment : comments) {
			comment.setPost(post);
		}
		return comments;
	}

	public Comment getCommentById(Integer commentId)
	{
		Comment comment = commentRepository.getCommentById(commentId);
		
		return comment;
	}

	public Comment updateComment(Comment comment)
	{
		commentRepository.updateComment(comment);
		return comment;
	}

	public void deleteComment(Integer commentId)
	{
		commentRepository.deleteComment(commentId);	
	}
	
	public void deleteCommentsByPostId(Integer postId)
	{
		commentRepository.deleteCommentsByPostId(postId);
	}

	public List<Tag> getAllTags() {
		return tagRepository.getAllTags();
	}

}
