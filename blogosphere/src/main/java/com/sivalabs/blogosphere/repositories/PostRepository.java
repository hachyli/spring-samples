package com.sivalabs.blogosphere.repositories;

import java.util.List;

import com.sivalabs.blogosphere.domain.Post;

/**
 * @author Siva
 *
 */
public interface PostRepository
{
	void createPost(Post post);
	List<Post> getPostsByBlogId(Integer blogId);
	Post getPostById(Integer postId);
	void updatePost(Post post);
	void deletePost(Integer postId);
	
}
