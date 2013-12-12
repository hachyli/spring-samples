/**
 * 
 */
package com.sivalabs.blogger.config;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * @author Siva
 *
 */
@Component
public class DBInitializer 
{
	
	@PostConstruct
	public void init() 
	{
		try{
			initUsers();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void initUsers() {
		
		
	}
}
