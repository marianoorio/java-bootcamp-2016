package com.bootcamp.topic0.exercise3;

import java.util.logging.Logger;

import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection;
import com.bootcamp.topic0.exercise2.MySQLConnection;

/**
 * 
 * Provides a proxy to the MySQL data base's connection
 * 
 */

public class ProxyMySQLConnection implements AbstractDataBaseConnection{
	
	private MySQLConnection realMySQLConnection = null;
	
	
	/**
	 * Create the proxy instance
	 */
	public ProxyMySQLConnection(){
		realMySQLConnection = MySQLConnection.getDataBaseConnection();
	}
	
	@Override
	public void connect() {
		Logger.getAnonymousLogger().info("You do not have permission to execute this action! \n");
	}

	@Override
	public void configure(String user, String password, String host) {
		Logger.getAnonymousLogger().info("You do not have permission to execute this action! \n");
	}

	@Override
	public void closeConnection() {
		Logger.getAnonymousLogger().info("You do not have permission to execute this action! \n");
	}

	@Override
	public boolean getConnectionState() {
		return realMySQLConnection.getConnectionState();
	}

	@Override
	public String toString() {
		return "ProxyMySQLConnection [realMySQLConnection=" + realMySQLConnection + "]";
	}
}
