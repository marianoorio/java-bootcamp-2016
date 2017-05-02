package com.bootcamp.Topic6.Services;

import com.bootcamp.Topic6.Entities.User;
import com.bootcamp.Topic6.Exceptions.UserAlreadyExistsException;
import com.bootcamp.Topic6.Exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 
 * Implementation for ServiceUsers Interface
 * It's a local service allocated in memory
 * It stores the users in a Hashtable with String key and User value
 * 
 *
 *
 */
@Service
public class UserServiceImp implements UserService {
	
	private Map<String, User> users = new Hashtable<>();
	
	
	@Override
	public int size(){
		return users.size();
	}
	@Override
	public void create(User user) throws UserAlreadyExistsException {
		if (user != null && !users.containsKey(user.getUserName())){
			users.put(user.getUserName(), user);
		}else{
			throw new UserAlreadyExistsException();
		}
	}

	@Override
	public User read(String userId) throws UserNotFoundException{
		User userReturn = null;
		if (userId != null && users.containsKey(userId)){
			userReturn = users.get(userId);
		}else{
			throw new UserNotFoundException();
		}
		return userReturn;
	}

	@Override
	public void update(User user) throws UserNotFoundException{
		if (user != null && users.containsKey(user.getUserName())){
			users.put(user.getUserName(), user);
		}else{
			throw new UserNotFoundException();
		}
	}

	@Override
	public void delete(String userId) throws UserNotFoundException{
		if (userId != null && users.containsKey(userId)){
			users.remove(userId);
		}else{
			throw new UserNotFoundException();
		}
	}

	@Override
	public List<User> readByName(String name) throws UserNotFoundException {
		List<User> returnUsers = new ArrayList<User>();
		Iterator<String> it = users.keySet().iterator();
		while(it.hasNext()){
			User user = users.get(it.next());
			if(user.getName().equals(name)){
				returnUsers.add(0,user);
			}
		}
		if(returnUsers.isEmpty()){
			throw new UserNotFoundException();
		}
		return returnUsers;
	}
	@Override
	public void clearContents() {
		users.clear();
	}
}
