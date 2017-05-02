package com.bootcamp.Topic6.Exceptions;

/**
 * 
 * Exception thrown when a service are not found
 *
 */
public class UserAlreadyExistsException extends Exception{
	
	/**
	 * Serialized because the inheritance of a serialized class
	 */
	private static final long serialVersionUID = -6205651461177822920L;

	public UserAlreadyExistsException(){
	     super("User Already exists");
	  }
}
