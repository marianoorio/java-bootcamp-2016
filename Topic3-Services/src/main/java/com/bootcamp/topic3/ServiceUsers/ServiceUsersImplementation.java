package com.bootcamp.topic3.ServiceUsers;

import java.util.Hashtable;
import java.util.Map;

/**
 * 
 * Implementation for ServiceUsers Interface
 *
 */
public class ServiceUsersImplementation implements ServiceUsers {
	
	private Map<String, User> users;
	
	public ServiceUsersImplementation(){
		users = new Hashtable<String, User>();
	}
	
	@Override
	public boolean createUser(User user) {
		boolean created = false;
		if (user != null && !users.containsKey(user.getUserName())){
			users.put(user.getUserName(), user);
			created = true;
		}
		return created;
	}

	@Override
	public User readUser(String userId) {
		User userReturn = null;
		if (userId != null && users.containsKey(userId)){
			userReturn = users.get(userId);
		}
		return userReturn;
	}

	@Override
	public boolean updateUser(User user) {
		boolean updated = false;
		if (user != null && users.containsKey(user.getUserName())){
			users.put(user.getUserName(), user);
			updated =true;
		}
		return updated;
	}

	@Override
	public boolean deleteUser(String userId) {
		boolean deleted = false;
		if (userId != null && users.containsKey(userId)){
			users.remove(userId);
			deleted = true;
		}
		return deleted;
	}
}
