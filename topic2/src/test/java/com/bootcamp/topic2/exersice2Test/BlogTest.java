package com.bootcamp.topic2.exersice2Test;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bootcamp.topic2.exersice2.Blog;
import com.bootcamp.topic2.exersice2.Post;

public class BlogTest {
	
	Blog blog;
	
	@Before
	public void setUp() throws Exception {
		blog = new Blog();
	}

	@After
	public void tearDown() throws Exception {
		Post.resetCount();
	}

	@Test
	public final void whenAddANewPostItIsAddedAtTop(){
		Post mockPost = new Post("Author A0", "Header H0", "Body B0");
		blog.addPost(mockPost);
		Assert.assertEquals(mockPost, blog.getLastPost());
	}
	
	@Test
	public final void whenDeletePostItIsRemoveFromBlog(){
		Post mockPost = new Post("Author A0", "Header H0", "Body B0");
		blog.addPost(mockPost);
		blog.deletePost(mockPost);
		Assert.assertEquals(0,blog.size());
	}
	
	
	@Test
	public final void whenDeletePostItIsRemoveFromBlog2(){
		Post mockPost0 = new Post("Author A0", "Header H0", "Body B0");
		blog.addPost(mockPost0);
		Post mockPost1 = new Post("Author A1", "Header H1", "Body B1");
		blog.addPost(mockPost1);
		blog.deletePost(mockPost1);
		Assert.assertEquals(mockPost0,blog.getLastPost());
	}
	
	@Test
	public final void whenWantToGetTheMostRecentlyPostsTheSizeReturnedIsTheRight(){
		int countPost = 10;
		for (int index=0; index < countPost*2; index++){
			Post mockPost = new Post("Author", "Header", "Body");
			blog.addPost(mockPost);
		}
		Assert.assertEquals(10,blog.getLastestPosts(10).size());
	}
	
	@Test
	public final void whenWantToGetTheMostRecentlyPostsThePostsReturnedAreTheLasts(){
		
		int countPost = 15;
		List<Post> compare = new ArrayList<Post>();
		
		for (int index=0; index < countPost*2; index++){
			Post mockPost = new Post("Author", "Header", "Body");
			blog.addPost(mockPost);
			if(index >= countPost){
				compare.add(0,mockPost);
			}
		}
		
		Assert.assertEquals(compare,blog.getLastestPosts(countPost));
	}

}
