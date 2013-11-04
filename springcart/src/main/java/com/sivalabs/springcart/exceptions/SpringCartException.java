/**
 * 
 */
package com.sivalabs.springcart.exceptions;

/**
 * @author Siva
 *
 */
public class SpringCartException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public SpringCartException() {
		super();
	}

	public SpringCartException(String message, Throwable cause) {
		super(message, cause);
	}

	public SpringCartException(String message) {
		super(message);
	}

	public SpringCartException(Throwable cause) {
		super(cause);
	}
	
}
