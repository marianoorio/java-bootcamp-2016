package com.bootcamp.Topic6.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 * Data Class for User Entity
 *
 */
public class User {
	
	
	private String userName;
	private String password;
	private String name;
	private String eMail;
	
	
	@SuppressWarnings("unused")
	private User(){
		//Only for jackson mapping
	}
	
	public User(String userName, String password, String name, String eMail){
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.eMail = eMail;
	}
	
	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("eMail")
	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	@JsonIgnore
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Validates a password
	 * 
	 * @param password
	 * The password to match
	 * @return 
	 * true if the passwords matches /
	 *  false if not matches 
	 */
	public boolean validPassword(String password){
		return (this.password == password)? true : false;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (eMail == null) {
			if (other.eMail != null) {
				return false;
			}
		} else if (!eMail.equals(other.eMail)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		/*if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}*/
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userName=");
		builder.append(userName);
		/*builder.append(", password=");
		builder.append(password);*/
		builder.append(", name=");
		builder.append(name);
		builder.append(", eMail=");
		builder.append(eMail);
		builder.append("]");
		return builder.toString();
	}
	
	
}
	
	
