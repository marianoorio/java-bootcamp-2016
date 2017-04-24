package com.bootcamp.Topic6.Services;

import com.bootcamp.Topic6.Exceptions.ServiceNotFoundException;

/**
 * 
 * Implements a Factory for User Services
 *
 */
public class ServiceUsersFactory {
	
	private ServiceUsersFactory(){};
	
	/**
	 * Obtains the user service requested
	 * 
	 * @param type 
	 * The type of service requested
	 * @return 
	 * The User Service requested
	 * @throws ServiceNotFoundException
	 * If not exists the User Service requested
	 */
	public static ServiceUsers getUserService(ServiceUsersTypes type) throws ServiceNotFoundException {
		if (ServiceUsersTypes.LOCAL_SERVICE.equals(type)) {
			return LocalUserService.getService();
		}
		throw new ServiceNotFoundException();
	}
}
