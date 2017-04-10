package com.bootcamp.topic0.exercise2;

import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection;
import com.bootcamp.topic0.exercise3.ProxyMySQLConnection;

/**
 * 
 *  A factory for open source dataBase's connections
 *
 */

public class OpenSourceDataBaseConnectionFactory extends SQLConnectionsFactory{
	
	@Override
	public AbstractDataBaseConnection getDataBaseConnection(String type){
		if("MySQLConnection".equals(type))
			return MySQLConnection.getDataBaseConnection();
		else if ("ProxyMySQLConnection".equals(type))
			return new ProxyMySQLConnection();
		else if ("PostgreSQLConnection".equals(type))
			return PostgreSQLConnection.getDataBaseConnection();
		return null;
	}
}
