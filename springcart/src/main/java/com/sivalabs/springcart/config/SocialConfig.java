/**
 * 
 */
package com.sivalabs.springcart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

/**
 * @author Siva
 *
 */
@Configuration
public class SocialConfig {

	
	@Autowired
	private Environment environment;
	
	@Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new TwitterConnectionFactory(
            environment.getProperty("twitter.consumerKey"),
            environment.getProperty("twitter.consumerSecret")));
        return registry;
    }
	
	@Bean
	public TwitterTemplate twitterTemplate(){
		String consumerKey = environment.getProperty("twitter.consumerKey");
		String consumerSecret = environment.getProperty("twitter.consumerSecret");
		String accessToken = environment.getProperty("twitter.accessToken");
		String accessTokenSecret = environment.getProperty("twitter.accessTokenSecret");
		return new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		
	}
	 
}
