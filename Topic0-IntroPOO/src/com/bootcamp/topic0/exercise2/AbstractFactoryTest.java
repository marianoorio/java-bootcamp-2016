package com.bootcamp.topic0.exercise2;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.Assert;

import com.bootcamp.topic0.exercise1.ConnectionType;
import com.bootcamp.topic0.exercise1.DataBaseConnectionInterface;



/**
 * 
 * Unit test for Abstract Factory pattern
 * 
 */
public class AbstractFactoryTest {

	@Test
	public void test() {
		AbstractFactoryDataBaseConnection abstractFactory = new AbstractFactoryDataBaseConnection(); 
		
		SQLConnectionsFactory sqlConnectionsFactory = abstractFactory.getSQLConnectionsFactory(FactoryType.OPENSOURCE);
		DataBaseConnectionInterface connection = sqlConnectionsFactory.getDataBaseConnection(ConnectionType.MYSQL);
		connection.configure("user0", "pswd user0", "host user0");
		Logger.getAnonymousLogger().info(connection.toString());
		
		Assert.assertEquals(ConnectionType.MYSQL, connection.getType());
		
		connection = sqlConnectionsFactory.getDataBaseConnection(ConnectionType.POSTGRE);
		connection.configure("user1", "pswd user1", "host user1");
		Logger.getAnonymousLogger().info(connection.toString());
		
		Assert.assertEquals(ConnectionType.POSTGRE, connection.getType());
		
		sqlConnectionsFactory = abstractFactory.getSQLConnectionsFactory(FactoryType.CORPORATIVE);
		connection = sqlConnectionsFactory.getDataBaseConnection(ConnectionType.ORACLE);
		connection.configure("user2", "pswd user2", "host user2");
		Logger.getAnonymousLogger().info(connection.toString());
		
		Assert.assertEquals(FactoryType.CORPORATIVE, sqlConnectionsFactory.getType() );
		
		sqlConnectionsFactory = abstractFactory.getSQLConnectionsFactory(FactoryType.OPENSOURCE);
		connection = sqlConnectionsFactory.getDataBaseConnection(ConnectionType.MYSQL);
		connection.connect();
		Logger.getAnonymousLogger().info(connection.toString());
		
		connection = sqlConnectionsFactory.getDataBaseConnection(ConnectionType.POSTGRE);
		connection.configure("user3", "pswd user3", "host user3");
		Logger.getAnonymousLogger().info(connection.toString());
	}
}
