package com.sivalabs.forum.dao.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sivalabs.forum.dao.PostDAO;
import com.sivalabs.forum.domain.Post;
@Repository
public class PostDAOImpl extends HibernateGenericDAO<Post, Long> 
				implements PostDAO
{

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Post> getPosts(long topicId)
	{
		Criteria criteria = this.getSession().createCriteria(Post.class);
		criteria.add(Restrictions.eq("topicId", topicId));
		return criteria.list();
	}
	

}
