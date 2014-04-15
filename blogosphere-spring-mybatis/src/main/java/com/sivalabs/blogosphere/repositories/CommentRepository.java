package com.sivalabs.blogosphere.repositories;

import java.util.List;

import com.sivalabs.blogosphere.domain.Comment;

/**
 * @author Siva
 *
 */
public interface CommentRepository
{
	void createComment(Comment comment);
	List<Comment> getCommentsByPostId(Integer postId);
	Comment getCommentById(Integer commentId);
	void updateComment(Comment comment);
	void deleteComment(Integer commentId);
	void deleteCommentsByPostId(Integer postId);
}
