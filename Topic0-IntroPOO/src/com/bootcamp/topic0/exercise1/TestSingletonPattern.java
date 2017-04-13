package com.bootcamp.topic0.exercise1;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Unit test for Singleton pattern
 * 
 */

public class TestSingletonPattern {

	@Test
	public void test() {
		
		DataBaseConnection dataBase0 = DataBaseConnection.getDataBaseConnection();
		dataBase0.configure("Jonh", "p4S$Word", "localhost8080");
		dataBase0.closeConnection();
		dataBase0.connect();
		
		Assert.assertEquals(ConnectionType.SINGLETON, dataBase0.getType());
		
		DataBaseConnection dataBase1 = DataBaseConnection.getDataBaseConnection();
		dataBase1.connect();
		Logger.getAnonymousLogger().info(dataBase1.toString() + "DataBase connected= " + dataBase1.getConnectionState());
		dataBase1.closeConnection();
		
		Assert.assertEquals("p4S$Word", dataBase1.getPassword());
		
	}

}
