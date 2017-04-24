package com.bootcamp.Topic6.Exceptions;

/**
 * 
 * Exception thrown when a service are not found
 *
 */
public class UserNotFoundException extends Exception{

	/**
	 *  Serialized because the inheritance of a serialized class
	 */
	private static final long serialVersionUID = 2809759577129753830L;
	
	public UserNotFoundException(){
	     super("User not found");
	  }
}
