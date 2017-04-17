package com.bootcamp.topic3.ServiceShoppingCart;

/**
 * 
 * enum for types of shopping cart services
 *
 */

public enum ServiceShoppingCartTypes {
	LOCAL_SERVICE("localService");

	private String type;

	private ServiceShoppingCartTypes(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
