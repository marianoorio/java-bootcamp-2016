package com.bootcamp.topic0.exercise4;

/**
 * 
 * Builder for MariaDB data base's connection type
 *
 */

public class MariaBDConnectionBuilder implements DataBaseConnectionBuilder{
	
	/**
	 * Create an instance of a default data base's connection
	 */
	private InstanceDataBaseConnection dataBaseConnection;
	
	public MariaBDConnectionBuilder(){
		dataBaseConnection = new InstanceDataBaseConnection();
	}
	
	@Override
	public void buildType() {
		dataBaseConnection.setType("MariaDBConnection");
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
