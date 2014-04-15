package com.sivalabs.linkshare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.linkshare.entities.Link;

/**
 * @author skatam
 *
 */
public interface LinkRepository extends JpaRepository<Link, Integer>
{

}
