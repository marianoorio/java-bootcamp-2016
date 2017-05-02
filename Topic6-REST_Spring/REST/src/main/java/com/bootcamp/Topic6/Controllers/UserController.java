package com.bootcamp.Topic6.Controllers;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bootcamp.Topic6.Entities.User;

public interface UserController {
	
	/**
	 * Creates a new user on the local service
	 * 
	 * @param userRequest
	 * The new user via RequestBody
	 * @return
	 * OK if the user was successful created
	 * SERVICE_UNAVAILABLE if can not access to the local service
	 * CONFLICT if the user already exists
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody User userRequest);
	
	/**
	 * Deletes an existent user on the local service
	 * 
	 * @param userName
	 * The identifier of the user to delete
	 * @return
	 * OK if the user was successful deleted
	 * SERVICE_UNAVAILABLE if can not access to the local service
	 * CONFLICT if the user not exists
	 */
	@RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String userName);
	
	/**
	 * Updates an existent user on the local service
	 * 
	 * @param userRequest
	 * The user to update via RequestBody
	 * @return
	 * OK if the user was successful updated
	 * SERVICE_UNAVAILABLE if can not access to the local service
	 * CONFLICT if the user not exists
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody User userRequest);
	
	/**
	 * Gets an existent user
	 * 
	 * @param userName
	 * Identifier of the user to get via RequestParam
	 * @return
	 * OK And the requested User if the user was successful readed
	 * SERVICE_UNAVAILABLE if can not access to the local service
	 * CONFLICT if the user not exists
	 */
	@RequestMapping(value= "/{userName}",method = RequestMethod.GET)
	public ResponseEntity<User> read(@PathVariable String userName);
	
	/**
	 * Gets a list of users who shared the same name
	 * 
	 * @param name
	 * Name to want check if have users sharing it
	 * 
	 * @return
	 * OK && List of users who shared the name if one or more users have that name
	 * SERVICE_UNAVAILABLE if can not access to the local service
	 * CONFLICT if no one have that name
	 */
	@RequestMapping(value= "/byName/{name}", method = RequestMethod.GET)
	public ResponseEntity<Collection<User>> readByName(@PathVariable String name);
}
