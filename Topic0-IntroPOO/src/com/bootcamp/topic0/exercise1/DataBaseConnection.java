package com.bootcamp.topic0.exercise1;

/**
 * 
 * Provides a connection to a data base using singleton pattern
 * 
 */
public class DataBaseConnection extends AbstractDataBaseConnection {
	
	private static DataBaseConnection dataBaseConnection;
	
	@Override
	protected void setType() {
		// TODO Auto-generated method stub
		type = ConnectionType.SINGLETON;
		
	}
	
	/**
	 * @return the reference to the unique dataBaseConnection instance
	 */
	public static DataBaseConnection getDataBaseConnection(){
		if (dataBaseConnection == null){
			dataBaseConnection = new DataBaseConnection();
		}
		return dataBaseConnection;
	}
	
}
