package com.bootcamp.topic4;

/**
 * Interface for DataBaseConnections
 */
public interface DataBaseConnectionInterface {
	
	/**
	 * Opens the connection to the DataBase
	 */
	public void connect();
	
	/**
	 * Configures the connection parameters
	 * 
	 * @param dataBase name of the data base
	 * @param user  username for log into the data base
	 * @param password  the password of the user
	 * @param host  the url of the data base's host
	 */
	public void configure(String dataBase, String user, String password, String host);
	
	/**
	 * Closes the connection to the DataBase
	 */
	public void closeConnection();
	
	/**
	 * Returns the state of the connection to the DataBase
	 * 
	 * @return true if the connection is closed / false otherwise
	 */
	public boolean isClosed();
	
}
