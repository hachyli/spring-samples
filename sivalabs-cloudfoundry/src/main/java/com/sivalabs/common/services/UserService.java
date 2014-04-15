/**
 * 
 */
package com.sivalabs.common.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.common.model.User;

/**
 * @author K. Siva Prasad Reddy
 *
 */
@Repository
@Transactional
public class UserService
{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Integer login(String username, String password)
	{
		Integer userId = -1;
		String sql = "select user_id from users where username=? and password=?";
		List<Integer> list = this.jdbcTemplate.query(sql, new Object[]{username, password}, new RowMapper<Integer>(){

			@Override
			public Integer mapRow(ResultSet rs, int arg1) throws SQLException
			{
				return rs.getInt("user_id");
			}});
		if(list != null && !list.isEmpty()){
			userId = list.get(0);
		}
		return userId;
	}
	
	public User	getUserById(Integer userId)
	{
		User user = null;
		String sql = "select user_id,username,password,firstname,lastname from users where user_id=?";
		
		user = this.jdbcTemplate.queryForObject(sql, new Object[]{userId}, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException
			{
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				return user; 
			}});
		return user;
	}
}
