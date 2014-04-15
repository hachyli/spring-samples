/**
 * 
 */
package com.sivalabs.linkshare.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.linkshare.entities.Comment;
import com.sivalabs.linkshare.entities.Link;
import com.sivalabs.linkshare.entities.User;
import com.sivalabs.linkshare.entities.UserLogon;
import com.sivalabs.linkshare.entities.Vote;
import com.sivalabs.linkshare.repositories.LinkRepository;
import com.sivalabs.linkshare.repositories.UserRepository;

/**
 * @author skatam
 *
 */
@Service
@Transactional
public class LinkShareServiceImpl implements LinkShareService
{
	@Autowired private UserRepository userRepository;
	@Autowired private LinkRepository linkRepository;
	
	/*****************User Related Operations*********************/
	@Override
	public User login(String userName, String password)
	{
		UserLogon userLogon = this.userRepository.login(userName, password);
		if(userLogon != null){
			return userLogon.getUser();
		}
		return null;
	}
	
	@Override
	public Integer saveUser(User user) 
	{
		return userRepository.save(user).getUserId();
	}

	@Override
	public User findUser(Integer userId) 
	{
		return userRepository.findOne(userId);
	}

	@Override
	public List<User> findAllUsers() 
	{
		return userRepository.findAll();
	}	
	
	/*****************Link Related Operations*********************/
	
	@Override
	public List<Link> findAllLinks()
	{
		return this.linkRepository.findAll(new Sort(Direction.DESC, "postedOn"));
	}
	
	@Override
	public Link findLink(Integer linkId) {
		return this.linkRepository.findOne(linkId);
	}
	
	@Override
	public Integer saveLink(Link link) {
		return this.linkRepository.save(link).getLinkId();
	}
	
	/*@Override
	public void saveLinks(Link... links) {
		if(links!=null && links.length>0){
			this.linkRepository.save(Arrays.asList(links));
		}
	}
	
	@Override
	public void saveUserLinks(Integer userId, Link... links) {
		User user = this.userRepository.findOne(userId);
		if(links !=null)
		{
			for (Link link : links) 
			{
				link.setPostedBy(user);
				user.getLinks().add(link);
			}
		}
	}*/

	@Override
	public List<Link> findUserLinks(Integer userId) {
		User user = this.findUser(userId);
		if(user == null){
			throw new RuntimeException("No User exists with UserId:"+userId);
		}
		Collection<Link> links = this.findUser(userId).getLinks();
		if(links!=null){
			return new ArrayList<Link>(links);
		}
		return new ArrayList<Link>();
	}

	/*****************Comments Related Operations*********************/

	@Override
	public Integer saveComment(Comment comment) 
	{
		 User user = this.findUser(comment.getPostedBy().getUserId());
		 user.getComments().add(comment);
		 return comment.getCommentId();
	}

	@Override
	public List<Comment> findUserComments(Integer userId) {
		User user = this.findUser(userId);
		if(user == null){
			throw new RuntimeException("No User exists with UserId:"+userId);
		}
		return new ArrayList<Comment>(user.getComments());
	}

	@Override
	public Integer saveVote(Vote vote) {
		Link link = this.findLink(vote.getLink().getLinkId());
		link.getVotes().add(vote);
		return vote.getVoteId();
	}

	@Override
	public List<Vote> findLinkVotes(Integer linkId) {
		Link link = this.findLink(linkId);
		return new ArrayList<Vote>(link.getVotes());
	}

	@Override
	public List<Vote> findUserVotes(Integer userId) {
		User user = this.findUser(userId);
		if(user == null){
			throw new RuntimeException("No User exists with UserId:"+userId);
		}
		return new ArrayList<Vote>(user.getVotes());
	}
}
