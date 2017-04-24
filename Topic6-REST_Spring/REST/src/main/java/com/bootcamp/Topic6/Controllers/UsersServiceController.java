package com.bootcamp.Topic6.Controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.Topic6.Entities.User;
import com.bootcamp.Topic6.Exceptions.ServiceNotFoundException;
import com.bootcamp.Topic6.Exceptions.UserAlreadyExistsException;
import com.bootcamp.Topic6.Exceptions.UserNotFoundException;
import com.bootcamp.Topic6.Services.ServiceUsersFactory;
import com.bootcamp.Topic6.Services.ServiceUsersTypes;

/**
 * 
 * Provides a REST controller for Users Services
 *
 */
@RestController
@RequestMapping("/users")
public class UsersServiceController {
	
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
	@RequestMapping(value = "/create")
	public ResponseEntity<Void> createUser(@RequestBody User userRequest){
		ResponseEntity<Void> response;
		try{
			ServiceUsersFactory.getUserService(ServiceUsersTypes.LOCAL_SERVICE).createUser(userRequest);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}catch(ServiceNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		catch(UserAlreadyExistsException e){
			response  = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return response;
	}
	
	/**
	 * Deletes an existent user on the local service
	 * 
	 * @param userName
	 * The identifier of the user to delete via RequestParam
	 * @return
	 * OK if the user was successful deleted
	 * SERVICE_UNAVAILABLE if can not access to the local service
	 * CONFLICT if the user not exists
	 */
	@RequestMapping(value = "/delete")
	public ResponseEntity<Void> deleteUser(@RequestParam(value="userName", defaultValue="notValidUserName") String userName){
		ResponseEntity<Void> response;
		try{
			ServiceUsersFactory.getUserService(ServiceUsersTypes.LOCAL_SERVICE).deleteUser(userName);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}catch(ServiceNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		catch(UserNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return response;
	}
	
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
	@RequestMapping(value = "/update")
	public ResponseEntity<Void> updateUser(@RequestBody User userRequest){
		ResponseEntity<Void> response;
		try{
			ServiceUsersFactory.getUserService(ServiceUsersTypes.LOCAL_SERVICE).updateUser(userRequest);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}catch(ServiceNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		catch(UserNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return response;
	}
	
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
	@RequestMapping(value= "/read")
	public ResponseEntity<User> readUser(@RequestParam(value="userName", defaultValue="notValidUserName") String userName){
		ResponseEntity<User> response;
		try{
			User user =ServiceUsersFactory.getUserService(ServiceUsersTypes.LOCAL_SERVICE).readUser(userName);
			response  = new ResponseEntity<User>(user,HttpStatus.OK);
		}catch(ServiceNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		catch(UserNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return response;
	}
	
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
	@RequestMapping(value= "/readByName")
	public ResponseEntity<Collection<User>> readUserByName(@RequestParam(value="name", defaultValue="imNotAnEnteredName") String name){
		ResponseEntity<Collection<User>> response;
		try{
			Collection<User> users =ServiceUsersFactory.getUserService(ServiceUsersTypes.LOCAL_SERVICE).readUsersByName(name);
			response  = new ResponseEntity<Collection<User>>(users,HttpStatus.OK);
		}catch(ServiceNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
		catch(UserNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return response;
	}
}
