package com.bootcamp.topic0.exercise4;

import java.util.logging.Logger;

import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection;
import com.bootcamp.topic0.exercise1.DataBaseConnection;

/**
 * 
 * Instance of data base's connection
 *
 */
public class InstanceDataBaseConnection implements AbstractDataBaseConnection {

	private static Logger logger = Logger.getLogger(DataBaseConnection.class.getName());
	
	private String type;
	private String user;
	private String password;
	private String host;
	
	private boolean connectionState;
	
	/**
	 * 
	 * Create a default data base's connection
	 * 
	 */
	public InstanceDataBaseConnection(){
		this.type = "Default";
		this.user = "Default";
		this.password = "Default";
		this.host = "Defautl";
	}
	
	@Override
	public void configure(String user, String password, String host){
		this.user = user;
		this.password = password;
		this.host = host;
	}
	
	@Override
	public void connect() {
		if(!connectionState){
			connectionState = true;
			logger.info(toString() + "--> stablished connection \n");
		}
		else
			logger.info(toString() + "--> already connected \n");
	}

	@Override
	public void closeConnection() {
		if(connectionState){
			connectionState = false;
			logger.info(toString() + "--> closed connection \n");
		}
		else
			logger.info(toString() + "--> already disconnected \n");	
	}

	@Override
	public boolean getConnectionState() {
		return connectionState;
	}

	@Override
	public String toString() {
		return "DataBaseConnection [type=" + type + ", host=" + host + ", user=" + user + ", password=" + password + ", connectionState="
				+ connectionState + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser() {
		return user;
	}

	public String getPswd() {
		return password;
	}

	public String getHost() {
		return host;
	}
}
