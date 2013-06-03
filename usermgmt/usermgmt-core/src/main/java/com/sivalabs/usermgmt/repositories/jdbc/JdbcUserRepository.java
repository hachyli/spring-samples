/**
 * 
 */
package com.sivalabs.usermgmt.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;

import com.sivalabs.usermgmt.entities.User;
import com.sivalabs.usermgmt.repositories.UserRepository;

/**
 * @author Siva
 *
 */
//@Repository
public class JdbcUserRepository implements UserRepository 
{

	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	@Override
	public User findUserById(Integer userId) 
	{
		User user = null;
			List<User> users = jdbcTemplate.query("select * from users where user_id=?", 
					new Object[]{userId}, 
					new UserRowMapper());
			if(users!=null && !users.isEmpty()){
				user = users.get(0);
			}
		
		return user;
	}

	@Override
	public List<User> findAllUsers() 
	{
		return jdbcTemplate.query("select * from users", new UserRowMapper()); 
	}

	@Override
	public int createUser(final User user) 
	{
		final String sql = "insert into users(username, password,firstname,lastname,email_id,disabled) values(?,?,?,?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
		    new PreparedStatementCreator() {
		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		            PreparedStatement ps =
		                connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		            ps.setString(1, user.getUserName());
		            ps.setString(2, user.getPassword());
		            ps.setString(3, user.getFirstName());
		            ps.setString(4, user.getLastName());
		            ps.setString(5, user.getEmailId());
		            ps.setBoolean(6, user.isDisabled());
		            return ps;
		        }
		    },
		    keyHolder);
		user.setUserId(keyHolder.getKey().intValue());
		return user.getUserId();
	}

	@Override
	public int updateUser(User user) 
	{
		String sql = "update users set firstname=?,lastname=?,email_id=?,disabled=? where user_id=?";
		Object[] args = new Object[]{
				user.getFirstName(),
				user.getLastName(),
				user.getEmailId(),
				user.isDisabled(),
				user.getUserId()
		};
		int count = jdbcTemplate.update(sql, args);
		return count;
	}

	@Override
	public int deleteUser(Integer userId) {
		String sql = "delete from users where user_id=?";
		Object[] args = new Object[]{userId};
		int count = jdbcTemplate.update(sql, args);
		return count;
	}

	@Override
	public int deleteAllUsers() 
	{
		String sql = "delete from users";
		int count = jdbcTemplate.update(sql);
		return count;
	}

	@Override
	public User login(User credentials) 
	{
		User user = null;
		String userName =credentials.getUserName();
		String password = credentials.getPassword();
		List<User> users = jdbcTemplate.query("select * from users where username=? and password=?", 
							new Object[]{userName, password}, 
							new UserRowMapper());
		if(users!=null && !users.isEmpty()){
			user = users.get(0);
		}
	
		return user;
	}

	@Override
	public List<User> searchUsers(String searchName) 
	{

		return jdbcTemplate.query("select * from users where username like ? " +
				" or firstname like ? or lastname like ? or email_id like ?", 
				new Object[]{searchName+"%",searchName+"%",searchName+"%",searchName+"%"},
				new UserRowMapper()); 
	}

	@Override
	public boolean isUserNameExists(String userName) {
		String sql = "select count(*) from users where username=?";
		int count = jdbcTemplate.queryForInt(sql, userName);
		return (count>0);
	}

	@Override
	public boolean isEmailIdExists(String emailId) {
		String sql = "select count(*) from users where email_id=?";
		int count = jdbcTemplate.queryForInt(sql, emailId);
		return (count>0);
	}

	@Override
	public int getUserIdByEmailId(String emailId) {
		int userId =  -1;
		String sql = "select user_id from users where email_id=?";
		try {
			userId = jdbcTemplate.queryForInt(sql, emailId);
		} catch (DataAccessException e) {
			//e.printStackTrace();
			//if u r here means no User exists with the given email
		}
		return userId;
	}
}


class UserRowMapper implements RowMapper<User>
{
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		User user = new User();
		user.setUserId(rs.getInt("user_id"));
		user.setUserName(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setEmailId(rs.getString("email_id"));
		user.setDisabled(rs.getBoolean("disabled"));
		return user;
	}
	
}