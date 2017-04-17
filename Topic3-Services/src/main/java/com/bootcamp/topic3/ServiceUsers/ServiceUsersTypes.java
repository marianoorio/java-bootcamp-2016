package com.bootcamp.topic3.ServiceUsers;

public enum ServiceUsersTypes {
	LOCAL_SERVICE("localService");

	private String type;

	private ServiceUsersTypes(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
