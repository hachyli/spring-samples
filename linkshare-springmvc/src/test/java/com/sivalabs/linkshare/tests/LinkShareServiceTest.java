/**
 * 
 */
package com.sivalabs.linkshare.tests;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.linkshare.entities.Comment;
import com.sivalabs.linkshare.entities.Link;
import com.sivalabs.linkshare.entities.User;
import com.sivalabs.linkshare.entities.UserLogon;
import com.sivalabs.linkshare.entities.Vote;
import com.sivalabs.linkshare.services.LinkShareService;

/**
 * @author skatam
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
@ActiveProfiles("dev")
public class LinkShareServiceTest 
{
	//private static final Logger LOGGER = LoggerFactory.getLogger(LinkShareServiceTest.class);
	@Autowired private LinkShareService linkShareService;
	
	//@Test
	public void testCreateUser() {
		UserLogon userLogon = new UserLogon();
		userLogon.setUsername("admin");
		userLogon.setPassword("admin");
		
		User user = new User();
		user.setFirstname("Siva");
		user.setEmail("sivaprasad@gmail.com");
		
		user.setUserLogon(userLogon);
		userLogon.setUser(user);
		
		Integer userId = this.linkShareService.saveUser(user);
		Assert.assertNotNull(userId);
	}
	

	//@Test
	public void login() {
		User user = this.linkShareService.login("admin", "admin");
		System.out.println(user);
	}
	//@Test
	public void findUserById() {
		User user = this.linkShareService.findUser(1);
		System.out.println(user);
	}
	//@Test
	public void findAllUsers(){
		List<User> users = this.linkShareService.findAllUsers();
		System.out.println(users.size());
	}
	
	//@Test
	public void saveLink() {
		Link link1 = new Link();
		link1.setTitle("TheServerSide");
		link1.setUrl("www.theserverside.com");
		link1.setPostedOn(new Date());
		
		Link link2 = new Link();
		link2.setTitle("Twitter");
		link2.setUrl("www.twitter.com");
		link2.setPostedOn(new Date());
		
		User user = this.linkShareService.findUser(1);
		//user.getLinks().add(link1);
		//user.getLinks().add(link2);
		link1.setPostedBy(user);
		link2.setPostedBy(user);
		
		this.linkShareService.saveLink(link1);
		this.linkShareService.saveLink(link2);
		
	}
	
	//@Test
	public  void findAllLinks(){
		List<Link> links = this.linkShareService.findAllLinks();
		System.out.println(links.size());
	}
	//@Test
	public void findLink()
	{
		Link link = this.linkShareService.findLink(2);
		System.out.println(link.getUrl());
	}
	//@Test
	public void findUserLinks()
	{
		List<Link> links = this.linkShareService.findUserLinks(1);
		System.out.println(links.size());
	}
	
	//@Test(expected=RuntimeException.class)
	public void findInvalidUserLinks()
	{
		List<Link> links = this.linkShareService.findUserLinks(2);
		System.out.println(links.size());
	}
	//@Test
	public void saveComment() {
		Comment comment = new Comment();
		comment.setMessage("test comment");
		comment.setPostedOn(new Date());
		comment.setLink(this.linkShareService.findLink(2));
		comment.setPostedBy(this.linkShareService.findUser(1));
		Integer commentId = this.linkShareService.saveComment(comment);
		System.out.println(commentId);
	}
	//@Test
	public void findUserComments() {
		List<Comment> comments = this.linkShareService.findUserComments(1);
		System.out.println(comments.size());
	}
	//@Test(expected=RuntimeException.class)
	public void findInvalidUserComments() {
		List<Comment> comments = this.linkShareService.findUserComments(2);
		System.out.println(comments.size());
	}
	//@Test
	public void saveVote() {
		Vote vote = new Vote();
		vote.setLink(this.linkShareService.findLink(2));
		vote.setVotedBy(this.linkShareService.findUser(1));
		vote.setUpDown(true);
		vote.setVotedOn(new Date());
		Integer voteId = this.linkShareService.saveVote(vote);
		System.out.println(voteId);
	}
	//@Test
	public void findLinkVotes() {
		List<Vote> votes = this.linkShareService.findLinkVotes(2);
		System.out.println(votes.size());
	}
	
	@Test
	public void findUserVotes() {
		List<Vote> votes = this.linkShareService.findUserVotes(1);
		System.out.println(votes.size());
	}
}
