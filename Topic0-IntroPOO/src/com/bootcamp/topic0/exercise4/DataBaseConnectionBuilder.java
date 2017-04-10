package com.bootcamp.topic0.exercise4;


public interface DataBaseConnectionBuilder {
	
	/**
	 * builds the type of the data base's connection
	 */
	public void buildType();
	
	/**
	 * builds the configuration of the data base's connection
	 * 
	 * @param user  username for log into the data base
	 * @param password  the password of the user
	 * @param host  the url of the data base's host
	 */
	public void buildConfig(String user, String password, String host);
	
	/**
	 * 
	 * @return the instance of a data base's connection
	 */
	public InstanceDataBaseConnection getDataBaseConnection();
}
