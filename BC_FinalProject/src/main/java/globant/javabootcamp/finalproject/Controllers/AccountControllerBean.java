package globant.javabootcamp.finalproject.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import globant.javabootcamp.finalproject.Entities.Account;
import globant.javabootcamp.finalproject.Exceptions.AlreadyExistsException;
import globant.javabootcamp.finalproject.Exceptions.NotFoundException;
import globant.javabootcamp.finalproject.Services.LoginService;
import globant.javabootcamp.finalproject.Services.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/")
@Api(value="Users")
public class AccountControllerBean implements AccountController{
	
	@Autowired
	private AccountService userService;
	
	@Autowired
	private LoginService loginService;
	
	@Override
	@ApiOperation(value = "create", notes="creates a new account",nickname = "createAccount")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class) })
	@RequestMapping(value = "/users",method = RequestMethod.POST)
	public ResponseEntity<Void> create(@ApiParam(value = "new account's attributes", required = true)@RequestBody Account userRequest){
		ResponseEntity<Void> response;
		try{
			userService.create(userRequest);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(AlreadyExistsException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "read", notes="gets an existent account",nickname = "readAccount")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = Account.class),
	        @ApiResponse(code = 204, message = "No Content") })
	@RequestMapping(value= "/users/{accountIdId}", method = RequestMethod.GET)
	public ResponseEntity<Account> read(@ApiParam(value = "account's id", required = true)@PathVariable Long accountId){
		ResponseEntity<Account> response;
		try{
			Account user = userService.read(accountId);
			response  = new ResponseEntity<Account>(user,HttpStatus.OK);
		}
		catch(NotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "update", notes="updates an existent account",nickname = "updateAccount")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class) })
	@RequestMapping(value = "/users",method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@ApiParam(value = "updated account's attributes", required = true)@RequestBody Account accountRequest){
		ResponseEntity<Void> response;
		try{
			userService.update(accountRequest);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "delete", notes="deletes an existent account",nickname = "deleteAccount")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok"),
	        @ApiResponse(code = 204, message = "No Content",
	            response = void.class) })
	@RequestMapping(value = "/users/{accountId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@ApiParam(value = "account's id", required = true)@PathVariable Long accountId){
		ResponseEntity<Void> response;
		try{
			userService.delete(accountId);
			response  = new ResponseEntity<>(HttpStatus.OK);
		}
		catch(NotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@ApiOperation(value = "byUsername", notes="gets an existent account with the username given",nickname = "readByUsername")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = Account.class, responseContainer = "List"),			
	        @ApiResponse(code = 204, message = "No Content") })
	@RequestMapping(value= "/users/byUsername/{username}", method = RequestMethod.GET)
	public ResponseEntity<Account> findByUsername(@ApiParam(value = "username of", required = true)@PathVariable String username){
		ResponseEntity<Account> response;
		try{
			Account user = userService.findByUsername(username);
			response  = new ResponseEntity<>(user,HttpStatus.OK);
		}
		catch(NotFoundException e){
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@Override
	@ApiOperation(value = "findAll", notes="returns all accounts",nickname = "getAllAccounts")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok")})
	@RequestMapping(value = "/users",method = RequestMethod.GET)
	public ResponseEntity<Collection<Account>> findAll() {
		ResponseEntity<Collection<Account>> response = null;
		Collection<Account> users = userService.findAll();
		response = new ResponseEntity<>(users, HttpStatus.OK);
		return response;
	}
	
	@Override
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ResponseEntity<Void> login(@ApiParam(value = "account attributes to log in", required = true)@RequestBody Account account){
		ResponseEntity<Void> response = null;
		try {
			loginService.login(account.getUsername(), account.getPassword());
			response  = new ResponseEntity<>(HttpStatus.OK);
		} catch (NotFoundException e) {
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
	
	@Override
	@RequestMapping(value = "/logout/{username}",method = RequestMethod.GET)
	public ResponseEntity<Void> logout(@ApiParam(value = "account's username to logout", required = true)@PathVariable String username){
		ResponseEntity<Void> response = null;
		try {
			loginService.logout(username);
			response  = new ResponseEntity<>(HttpStatus.OK);
		} catch (NotFoundException e) {
			response  = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}
}
