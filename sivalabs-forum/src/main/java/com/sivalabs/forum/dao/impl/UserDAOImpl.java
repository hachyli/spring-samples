/**
 * 
 */
package com.sivalabs.forum.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sivalabs.forum.dao.UserDAO;
import com.sivalabs.forum.domain.User;

/**
 * @author siva
 *
 */
@Repository
public class UserDAOImpl extends HibernateGenericDAO<User, Integer> 
						 implements UserDAO 
{

	@SuppressWarnings("unchecked")
	@Override
	public User login(String userName, String password)
	{
		Criteria criteria = this.getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password", password));
		List<User> list = criteria.list();
		if (list!=null && list.size() > 0 ){			
			return list.get(0);
		}
		return null;
	}

}
