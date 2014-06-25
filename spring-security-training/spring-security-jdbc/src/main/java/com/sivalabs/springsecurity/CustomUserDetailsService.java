/**
 * 
 */
package com.sivalabs.springsecurity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Siva
 *
 */
@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		String getUserSql = "select id, email,password, disabled from sec_users where email = ?";
		List<DomainUser> users = jdbcTemplate.query(getUserSql, new Object[]{username}, new RowMapper<DomainUser>(){
			@Override
			public DomainUser mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				DomainUser user = new DomainUser();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setDisabled(rs.getBoolean("disabled"));
				
				return user;
			}});
		if(users == null || users.isEmpty()){
			throw new UsernameNotFoundException("User doesn't exist");
		}
		DomainUser domainUser = users.get(0);
		String getUserRolesSql = "select r.role from sec_roles r join sec_users u on r.user_id=u.id where email = ?";
		
		List<String> roles = jdbcTemplate.query(getUserRolesSql, new Object[]{username}, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				return rs.getString("role");
			}});
		domainUser.setRoles(roles);
		return new SecurityUser(domainUser);
	}

}

