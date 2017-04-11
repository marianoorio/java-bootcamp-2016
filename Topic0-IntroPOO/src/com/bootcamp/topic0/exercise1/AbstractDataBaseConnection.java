package com.bootcamp.topic0.exercise1;

import java.util.logging.Logger;

/**
 * 
 * Abstracts class for implements the concretes data base's connections
 *
 */
public abstract class AbstractDataBaseConnection implements DataBaseConnectionInterface{
	private static Logger logger = Logger.getLogger(DataBaseConnection.class.getName());
	
	public enum  ConnectionType {
		
		SINGLETON("SingletonConnection"),
		MYSQL("MySQLConnection"), 
		POSTGRE("PostgreSQLConnection"), 
		ORACLE("OracleSQLConnection"),
		PROXYMYSQL("ProxyMySQLConnection"),
		MARIADB("MariaDBConnection"),
		MONGODB("MongoDBConnection");

		private String type;

		private ConnectionType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}
	
	protected ConnectionType type;
	protected String host;
	protected String user;
	protected String password;
	protected boolean connectionState;
	
	
	/**
	 * Create the instance
	 * private for apply singleton pattern
	 * 
	 */
	protected AbstractDataBaseConnection(){
		setType();
		connectionState = false;
	}
	
	/**
	 * abstract method 
	 */
	protected abstract void setType();
	
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
		StringBuilder sb = new StringBuilder("DataBaseConnection ");
		sb.append("[");
		sb.append("type= ");sb.append(type.getType());
		sb.append(" host= ");sb.append(host);
		sb.append(" user= ");sb.append(user);
		sb.append(" password= ");sb.append(password);
		sb.append(" connectionState= ");sb.append(connectionState);
		sb.append("] ");
		return sb.toString();
	}
	
}
