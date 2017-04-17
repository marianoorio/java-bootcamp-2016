package com.bootcamp.topic3.ServiceUsers;

/**
 * 
 * Interface for users services
 * CRUD Operations
 *
 */

public interface ServiceUsers {
	/**
	 * 
	 * @param user to create
	 * @return true if its created / false otherwise
	 */
	public boolean createUser(User user);
	
	/**
	 * 
	 * @param userId
	 * @return null if the user not exists or its null/ the user associated to the userId
	 */
	public User readUser(String userId);
	
	/**
	 * 
	 * @param user to update
	 * @return true if updates the user success / false otherwise
	 */
	public boolean updateUser(User user);
	
	/**
	 * 
	 * @param userId to delete
	 * @return true if the user deletes success / false otherwise
	 */
	public boolean deleteUser(String userId);
}
