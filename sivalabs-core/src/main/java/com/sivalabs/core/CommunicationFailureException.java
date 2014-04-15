package com.sivalabs.core;

/**
 * @author SivaLabs
 *
 */
public class CommunicationFailureException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public CommunicationFailureException()
	{
		super();
	}

	public CommunicationFailureException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public CommunicationFailureException(String message)
	{
		super(message);
	}

	public CommunicationFailureException(Throwable cause)
	{
		super(cause);
	}
	
}
