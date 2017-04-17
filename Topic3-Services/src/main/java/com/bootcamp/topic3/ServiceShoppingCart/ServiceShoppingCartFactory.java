package com.bootcamp.topic3.ServiceShoppingCart;


/**
 * 
 * Factory of shopping cart service
 *
 */
public class ServiceShoppingCartFactory {
	
	private ServiceShoppingCartFactory(){};
	
	/**
	 * 
	 * @param type of service
	 * @return a service of shopping cart
	 */
	public static ServiceShoppingCart getShoppingCartService(ServiceShoppingCartTypes type) {
		if (ServiceShoppingCartTypes.LOCAL_SERVICE.equals(type)) {
			return new ServiceShoppingCartImplementation();
		}
		return null;
	}
}
