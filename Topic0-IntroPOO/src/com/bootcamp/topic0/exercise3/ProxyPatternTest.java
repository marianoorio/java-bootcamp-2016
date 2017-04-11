package com.bootcamp.topic0.exercise3;

import java.util.logging.Logger;

import org.junit.Test;

import com.bootcamp.topic0.exercise1.AbstractDataBaseConnection;
import com.bootcamp.topic0.exercise2.AbstractFactoryDataBaseConnection;
import com.bootcamp.topic0.exercise2.SQLConnectionsFactory;

public class ProxyPatternTest {

	@Test
	public void test() {
		
		AbstractFactoryDataBaseConnection abstractFactory = new AbstractFactoryDataBaseConnection();
		SQLConnectionsFactory sqlConnectionsFactory = abstractFactory.getSQLConnectionsFactory("OpenSource");
		AbstractDataBaseConnection connection = sqlConnectionsFactory.getDataBaseConnection("MySQLConnection");
		connection.configure("user0", "pswd user0", "host user0");
		Logger.getAnonymousLogger().info(connection.toString()+ "\n");
		connection.connect();
		
		connection = sqlConnectionsFactory.getDataBaseConnection("ProxyMySQLConnection");
		connection.configure("user1", "pswd user1", "host user1");
		connection.connect();
		connection.closeConnection();
		Logger.getAnonymousLogger().info("Connection: " + connection.toString() + " connection status: " + connection.getConnectionState());
	}

}
