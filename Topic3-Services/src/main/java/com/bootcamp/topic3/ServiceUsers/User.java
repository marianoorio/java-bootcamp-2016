package com.bootcamp.topic3.ServiceUsers;

/**
 * 
 * Data Class for users
 *
 */
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
	
	/**
	 * Validates a password
	 * 
	 * @param password
	 * @return true if the passwords matches / false if not matches 
	 */
	public boolean validPassword(String password){
		return (this.password == password)? true : false;
	}

	
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
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}
}
