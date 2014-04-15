/**
 * 
 */
package com.sivalabs.bookmarks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.bookmarks.entities.Tag;

/**
 * @author Siva
 *
 */
public interface TagRepository extends JpaRepository<Tag, Integer>
{

	Tag findByTagName(String tagName);


}
