package com.bootcamp.topic0.exercise4;

import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection;

/**
 * 
 * Instance of data base's connection
 *
 */

public class InstanceDataBaseConnection extends AbstractDataBaseConnection {

	@Override
	protected void setType() {
		// TODO Auto-generated method stub
	}
	
	public InstanceDataBaseConnection(){
		super();
	}
	
	public void setType(ConnectionType type){
		this.type = type;
	}
	
}
