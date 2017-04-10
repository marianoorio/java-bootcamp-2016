package com.bootcamp.topic0.exercise2;

import java.util.logging.Logger;

import com.bootcamp.topic0.exercise1.*;

/**
 * 
 * Provides a connection to a MySQL data base using singleton pattern
 * 
 */

public class MySQLConnection implements AbstractDataBaseConnection{

	private static Logger logger = Logger.getLogger(MySQLConnection.class.getName());
	
	private static MySQLConnection dataBaseConnection;
	
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
	private MySQLConnection(){
		type = "MySQLConnection";
		connectionState = false;
	}
	
	/**
	 * @return the reference to the unique dataBaseConnection instance
	 */
	public static MySQLConnection getDataBaseConnection(){
		if (dataBaseConnection == null)
			dataBaseConnection = new MySQLConnection();
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
			logger.info(toString() + "--> stablished connection");
		}
		else
			logger.info(toString() + "--> already connected");
	}

	@Override
	public void closeConnection() {
		if(connectionState){
			connectionState = false;
			logger.info(toString() + "--> closed connection");
		}
		else
			logger.info(toString() + "--> already disconnected");	
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
