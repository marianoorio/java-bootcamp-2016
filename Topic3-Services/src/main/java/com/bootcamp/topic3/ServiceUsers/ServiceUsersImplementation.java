package com.bootcamp.topic3.ServiceUsers;

import java.util.Hashtable;
import java.util.Map;


public class ServiceUsersImplementation implements ServiceUsers {
	
	private Map<String, User> users;
	
	public ServiceUsersImplementation(){
		users = new Hashtable<String, User>();
	}
	
	@Override
	public boolean createUser(User user) {
		if(user == null || users.containsKey(user.getUserName())){
			return false;
		}else{
			users.put(user.getUserName(), user);
			return true;
		}
	}

	@Override
	public User readUser(String userId) {
		if (userId == null || !users.containsKey(userId)){
			return null;
		}else{
			return users.get(userId);
		}
	}

	@Override
	public boolean updateUser(User user) {
		if (user == null || !users.containsKey(user.getUserName())){
			return false;
		}else{
			users.put(user.getUserName(), user);
			return true;
		}
	}

	@Override
	public boolean deleteUser(String userId) {
		if (userId == null || !users.containsKey(userId)){
			return false;
		}else{
			users.remove(userId);
			return true;
		}
	}

}
