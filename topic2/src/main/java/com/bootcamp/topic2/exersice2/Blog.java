package com.bootcamp.topic2.exersice2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Provides an implementation of a blog
 *
 */
public class Blog {
	
	private List<Post> posts;
	
	public Blog(){
		posts = new ArrayList<Post>();
	}

	/**
	 * Adds a new entry to the blog
	 * 
	 * @param newPost to add on blog
	 */
	public void addPost(Post newPost) {
		posts.add(0, newPost);
	}
	
	/**
	 * 
	 * @return the last post added
	 */
	public Post getLastPost() {
		Post returnPost = null;
		if (!posts.isEmpty()){
			returnPost = posts.get(0);
		}
		return returnPost;
	}
	
	/**
	 * Deletes a existent post
	 * 
	 * @param post to delete
	 * @return true if the post was deleted / false if the post to delete doesn't exists
	 */
	public boolean deletePost(Post post) {
		boolean removed = false;
		if(posts.remove(post)){
			removed = true;
		}
		return removed;
	}

	public int size() {
		return posts.size();
	}
	
	public boolean exists(Post post){
		return posts.contains(post);
	}
	
	/**
	 * 
	 * @return a constant list of all posts on the blog
	 */
	public final List<Post> getAllPosts(){
		return posts;
	}

	/**
	 * 
	 * @param the quantity of latest posts want to be return
	 * @return a constant list of (quantity) latest posts
	 */
	public final List<Post> getLatestPosts(int count) {
		if (count < 0){
			return null;
		}
		if (count > posts.size()){
			count = posts.size();
		}
		List<Post> returnList = new ArrayList<Post>();
		for (int index = 0; index < count; index++){
			returnList.add(posts.get(index));
		}
		return returnList;
	}
}
