package com.bootcamp.topic0.exercise2;

public enum FactoryType {
	OPENSOURCE("OpenSource"),
	CORPORATIVE("Corporative");

	private String type;

	private FactoryType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
