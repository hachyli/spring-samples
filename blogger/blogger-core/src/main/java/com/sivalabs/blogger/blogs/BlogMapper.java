package com.sivalabs.blogger.blogs;

import java.util.List;

import com.sivalabs.blogger.domain.Blog;
import com.sivalabs.blogger.domain.Comment;
import com.sivalabs.blogger.domain.Post;

/**
 * @author Siva
 * 
 */
public interface BlogMapper
{
	void createBlog(Blog blog);

	List<Blog> selectBlogs();

	Blog selectBlogById(int blogId);

	List<Post> selectBlogPosts(int blogId);

	List<Comment> selectPostComments(int postId);

}
