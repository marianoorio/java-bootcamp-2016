package com.bootcamp.topic0.exercise2;

import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection.ConnectionType;
import com.bootcamp.topic0.exercise1.DataBaseConnectionInterface;
import com.bootcamp.topic0.exercise3.ProxyMySQLConnection;

/**
 * 
 *  A factory for open source dataBase's connections
 *
 */

public class OpenSourceDataBaseConnectionFactory extends SQLConnectionsFactory{
	
	@Override
	public DataBaseConnectionInterface getDataBaseConnection(ConnectionType type){
		if("MySQLConnection".equals(type.getType())){
			return MySQLConnection.getDataBaseConnection();
		}
		else if ("ProxyMySQLConnection".equals(type.getType())){
			return new ProxyMySQLConnection();
		}
		else if ("PostgreSQLConnection".equals(type.getType())){
			return PostgreSQLConnection.getDataBaseConnection();
		}
		return null;
	}
}
