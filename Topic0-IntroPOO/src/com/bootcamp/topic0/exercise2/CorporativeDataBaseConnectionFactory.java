package com.bootcamp.topic0.exercise2;

import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection;

/**
 * 
 * A factory for corporatives dataBase's connections
 *
 */
public class CorporativeDataBaseConnectionFactory extends SQLConnectionsFactory{
	
	@Override
	public AbstractDataBaseConnection getDataBaseConnection(String type){
		if("OracleSQLConnection".equals(type))
			return OracleSQLConnection.getDataBaseConnection();
		return null;
	}
}
