package com.bootcamp.topic0.exercise2;

import com.bootcamp.topic0.exercise1.ConnectionType;
import com.bootcamp.topic0.exercise1.DataBaseConnectionInterface;

/**
 * 
 * A factory for corporatives dataBase's connections
 *
 */
public class CorporativeDataBaseConnectionFactory extends SQLConnectionsFactory{
	
	public CorporativeDataBaseConnectionFactory(){
		this.type = FactoryType.CORPORATIVE;
	}
	
	@Override
	public DataBaseConnectionInterface getDataBaseConnection(ConnectionType type){
		if(ConnectionType.ORACLE.equals(type)){
			return OracleSQLConnection.getDataBaseConnection();
		}
		return null;
	}
}