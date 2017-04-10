package com.bootcamp.topic0.exercise4;

import java.util.logging.Logger;

import org.junit.Test;

/**
 * 
 * Unit test for Builder pattern
 * 
 */
public class BuilderPatternTest {

	@Test
	public void test() {
		DataBaseConnectionBuilder dataBaseConnectionBuilder = new MariaBDConnectionBuilder();
		DataBaseConnectionDirector dataBaseConnectionDirector = new DataBaseConnectionDirector(dataBaseConnectionBuilder);
		dataBaseConnectionDirector.constructDataBaseConnection("Mariano", "12345", "localhost");
		InstanceDataBaseConnection dataBaseConnection = dataBaseConnectionDirector.getDataBaseConnection();
		Logger.getAnonymousLogger().info(dataBaseConnection.toString());
		
		dataBaseConnectionBuilder = new MongoDBConnectionBuilder();
		dataBaseConnectionDirector = new DataBaseConnectionDirector(dataBaseConnectionBuilder);
		dataBaseConnectionDirector.constructDataBaseConnection("Jonh", "95882", "192.000.0.1");
		dataBaseConnection = dataBaseConnectionDirector.getDataBaseConnection();
		Logger.getAnonymousLogger().info(dataBaseConnection.toString());
	}

}
