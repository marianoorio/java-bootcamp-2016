package com.bootcamp.Topic6.Services;

import com.bootcamp.Topic6.Entities.User;
import com.bootcamp.Topic6.Exceptions.UserAlreadyExistsException;
import com.bootcamp.Topic6.Exceptions.UserNotFoundException;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Unit test for users services
 *
 */
public class LocalUserServiceTest {
	
	ServiceUsers users;
	
	@Before
	public void setUp() throws Exception {
		users = LocalUserService.getService();
		LocalUserService.clearService();
	}

	@After
	public void tearDown() throws Exception {
		users = null;
	}

	@Test
	public final void whenCreatesAnUserItIsAdded() {
		User user0 = new User("user0", "passwordUser0","user","user@test.com");
		try {
			users.createUser(user0);
			Assert.assertTrue(true);
		} catch (UserAlreadyExistsException e) {
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public final void whenCreatesAnNullUserItIsNotAdded() {
		try {
			users.createUser(null);
			Assert.assertTrue(false);
		} catch (UserAlreadyExistsException e) {
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public final void whenCreatesAnExistentUserItIsNotAddedAndThrowException() {
		try{
			User user0 = new User("user0", "passwordUser0","user","user@test.com");
			users.createUser(user0);
			User user1 = new User("user0", "passwordUser1","user1","user@test.com");
			users.createUser(user1);
			Assert.assertTrue(false);
		}catch(UserAlreadyExistsException e){
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(true);
		}
		
	}
	
	@Test
	public final void whenReadsAnNullUserItThrownAnException() {
		try {
			users.readUser(null);
			Assert.assertTrue(false);
		} catch (UserNotFoundException e) {
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public final void whenReadsAnUnexistentUserItThrowAnException() {
		try {
			users.readUser("user0");
			Assert.assertTrue(false);
		} catch (UserNotFoundException e) {
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public final void whenReadsAnExistentUserItReturnTheUser() {
		try {
			User user0 = new User("user0", "passwordUser0","user","user@test.com");
			users.createUser(user0);
			Assert.assertEquals(user0, users.readUser(user0.getUserName()));
		} catch (UserNotFoundException e) {
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(false);
		}catch (UserAlreadyExistsException e) {
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	
	@Test
	public final void whenUpdateANullUserItReturnFalse() {
		try {
			users.updateUser(null);
		} catch (UserNotFoundException e) {
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public final void whenUpdateAnUnexistentUserItThrowAnException() {
		User user0 = new User("user0", "passwordUser0","user","user@test.com");
		try {
			users.updateUser(user0);
			Assert.assertTrue(false);
		} catch (UserNotFoundException e) {
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public final void whenUpdateAnExistentUserItIsUpdated() {
		try{User user0 = new User("user0", "passwordUser0","user","user@test.com");
			users.createUser(user0);
			user0.setName("newName");
			users.updateUser(user0);
			Assert.assertEquals("newName",users.readUser(user0.getUserName()).getName());
		}catch (Exception e){
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public final void whenDeletesAnExistentUserItIsRemoved() {
		try{
			User user0 = new User("user0", "passwordUser0","user","user@test.com");
			users.createUser(user0);
			User user1 = new User("user1", "passwordUser1","user","user@test.com");
			users.createUser(user1);
			users.deleteUser(user0.getUserName());
			Assert.assertTrue(true);
		}catch (Exception e){
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(false);
		}	
	}
	
	@Test
	public final void whenReadsAnUsersByNameTheyAreReturned(){
		try{
			User user0 = new User("user0", "passwordUser0","sameName","user@test.com");
			users.createUser(user0);
			User user1 = new User("user1", "passwordUser1","sameName","user@test.com");
			users.createUser(user1);
			User user2 = new User("user2", "passwordUser2","notSameName","user@test.com");
			users.createUser(user2);
			User user3 = new User("user3", "passwordUser3","sameName","user@test.com");
			users.createUser(user3);
			
			List<User> compare = new ArrayList<User>();
			compare.add(0,user0);
			compare.add(0,user3);
			compare.add(0,user1);
			Assert.assertEquals(compare,users.readUsersByName("sameName"));
		}catch(Exception e){
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public final void whenReadsAnUsersByNameTheyAreNotExistentsThrowException(){
		try{
			User user0 = new User("user0", "passwordUser0","sameName","user@test.com");
			users.createUser(user0);
			User user1 = new User("user1", "passwordUser1","sameName","user@test.com");
			users.createUser(user1);
			User user2 = new User("user2", "passwordUser2","notSameName","user@test.com");
			users.createUser(user2);
			User user3 = new User("user3", "passwordUser3","sameName","user@test.com");
			users.createUser(user3);
			
			users.readUsersByName("Carl");
			Assert.assertTrue(false);
		}catch(Exception e){
			Logger.getAnonymousLogger().severe(e.getMessage());
			Assert.assertTrue(true);
		}
	}
	
}
