package globant.javabootcamp.finalproject.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 
 * Data Class for User Entity
 *
 */
@ApiModel(value = "Account entity", description = "Data class for user's accounts")
@Entity
@Table(name = "account")
public class Account {
	
	@ApiModelProperty(value = "Account's id", required = true)
	@Column(name = "id")
	@Id
	@GeneratedValue
	private Long id;
	
	@ApiModelProperty(value = "Account's username", required = true)
	@Column(name = "username")
	@NotNull
	private String username;
	
	@ApiModelProperty(value = "Account's password", required = true)
	@Column(name = "password")
	@NotNull
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@ApiModelProperty(value = "Account's owner name", required = true)
	@Column(name = "name")
	@NotNull
	private String name;
	
	@ApiModelProperty(value = "Account's owner email", required = true)
	@Column(name = "email")
	@NotNull
	private String email;
	
	@ApiModelProperty(value = "Account's lock state", required = true)
	@Column(name = "locked")
	@NotNull
	private boolean locked;
	
	@SuppressWarnings("unused")
	private Account(){
	}
	
	public Account(String username, String password, String name, String email){
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.locked = false;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getemail() {
		return email;
	}

	public void setemail(String eMail) {
		this.email = eMail;
	}
	
	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
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
		return (this.password.equals(password));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Account other = (Account) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}	
}
	
	
