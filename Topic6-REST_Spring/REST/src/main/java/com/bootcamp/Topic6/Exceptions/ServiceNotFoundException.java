package com.bootcamp.Topic6.Exceptions;

/**
 * 
 * Exception thrown when a service are not found
 *
 */
public class ServiceNotFoundException extends Exception{
	
	/**
	 * Serialized because the inheritance of a serialized class
	 */
	private static final long serialVersionUID = 4245475138863526180L;

	public ServiceNotFoundException(){
	     super("Service not found");
	  }
}
