package com.bootcamp.topic3.ServiceUsers;

/**
 * 
 * Factory for users services
 *
 */
public class ServiceUsersFactory {
	
	private ServiceUsersFactory(){};
	
	public static ServiceUsers getShoppingCartService(ServiceUsersTypes type) {
		if (ServiceUsersTypes.LOCAL_SERVICE.equals(type)) {
			return new ServiceUsersImplementation();
		}
		return null;
	}
}
