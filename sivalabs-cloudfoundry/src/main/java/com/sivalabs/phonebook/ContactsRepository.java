/**
 * 
 */
package com.sivalabs.phonebook;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * @author K. Siva Prasad Reddy
 *
 */
public interface ContactsRepository extends JpaRepository<Contact, Integer>
{
	@Query("select c from Contact c where c.user.userId=?1")
	public List<Contact> findByUserId(Integer userId);
}
