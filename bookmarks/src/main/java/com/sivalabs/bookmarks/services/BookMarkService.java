/**
 * 
 */
package com.sivalabs.bookmarks.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.bookmarks.entities.BookMark;
import com.sivalabs.bookmarks.entities.Tag;
import com.sivalabs.bookmarks.entities.User;
import com.sivalabs.bookmarks.repositories.BookMarkRepository;
import com.sivalabs.bookmarks.repositories.TagRepository;
import com.sivalabs.bookmarks.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class BookMarkService 
{
	@Autowired private BookMarkRepository bookMarkRepository;
	@Autowired private UserRepository userRepository;
	@Autowired private TagRepository tagRepository;
	
	public List<BookMark> getAllBookMarks() 
	{
		return bookMarkRepository.findAll();
	}
	
	public List<BookMark> getBookMarksByUserId(Integer userId) {
		User user = userRepository.findOne(userId);
		if(user != null){
			return new ArrayList<BookMark>(user.getBookMarks());
		}
		return new ArrayList<BookMark>();
	}

	public void create(BookMark bookMark) 
	{
		Set<Tag> tags = new HashSet<Tag>();
		Set<Tag> givenTags = bookMark.getTags();
		for (Tag tagObj : givenTags)
		{
			String tagName = tagObj.getTagName();
			Tag tag = tagRepository.findByTagName(tagName);
			if(tag == null)
			{
				tagObj.setTagId(null);
				tags.add(tagObj);
			}
			else
			{
				tags.add(tag);
			}
		}
		bookMark.setTags(tags);
		
		bookMarkRepository.save(bookMark);		
	}

	public Page<BookMark> getBookMarks(int pageNo, int pageSize)
	{
		//long count = bookMarkRepository.count();
		Sort sort = new Sort(Direction.DESC, "bookmarkId");
		Pageable pageable = new PageRequest(pageNo, pageSize, sort);
		Page<BookMark> results = bookMarkRepository.findAll(pageable);
		//TODO; remove Spring dependency
		return results;
	}
}
