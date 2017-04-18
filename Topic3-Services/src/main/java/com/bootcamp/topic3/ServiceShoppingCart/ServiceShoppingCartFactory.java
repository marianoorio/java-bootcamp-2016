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
	 * @return the shopping cart service requested
	 * @throws ServiceNotFoundException 
	 */
	public static ServiceShoppingCart getShoppingCartService(ServiceShoppingCartTypes type) throws ServiceNotFoundException {
		if (ServiceShoppingCartTypes.LOCAL_SERVICE.equals(type)) {
			return new ServiceShoppingCartImplementation();
		}
		throw new ServiceNotFoundException();
	}
}
