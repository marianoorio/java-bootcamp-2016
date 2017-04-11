package com.bootcamp.topic0.exercise1;

import java.util.logging.Logger;

/**
 * 
 * Provides a connection to a data base using singleton pattern
 * 
 */
public class DataBaseConnection implements AbstractDataBaseConnection {
	
	private static Logger logger = Logger.getLogger(DataBaseConnection.class.getName());
	
	private static DataBaseConnection dataBaseConnection;
	
	private String type;
	private String host;
	private String user;
	private String password;
	private boolean connectionState;
	
	/**
	 * Create the instance
	 * private for apply singleton pattern
	 * 
	 */
	private DataBaseConnection(){
		type = "SingletonDataBaseConnection";
		connectionState = false;
	}
	
	/**
	 * @return the reference to the unique dataBaseConnection instance
	 */
	public static DataBaseConnection getDataBaseConnection(){
		if (dataBaseConnection == null)
			dataBaseConnection = new DataBaseConnection();
		return dataBaseConnection;
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
	
}
