/**
 * 
 */
package com.sivalabs.buzz.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sivalabs.buzz.entities.User;

/**
 * @author Siva
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void createUser(User user) {
		jdbcTemplate.update("insert into users(username) values(?)",
				new Object[]{user.getUserName()});
	}
	
	public User findUserById(Integer userId) {
		User user = null;
		user = jdbcTemplate.queryForObject("select * from users where id=?", new Object[]{userId}, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				return user;
			}});
		return user;
	}

	public List<User> findAllUsers() {
		return jdbcTemplate.query("select * from users", new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getInt("id"));
				user.setUserName(rs.getString("username"));
				return user;
			}}
		); 
	}
}
