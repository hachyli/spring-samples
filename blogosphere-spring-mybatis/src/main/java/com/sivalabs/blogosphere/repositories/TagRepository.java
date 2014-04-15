package com.sivalabs.blogosphere.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sivalabs.blogosphere.domain.Tag;

/**
 * @author Siva
 *
 */
public interface TagRepository
{
	void createTag(Tag tag);
	List<Tag> getAllTags();
	Tag getTagById(Integer tagId);
	void updateTag(Tag tag);
	void deleteTag(Integer tagId);
	
	public void insertPostTag(@Param("postId") int postId, @Param("tagId") int tagId);
	public void deletePostTag(@Param("postId") int postId, @Param("tagId") int tagId);
	public List<Tag> getTagsByPostId(int postId);
	void deletePostTags(Integer postId);
	
}
