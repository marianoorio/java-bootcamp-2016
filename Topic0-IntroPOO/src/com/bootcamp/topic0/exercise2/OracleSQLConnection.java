package com.bootcamp.topic0.exercise2;

import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection;

/**
 * 
 * Provides a connection to a OracleSQL data base using singleton pattern
 * 
 */

public class OracleSQLConnection extends AbstractDataBaseConnection{
	private static OracleSQLConnection dataBaseConnection;
	
	@Override
	protected void setType() {
		// TODO Auto-generated method stub
		type = ConnectionType.ORACLE;
		
	}
	
	/**
	 * @return the reference to the unique dataBaseConnection instance
	 */
	public static OracleSQLConnection getDataBaseConnection(){
		if (dataBaseConnection == null){
			dataBaseConnection = new OracleSQLConnection();
		}
		return dataBaseConnection;
	}

}
