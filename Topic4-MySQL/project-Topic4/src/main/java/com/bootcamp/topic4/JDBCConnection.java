package com.bootcamp.topic4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * 
 * Provides an connection to mySQL database using JDBC
 *
 */
public class JDBCConnection implements DataBaseConnectionInterface{
	
	private static JDBCConnection instanceConnection= null;
	
	private Connection connection = null;
	
	private String host = "localhost:3306";
	private String dataBase = "high_school";
	private String user = "root";
	private String password = "12345";
	
	/**
	 * Private constructor for apply singleton pattern
	 */
	private JDBCConnection(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			Logger.getAnonymousLogger().severe(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return singleton instance
	 */
	public static JDBCConnection getInstance(){
		if(instanceConnection == null){
			instanceConnection = new JDBCConnection();
		}
		instanceConnection.connect();
		return instanceConnection;
	}
	
	/**
	 * 
	 * @return the Connection to dataBase
	 */
	public Connection getConnection(){
		return this.connection;
	}
	
	@Override
	public void connect() {
		if (connection==null || this.isClosed()){
			StringBuilder sb = new StringBuilder("jdbc:mysql://");
			sb.append(host);
			sb.append("/");
			sb.append(dataBase);
			try {
				connection = DriverManager.getConnection(sb.toString(), user, password);
			}catch(SQLException e){
				Logger.getAnonymousLogger().severe(e.getMessage());
			}
		}
		
	}

	@Override
	public void configure(String dataBase, String user, String password, String host) {
		this.user = user;
		this.password = password;
		this.host = host;
		this.dataBase = dataBase;
		
	}

	@Override
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			Logger.getAnonymousLogger().severe(e.getMessage());
		}
	}

	@Override
	public boolean isClosed() {
		boolean retValue = true;
		try {
			retValue = connection.isClosed();
		} catch (SQLException e) {
			Logger.getAnonymousLogger().severe(e.getMessage());
		}
		return retValue;
	}
	

}
