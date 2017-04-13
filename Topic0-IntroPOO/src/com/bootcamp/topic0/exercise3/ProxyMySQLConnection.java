package com.bootcamp.topic0.exercise3;

import java.util.logging.Logger;

import com.bootcamp.topic0.exercise1.ConnectionType;
import com.bootcamp.topic0.exercise1.DataBaseConnectionInterface;
import com.bootcamp.topic0.exercise2.MySQLConnection;

/**
 * 
 * Provides a proxy to the MySQL data base's connection
 * 
 */

public class ProxyMySQLConnection implements DataBaseConnectionInterface{
	
	private MySQLConnection realMySQLConnection = null;
	
	private ConnectionType type;
	
	private final String NO_PERMISION_MESSAGE = "You do not have permission to execute this action!";
	
	/**
	 * Create the proxy instance
	 */
	public ProxyMySQLConnection(){
		realMySQLConnection = MySQLConnection.getDataBaseConnection();
		type = ConnectionType.PROXYMYSQL;
	}
	
	@Override
	public void connect() {
		Logger.getAnonymousLogger().info(NO_PERMISION_MESSAGE);
	}

	@Override
	public void configure(String user, String password, String host) {
		Logger.getAnonymousLogger().info(NO_PERMISION_MESSAGE);
	}

	@Override
	public void closeConnection() {
		Logger.getAnonymousLogger().info(NO_PERMISION_MESSAGE);
	}

	@Override
	public boolean getConnectionState() {
		return realMySQLConnection.getConnectionState();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ProxyMySQLConnection ");
		sb.append("[");
		sb.append(realMySQLConnection.toString());
		sb.append("] ");
		return sb.toString();
	}

	@Override
	public ConnectionType getType() {
		return this.type;
	}
}
