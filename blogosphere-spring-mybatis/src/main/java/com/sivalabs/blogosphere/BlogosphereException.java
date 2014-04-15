
package com.sivalabs.blogosphere;

/**
 * @author skatam
 *
 */
public class BlogosphereException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	
	public BlogosphereException() {
	}

	public BlogosphereException(String msg) {
		super(msg);
	}
	public BlogosphereException(Throwable cause) {
		super(cause);
	}

	public BlogosphereException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
