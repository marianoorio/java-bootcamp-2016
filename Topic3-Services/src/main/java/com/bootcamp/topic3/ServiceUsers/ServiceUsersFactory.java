package com.bootcamp.topic3.ServiceUsers;

import com.bootcamp.topic3.ServiceShoppingCart.ServiceNotFoundException;

/**
 * 
 * Factory for users services
 *
 */
public class ServiceUsersFactory {
	
	private ServiceUsersFactory(){};
	
	/**
	 * 
	 * @param type of service
	 * @return the user service requested
	 * @throws ServiceNotFoundException
	 */
	public static ServiceUsers getShoppingCartService(ServiceUsersTypes type) throws ServiceNotFoundException {
		if (ServiceUsersTypes.LOCAL_SERVICE.equals(type)) {
			return new ServiceUsersImplementation();
		}
		throw new ServiceNotFoundException();
	}
}
