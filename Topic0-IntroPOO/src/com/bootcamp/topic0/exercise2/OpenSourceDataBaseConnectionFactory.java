package com.bootcamp.topic0.exercise2;

import com.bootcamp.topic0.exercise1.ConnectionType;
import com.bootcamp.topic0.exercise1.DataBaseConnectionInterface;
import com.bootcamp.topic0.exercise3.ProxyMySQLConnection;

/**
 * 
 *  A factory for open source dataBase's connections
 *
 */

public class OpenSourceDataBaseConnectionFactory extends SQLConnectionsFactory{
	
	public OpenSourceDataBaseConnectionFactory(){
		this.type = FactoryType.OPENSOURCE;
	}
	
	@Override
	public DataBaseConnectionInterface getDataBaseConnection(ConnectionType type){
		if(ConnectionType.MYSQL.equals(type)){
			return MySQLConnection.getDataBaseConnection();
		}
		else if (ConnectionType.PROXYMYSQL.equals(type)){
			return new ProxyMySQLConnection();
		}
		else if (ConnectionType.POSTGRE.equals(type)){
			return PostgreSQLConnection.getDataBaseConnection();
		}
		return null;
	}
}
