/**
 * 
 */
package com.sivalabs.blogger.users;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sivalabs.blogger.domain.User;


/**
 * @author Siva
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository
{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public User login(String userName, String password) {
		try {
			return jdbcTemplate.queryForObject("select * from users where username=? and password=?",
					new Object[]{userName, password}, new UserRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}

class UserRowMapper implements RowMapper<User>
{

	@Override
	public User mapRow(ResultSet rs, int n) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("user_id"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setEmail(rs.getString("email"));
		user.setDob(rs.getDate("dob"));
		return user;
	}
	
}