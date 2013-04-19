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

import com.sivalabs.buzz.entities.Post;
import com.sivalabs.buzz.entities.User;

/**
 * @author Siva
 *
 */
@Repository
public class PostRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void createPost(Post post) {
		System.out.println(post);
		jdbcTemplate.update("insert into posts(text, user_id, created_on) values(?,?,?)",
				new Object[]{post.getText(), post.getCreatedBy().getUserId(), post.getCreatedOn()});
		
	}

	public List<Post> findAllPosts() {
		return jdbcTemplate.query("select * from posts  order by created_on desc", new RowMapper<Post>(){

			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setText(rs.getString("text"));
				post.setCreatedBy(new User(rs.getInt("user_id")));
				post.setCreatedOn(rs.getDate("created_on"));
				return post;
			}}
		); 
	}
	
	public List<Post> findUserPosts(int userId) {
		return jdbcTemplate.query("select * from posts where user_id=? order by created_on desc", 
				new Object[]{userId},
				new RowMapper<Post>(){

			@Override
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setText(rs.getString("text"));
				post.setCreatedBy(new User(rs.getInt("user_id")));
				post.setCreatedOn(rs.getDate("created_on"));
				return post;
			}}
		); 
	}
}
