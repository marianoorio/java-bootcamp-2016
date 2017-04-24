package com.bootcamp.Topic6.Controllers;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.bootcamp.Topic6.Application.Application;
import com.bootcamp.Topic6.Entities.User;
import com.bootcamp.Topic6.Services.LocalUserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * 
 * Unit tests for REST Users Services
 * 
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UsersServiceControllersTest {
	
	private MediaType contentType = new MediaType(	MediaType.APPLICATION_JSON.getType(),
													MediaType.APPLICATION_JSON.getSubtype(),
													Charset.forName("utf8"));
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private HttpMessageConverter mappingJackson2HttpMessageConverter;
	
	/**
	 * Set the converter mappingJackson2HttpMessageConverter
	 * @param converters
	 */
	@Autowired
	void setConverters(HttpMessageConverter<?>[] converters){
		this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
				.filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
				.findAny().orElse(null);
		
		Assert.assertNotNull("the JSON message converter must not be null",
				      this.mappingJackson2HttpMessageConverter);
	}
	
	/**
	 * This method convert an Object into MediaType.APPLICATION_JSON
	 * @param o
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	protected String json(Object o) throws IOException{
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}
	
	@Before
	public void setUp() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
		LocalUserService.clearService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void whenCreatesAnUserItsIsAdded() throws IOException, Exception {
		User user = new User("user","password","name","email");
		this.mockMvc.perform(post("/users/create").content(this.json(user)).contentType(contentType))
					.andExpect(status().isOk());
		Assert.assertEquals(user,LocalUserService.getService().readUser("user"));
	}
	
	@Test
	public void whenCreatesAnExistentUserItIsNotDuplicatedAndThrowException() throws IOException, Exception {
		User user = new User("user","password","name","email");
		this.mockMvc.perform(post("/users/create").content(this.json(user)).contentType(contentType))
					.andExpect(status().isOk());
		this.mockMvc.perform(post("/users/create").content(this.json(user)).contentType(contentType))
		.andExpect(status().isConflict());
	}
	@Test
	public void whenDeletesAnUserItsIsDeleted() throws IOException, Exception {
		User user = new User("user","password","name","email");
		this.mockMvc.perform(post("/users/create").content(this.json(user)).contentType(contentType))
					.andExpect(status().isOk());
		
		this.mockMvc.perform(delete("/users/delete?userName=user")).andExpect(status().isOk());
	}
	
	@Test
	public void whenDeletesAnUnexistentUserItsSendConflict() throws IOException, Exception {
		
		this.mockMvc.perform(delete("/users/delete")).andExpect(status().isConflict());
	}
	
	@Test
	public void whenUpdatesAnUserItsIsUpdated() throws IOException, Exception {
		User user = new User("user","password","name","email");
		this.mockMvc.perform(post("/users/create").content(this.json(user)).contentType(contentType))
					.andExpect(status().isOk());
		
		user.setName("Jonh");
		this.mockMvc.perform(put("/users/update").content(this.json(user)).contentType(contentType))
					.andExpect(status().isOk());
		Assert.assertEquals(user,LocalUserService.getService().readUser("user"));
	}
	
	@Test
	public void whenUpdatesAnUnexistentUserItIsNotUpdatedAndSendsConflict() throws IOException, Exception {
		User user = new User("user","password","name","email");
		this.mockMvc.perform(post("/users/create").content(this.json(user)).contentType(contentType))
					.andExpect(status().isOk());
		
		User user0 = new User("user1","password","name","email");
		this.mockMvc.perform(put("/users/update").content(this.json(user0)).contentType(contentType))
					.andExpect(status().isConflict());
	}
	
	@Test
	public void whenReadsAnExistentUserItIsReturned() throws IOException, Exception {
		User user = new User("user","password","name","email");
		this.mockMvc.perform(get("/users/create").content(this.json(user)).contentType(contentType))
					.andExpect(status().isOk());
		
		this.mockMvc.perform(put("/users/read?=userName=user").contentType(contentType))
					.andExpect(status().isOk())
					.andExpect(content().contentType(contentType))
					.andExpect(content().string(this.json(LocalUserService.getService().readUser("user"))));
	}
	
	@Test
	public void whenReadsAnUnexistentUserItsSendsConflict() throws IOException, Exception {
		User user = new User("user","password","name","email");
		this.mockMvc.perform(get("/users/create").content(this.json(user)).contentType(contentType))
					.andExpect(status().isOk());
		
		this.mockMvc.perform(put("/users/read?=userName=userNotIn").contentType(contentType))
					.andExpect(status().isConflict());
	}
	
	@Test
	public void whenReadsByNameAnUnexistentNameItsSendsConflict() throws IOException, Exception {
		User user = new User("user","password","sameName","email");
		this.mockMvc.perform(get("/users/create").content(this.json(user)).contentType(contentType))
					.andExpect(status().isOk());
		User user0 = new User("user0","password","sameName","email");
		this.mockMvc.perform(get("/users/create").content(this.json(user0)).contentType(contentType))
					.andExpect(status().isOk());
		User user1 = new User("user1","password","name","email");
		this.mockMvc.perform(get("/users/create").content(this.json(user1)).contentType(contentType))
					.andExpect(status().isOk());
		User user2 = new User("user2","password","sameName","email");
		this.mockMvc.perform(get("/users/create").content(this.json(user2)).contentType(contentType))
					.andExpect(status().isOk());
		
		this.mockMvc.perform(put("/users/readByName?name=notNameIn").contentType(contentType))
					.andExpect(status().isConflict());
	}
	
	@Test
	public void whenReadsByNameAnExistentNameItsReturnTheUsersAssosiated() throws IOException, Exception {
		User user = new User("user","password","sameName","email");
		this.mockMvc.perform(get("/users/create").content(this.json(user)).contentType(contentType))
					.andExpect(status().isOk());
		User user0 = new User("user0","password","sameName","email");
		this.mockMvc.perform(get("/users/create").content(this.json(user0)).contentType(contentType))
					.andExpect(status().isOk());
		User user1 = new User("user1","password","name","email");
		this.mockMvc.perform(get("/users/create").content(this.json(user1)).contentType(contentType))
					.andExpect(status().isOk());
		User user2 = new User("user2","password","sameName","email");
		this.mockMvc.perform(get("/users/create").content(this.json(user2)).contentType(contentType))
					.andExpect(status().isOk());
		
		this.mockMvc.perform(put("/users/readByName?name=sameName").contentType(contentType))
					.andExpect(status().isOk())
					.andExpect(content().contentType(contentType));
					//HOW TO TEST AN COLLECTION RETURNED BY REST??
	}

}
