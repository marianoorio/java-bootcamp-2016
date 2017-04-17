package com.bootcamp.topic3.ServiceUsers;

public class User {
	
	private String userName;
	private String password;
	private String name;
	private String eMail;
	
	public User(String userName, String password, String name, String eMail){
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.eMail = eMail;
	}

	public String getUserName() {
		return userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validPassword(String password){
		return (this.password == password)? true : false;
	}
}
