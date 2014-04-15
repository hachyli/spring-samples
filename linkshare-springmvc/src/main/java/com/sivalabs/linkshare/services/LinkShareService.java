package com.sivalabs.linkshare.services;

import java.util.List;

import com.sivalabs.linkshare.entities.Comment;
import com.sivalabs.linkshare.entities.Link;
import com.sivalabs.linkshare.entities.User;
import com.sivalabs.linkshare.entities.Vote;

public interface LinkShareService {

	/*****************User Related Operations*********************/
	public User login(String userName, String password);
	
	public Integer saveUser(User user);

	public User findUser(Integer userId);

	public List<User> findAllUsers();
	
	
	/*****************Link Related Operations*********************/
	public List<Link> findAllLinks();
	
	public Link findLink(Integer linkId);
	
	public Integer saveLink(Link link);

	public List<Link> findUserLinks(Integer userId);
	
	//public void saveLinks(Link... links);
	//public void saveUserLinks(Integer userId, Link... links);

	/*****************Comments Related Operations*********************/
	
	public Integer saveComment(Comment comment);

	public List<Comment> findUserComments(Integer userId);
	
	/*****************Vote Related Operations*********************/
	public Integer saveVote(Vote vote);

	public List<Vote> findLinkVotes(Integer userId);
	
	public List<Vote> findUserVotes(Integer userId);
}