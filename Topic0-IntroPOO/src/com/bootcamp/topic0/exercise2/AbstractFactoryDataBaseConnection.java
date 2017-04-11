package com.bootcamp.topic0.exercise2;

/**
 * 
 * Class for data base's connections factories
 *
 */

public class AbstractFactoryDataBaseConnection {
	
	public enum  FactoryType {
		
		OPENSOURCE("OpenSource"),
		CORPORATIVE("Corporative");

		private String type;

		private FactoryType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}
	
	/**
	 * 
	 * @param type the name of the factory will return
	 * 
	 * @return the factory associated with the type	/ null otherwise
	 */
	public SQLConnectionsFactory getSQLConnectionsFactory(FactoryType type){
		if("Corporative".equals(type.getType())){
			return new CorporativeDataBaseConnectionFactory();
		}
		else if("OpenSource".equals(type.getType())){
			return new OpenSourceDataBaseConnectionFactory();
		}
		return null;
	}
}