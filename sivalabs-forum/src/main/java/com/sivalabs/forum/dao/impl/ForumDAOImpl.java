package com.sivalabs.forum.dao.impl;

import org.springframework.stereotype.Repository;

import com.sivalabs.forum.dao.ForumDAO;
import com.sivalabs.forum.domain.Forum;
@Repository
public class ForumDAOImpl extends HibernateGenericDAO<Forum, Long> 
				implements ForumDAO
{
	

}
