package com.sivalabs.forum.dao.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sivalabs.forum.dao.TopicDAO;
import com.sivalabs.forum.domain.Topic;
@Repository
public class TopicDAOImpl extends HibernateGenericDAO<Topic, Long> 
				implements TopicDAO
{

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Topic> getForumTopics(long forumId)
	{
		Criteria criteria = this.getSession().createCriteria(Topic.class);
		criteria.add(Restrictions.eq("forumId", forumId));
		return criteria.list();
	}
	

}
