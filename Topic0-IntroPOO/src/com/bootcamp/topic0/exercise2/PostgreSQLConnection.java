package com.bootcamp.topic0.exercise2;


import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection;
import com.bootcamp.topic0.exercise1.ConnectionType;

/**
 * 
 * Provides a connection to a PostgreSQL data base using singleton pattern
 * 
 */

public class PostgreSQLConnection  extends AbstractDataBaseConnection{
	private static PostgreSQLConnection dataBaseConnection;
	
	@Override
	protected void setType() {
		// TODO Auto-generated method stub
		type = ConnectionType.POSTGRE;
	}
	
	/**
	 * @return the reference to the unique dataBaseConnection instance
	 */
	public static PostgreSQLConnection getDataBaseConnection(){
		if (dataBaseConnection == null){
			dataBaseConnection = new PostgreSQLConnection();
		}
		return dataBaseConnection;
	}

}
