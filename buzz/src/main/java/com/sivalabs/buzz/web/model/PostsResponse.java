/**
 * 
 */
package com.sivalabs.buzz.web.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.sivalabs.buzz.entities.Post;

/**
 * @author Siva
 *
 */
@XmlRootElement
public class PostsResponse 
{
	private List<Post> posts;
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public List<Post> getPosts() {
		return posts;
	}
}
