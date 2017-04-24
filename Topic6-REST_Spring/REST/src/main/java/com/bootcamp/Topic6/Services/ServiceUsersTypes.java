package com.bootcamp.Topic6.Services;

/**
 * 
 * Enum for the types of Users Services
 *
 */
public enum ServiceUsersTypes {
	LOCAL_SERVICE("localService"),
	PERSISTENT_SERVICE("persistentService");
	
	private String type;

	private ServiceUsersTypes(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
