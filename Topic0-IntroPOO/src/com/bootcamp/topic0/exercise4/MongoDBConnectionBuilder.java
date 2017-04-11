package com.bootcamp.topic0.exercise4;

/**
 * 
 * Builder for MongoDB data base's connection type
 *
 */
public class MongoDBConnectionBuilder implements DataBaseConnectionBuilder{
	
	private InstanceDataBaseConnection dataBaseConnection;
	
	/**
	 * Create an instance of a default data base's connection
	 */
	public MongoDBConnectionBuilder(){
		dataBaseConnection = new InstanceDataBaseConnection();
	}
	
	@Override
	public void buildType() {
		dataBaseConnection.setType("MongoDBConnection");
	}

	@Override
	public void buildConfig(String user, String password, String host) {
		dataBaseConnection.configure(user, password, host);
	}

	@Override
	public InstanceDataBaseConnection getDataBaseConnection() {
		return dataBaseConnection;
	}
}
