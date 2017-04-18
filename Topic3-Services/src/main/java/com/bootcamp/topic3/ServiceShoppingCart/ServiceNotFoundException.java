package com.bootcamp.topic3.ServiceShoppingCart;

/**
 * 
 * Exception thrown when a service are not found
 *
 */
public class ServiceNotFoundException extends Exception{
	
	/**
	 * Serialized because the inheritance of a serialized class
	 */
	private static final long serialVersionUID = 1L;

	public ServiceNotFoundException(){
	     super("Service not found");
	  }
}
