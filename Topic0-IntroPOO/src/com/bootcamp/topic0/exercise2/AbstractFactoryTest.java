package com.bootcamp.topic0.exercise2;

import java.util.logging.Logger;

import org.junit.Test;

import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection;

/**
 * 
 * Unit test for Abstract Factory pattern
 * 
 */
public class AbstractFactoryTest {

	@Test
	public void test() {
		AbstractFactoryDataBaseConnection abstractFactory = new AbstractFactoryDataBaseConnection(); 
		
		SQLConnectionsFactory sqlConnectionsFactory = abstractFactory.getSQLConnectionsFactory("OpenSource");
		AbstractDataBaseConnection connection = sqlConnectionsFactory.getDataBaseConnection("MySQLConnection");
		connection.configure("user0", "pswd user0", "host user0");
		Logger.getAnonymousLogger().info(connection.toString()+ "\n");
		
		connection = sqlConnectionsFactory.getDataBaseConnection("PostgreSQLConnection");
		connection.configure("user1", "pswd user1", "host user1");
		Logger.getAnonymousLogger().info(connection.toString()+ "\n");
		
		sqlConnectionsFactory = abstractFactory.getSQLConnectionsFactory("Corporative");
		connection = sqlConnectionsFactory.getDataBaseConnection("OracleSQLConnection");
		connection.configure("user2", "pswd user2", "host user2");
		Logger.getAnonymousLogger().info(connection.toString()+ "\n");
		
		sqlConnectionsFactory = abstractFactory.getSQLConnectionsFactory("OpenSource");
		connection = sqlConnectionsFactory.getDataBaseConnection("MySQLConnection");
		connection.connect();
		Logger.getAnonymousLogger().info(connection.toString()+ "\n");
		
		connection = sqlConnectionsFactory.getDataBaseConnection("PostgreSQLConnection");
		connection.configure("user3", "pswd user3", "host user3");
		Logger.getAnonymousLogger().info(connection.toString()+ "\n");
	}
}
