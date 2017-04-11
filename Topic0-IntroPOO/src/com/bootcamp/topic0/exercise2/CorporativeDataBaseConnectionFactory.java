package com.bootcamp.topic0.exercise2;

import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection.ConnectionType;
import com.bootcamp.topic0.exercise1.DataBaseConnectionInterface;

/**
 * 
 * A factory for corporatives dataBase's connections
 *
 */
public class CorporativeDataBaseConnectionFactory extends SQLConnectionsFactory{
	
	@Override
	public DataBaseConnectionInterface getDataBaseConnection(ConnectionType type){
		if("OracleSQLConnection".equals(type.getType())){
			return OracleSQLConnection.getDataBaseConnection();
		}
		return null;
	}
}
