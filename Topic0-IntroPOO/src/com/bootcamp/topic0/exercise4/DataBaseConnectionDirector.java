package com.bootcamp.topic0.exercise4;

/**
 * 
 * Provides a director for data base's connection builders
 *
 */
public class DataBaseConnectionDirector {
	
	private DataBaseConnectionBuilder dataBaseConnectionBuilder = null;
	
	/**
	 * Create the director of data base's connection builders
	 * 
	 * @param dataBaseConnectionBuilder  type of builder to construct the data base's connection
	 */
	public DataBaseConnectionDirector(DataBaseConnectionBuilder dataBaseConnectionBuilder){
		this.dataBaseConnectionBuilder = dataBaseConnectionBuilder;
	}
	
	/**
	 * Construct the data base's connection
	 * 
	 * @param user  username for log into the data base
	 * @param password  the password of the user
	 * @param host  the url of the data base's host
	 * 
	 */
	public void constructDataBaseConnection(String user, String password, String host){
		dataBaseConnectionBuilder.buildType();
		dataBaseConnectionBuilder.buildConfig(user, password, host);
	}
	
	/**
	 * 
	 * @return the data base's connection constructed
	 */
	public InstanceDataBaseConnection getDataBaseConnection(){
		return dataBaseConnectionBuilder.getDataBaseConnection();
	}
}
