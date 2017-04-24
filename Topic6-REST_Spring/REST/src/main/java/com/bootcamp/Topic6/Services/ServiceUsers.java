package com.bootcamp.Topic6.Services;

import java.util.List;

import com.bootcamp.Topic6.Entities.User;
import com.bootcamp.Topic6.Exceptions.UserAlreadyExistsException;
import com.bootcamp.Topic6.Exceptions.UserNotFoundException;

/**
 * 
 * Interface for User Services
 * Provides CRUD Operations 
 * 
 */
public interface ServiceUsers {
	
	/**
	 *  Creates a new user into the service
	 *  
	 * @param user 
	 * The user to be created
	 * @throws UserAlreadyExistsException
	 * If the userName alreadyExists
	 */
	public void createUser(User user)throws UserAlreadyExistsException;
	
	/**
	 * Obtains an existent user by its identifier field
	 * 
	 * @param userName
	 * The User identifier field for request the user to get
	 * @return
	 * The user requested if it exists
	 * @throws UserNotFoundException
	 * If the user is not found
	 */
	public User readUser(String userName) throws UserNotFoundException;
	
	/**
	 * Updates an existent user
	 * Usually it is an user obtained previously with some fields modified
	 * 
	 * @param user
	 * The user to be updated
	 * @throws UserNotFoundException
	 * If the user is not found
	 */
	public void updateUser(User user) throws UserNotFoundException;
	
	/**
	 * Deletes an existent user by its identifier field
	 * 
	 * @param userId
	 * The User identifier field for request the delete of the user
	 * @throws UserNotFoundException
	 * If the user is not found
	 */
	public void deleteUser(String userId) throws UserNotFoundException;
	
	/**
	 * Obtains a list of users that shares the name requested
	 * 
	 * @param name
	 * The shared name by users which are want to get
	 * @return
	 * The list of users that shares the name requested
	 * @throws UserNotFoundException
	 * If no one user have the name requested
	 */
	public List<User> readUsersByName(String name) throws UserNotFoundException;
	
	/**
	 * Obtains the number of existents users
	 * 
	 * @return
	 * the size of the users container
	 */
	public int size();
}
