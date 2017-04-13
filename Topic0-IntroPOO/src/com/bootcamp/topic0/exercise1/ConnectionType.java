package com.bootcamp.topic0.exercise1;

public enum ConnectionType {
	SINGLETON("SingletonConnection"),
	MYSQL("MySQLConnection"), 
	POSTGRE("PostgreSQLConnection"), 
	ORACLE("OracleSQLConnection"),
	PROXYMYSQL("ProxyMySQLConnection"),
	MARIADB("MariaDBConnection"),
	MONGODB("MongoDBConnection");

	private String type;

	private ConnectionType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
