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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/users")
@Api(value="Users")
public class UserControllerImp implements UserController{
	
	@Autowired
	private UserService userService;
	
	@Override
	@ApiOperation(value = "create", notes="creates a new user",nickname = "createUser")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class) })
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@ApiParam(value = "new user's attributes", required = true)@RequestBody User userRequest){
		ResponseEntity<Void> response;
		try{
			userService.create(userRequest);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(UserAlreadyExistsException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "delete", notes="deletes an existent user",nickname = "deleteUser")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class) })
	@RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@ApiParam(value = "user's id", required = true)@PathVariable String userName){
		ResponseEntity<Void> response;
		try{
			userService.delete(userName);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(UserNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "update", notes="updates an existent user",nickname = "updateUser")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class) })
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@ApiParam(value = "updates user's attributes", required = true)@RequestBody User userRequest){
		ResponseEntity<Void> response;
		try{
			userService.update(userRequest);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(UserNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "read", notes="gets an existent user",nickname = "readUser")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = User.class),
	        @ApiResponse(code = 204, message = "No Content") })
	@RequestMapping(value= "/{userName}", method = RequestMethod.GET)
	public ResponseEntity<User> read(@ApiParam(value = "user's id", required = true)@PathVariable String userName){
		ResponseEntity<User> response;
		try{
			User user = userService.read(userName);
			response  = new ResponseEntity<User>(user,HttpStatus.OK);
		}
		catch(UserNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = User.class, responseContainer = "List"),			
	        @ApiResponse(code = 204, message = "No Content") })
	@ApiOperation(value = "byName", notes="gets existents users with the same name",nickname = "readByNameUser")
	@RequestMapping(value= "/byName/{name}", method = RequestMethod.GET)
	public ResponseEntity<Collection<User>> readByName(@ApiParam(value = "names of", required = true)@PathVariable String name){
		ResponseEntity<Collection<User>> response;
		try{
			Collection<User> users = userService.readByName(name);
			response  = new ResponseEntity<Collection<User>>(users,HttpStatus.OK);
		}
		catch(UserNotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
}
