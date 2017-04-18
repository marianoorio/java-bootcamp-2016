package com.bootcamp.topic3.ServiceUsers;

import org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Unit test for users services
 *
 */

public class ServiceUsersTest {
	
	ServiceUsers users;
	
	@Before
	public void setUp() throws Exception {
		users = new ServiceUsersImplementation();
	}

	@After
	public void tearDown() throws Exception {
		users = null;
	}

	@Test
	public final void whenCreatesAnUserItIsAdded() {
		User user0 = new User("user0", "passwordUser0","user","user@test.com");
		Assert.assertTrue(users.createUser(user0));
	}
	
	@Test
	public final void whenCreatesAnNullUserItIsNotAdded() {
		Assert.assertFalse(users.createUser(null));
	}
	
	@Test
	public final void whenCreatesAnExistentUserItIsNotAdded() {
		User user0 = new User("user0", "passwordUser0","user","user@test.com");
		users.createUser(user0);
		User user1 = new User("user0", "passwordUser1","user1","user@test.com");
		Assert.assertFalse(users.createUser(user1));
	}
	
	
	@Test
	public final void whenReadsAnNullUserItReturnNull() {
		Assert.assertNull(users.readUser(null));
	}
	
	@Test
	public final void whenReadsAnUnexistentUserItReturnNull() {
		Assert.assertNull(users.readUser("user0"));
	}
	
	@Test
	public final void whenReadsAnExistentUserItReturnTheUser() {
		User user0 = new User("user0", "passwordUser0","user","user@test.com");
		users.createUser(user0);
		Assert.assertEquals(user0, users.readUser(user0.getUserName()));
	}
	
	@Test
	public final void whenUpdateAnExistentUserItReturnTrue() {
		User user0 = new User("user0", "passwordUser0","user","user@test.com");
		users.createUser(user0);
		Assert.assertTrue(users.updateUser(user0));
	}
	
	@Test
	public final void whenUpdateANullUserItReturnFalse() {
		Assert.assertFalse(users.updateUser(null));
	}
	
	@Test
	public final void whenUpdateAnUnexistentUserItReturnFalse() {
		User user0 = new User("user0", "passwordUser0","user","user@test.com");
		Assert.assertFalse(users.updateUser(user0));
	}
	
	@Test
	public final void whenUpdateAnExistentUserItIsUpdated() {
		User user0 = new User("user0", "passwordUser0","user","user@test.com");
		users.createUser(user0);
		user0.setName("newName");
		users.updateUser(user0);
		Assert.assertEquals("newName",users.readUser(user0.getUserName()).getName());
	}
	
	@Test
	public final void whenDeletesAnExistentUserItIsRemoved() {
		User user0 = new User("user0", "passwordUser0","user","user@test.com");
		users.createUser(user0);
		User user1 = new User("user1", "passwordUser1","user","user@test.com");
		users.createUser(user1);
		users.deleteUser(user0.getUserName());
		Assert.assertNull(users.readUser(user0.getUserName()));
	}
	
}
