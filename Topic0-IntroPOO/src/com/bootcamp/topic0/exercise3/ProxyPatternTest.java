package com.bootcamp.topic0.exercise3;

import java.util.logging.Logger;

import org.junit.Test;

import com.bootcamp.topic0.exercise1.ConnectionType;
import com.bootcamp.topic0.exercise1.DataBaseConnectionInterface;
import com.bootcamp.topic0.exercise2.AbstractFactoryDataBaseConnection;
import com.bootcamp.topic0.exercise2.FactoryType;
import com.bootcamp.topic0.exercise2.SQLConnectionsFactory;

import org.junit.Assert;

public class ProxyPatternTest {

	@Test
	public void test() {
		
		AbstractFactoryDataBaseConnection abstractFactory = new AbstractFactoryDataBaseConnection();
		SQLConnectionsFactory sqlConnectionsFactory = abstractFactory.getSQLConnectionsFactory(FactoryType.OPENSOURCE);
		DataBaseConnectionInterface connection = sqlConnectionsFactory.getDataBaseConnection(ConnectionType.PROXYMYSQL);
		connection.configure("user1", "pswd user1", "host user1");
		connection.connect();
		connection.closeConnection();
		Logger.getAnonymousLogger().info("Connection: " + connection.toString() + " connection status: " + connection.getConnectionState());
	
		Assert.assertFalse(connection.getConnectionState());
	}

}
