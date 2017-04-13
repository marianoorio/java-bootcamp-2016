package com.bootcamp.topic0.exercise2;

/**
 * 
 * Class for data base's connections factories
 *
 */

public class AbstractFactoryDataBaseConnection {
	
	
	
	/**
	 * 
	 * @param type the name of the factory will return
	 * 
	 * @return the factory associated with the type	/ null otherwise
	 */
	public SQLConnectionsFactory getSQLConnectionsFactory(FactoryType type){
		if(FactoryType.CORPORATIVE.equals(type)){
			return new CorporativeDataBaseConnectionFactory();
		}
		else if(FactoryType.OPENSOURCE.equals(type)){
			return new OpenSourceDataBaseConnectionFactory();
		}
		return null;
	}
}
