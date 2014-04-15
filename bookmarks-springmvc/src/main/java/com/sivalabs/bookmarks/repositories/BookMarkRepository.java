/**
 * 
 */
package com.sivalabs.bookmarks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.bookmarks.entities.BookMark;

/**
 * @author Siva
 *
 */
public interface BookMarkRepository extends JpaRepository<BookMark, Integer>
{

}
