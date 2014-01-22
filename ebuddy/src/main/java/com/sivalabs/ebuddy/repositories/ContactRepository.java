package com.sivalabs.ebuddy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.ebuddy.entities.Contact;

/**
 * @author Siva
 * 
 */
public interface ContactRepository extends JpaRepository<Contact, Integer>
{

	List<Contact> findByUserId(Integer userId);

}
