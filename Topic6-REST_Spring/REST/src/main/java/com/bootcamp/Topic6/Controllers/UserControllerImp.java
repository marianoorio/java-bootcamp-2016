package com.bootcamp.Topic6.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.Topic6.Entities.User;
import com.bootcamp.Topic6.Exceptions.UserAlreadyExistsException;
import com.bootcamp.Topic6.Exceptions.UserNotFoundException;
import com.bootcamp.Topic6.Services.UserService;

/**
 * 
 * Provides a REST controller for Users Services
 *
 */
@RestController
@RequestMapping("/users")
public class UserControllerImp implements UserController{
	
	@Autowired
	private UserService userService;
	
	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody User userRequest){
		ResponseEntity<Void> response;
		try{
			userService.create(userRequest);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(UserAlreadyExistsException e){
			response  = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@Override
	@RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String userName){
		ResponseEntity<Void> response;
		try{
			userService.delete(userName);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(UserNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@Override
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody User userRequest){
		ResponseEntity<Void> response;
		try{
			userService.update(userRequest);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(UserNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@Override
	@RequestMapping(value= "/{userName}", method = RequestMethod.GET)
	public ResponseEntity<User> read(@PathVariable String userName){
		ResponseEntity<User> response;
		try{
			User user = userService.read(userName);
			response  = new ResponseEntity<User>(user,HttpStatus.OK);
		}
		catch(UserNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@Override
	@RequestMapping(value= "/byName/{name}", method = RequestMethod.GET)
	public ResponseEntity<Collection<User>> readByName(@PathVariable String name){
		ResponseEntity<Collection<User>> response;
		try{
			Collection<User> users = userService.readByName(name);
			response  = new ResponseEntity<Collection<User>>(users,HttpStatus.OK);
		}
		catch(UserNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return response;
	}
}
