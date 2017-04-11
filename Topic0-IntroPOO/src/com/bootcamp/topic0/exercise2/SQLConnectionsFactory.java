package com.bootcamp.topic0.exercise2;

import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection.ConnectionType;
import com.bootcamp.topic0.exercise1.DataBaseConnectionInterface;

/**
 * 
 * Abstract class for SQL data base's connections
 *
 */
public abstract class SQLConnectionsFactory {
	
	/**
	 * 
	 * @param type the name of the data base's connection will return
	 * 
	 * @return the data base's connection associated with the type	/ null otherwise
	 */
	public abstract DataBaseConnectionInterface getDataBaseConnection(ConnectionType type);
}
