package com.bootcamp.topic0.exercise2;

import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection;

/**
 * 
 * Provides a connection to a MySQL data base using singleton pattern
 * 
 */

public class MySQLConnection extends AbstractDataBaseConnection{

	private static MySQLConnection dataBaseConnection;
	
	@Override
	protected void setType() {
		// TODO Auto-generated method stub
		type = ConnectionType.MYSQL;
		
	}
	
	/**
	 * @return the reference to the unique dataBaseConnection instance
	 */
	public static MySQLConnection getDataBaseConnection(){
		if (dataBaseConnection == null){
			dataBaseConnection = new MySQLConnection();
		}
		return dataBaseConnection;
	}
}
