/**
 * 
 */
package com.sivalabs.springapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Siva
 *
 */
public class PasswordEncoderTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("admin: "+encoder.encode("admin"));
		System.out.println("test: "+encoder.encode("test"));
		
	}

}
