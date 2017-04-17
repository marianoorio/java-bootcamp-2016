package com.bootcamp.topic2.exersice2;

import java.util.ArrayList;
import java.util.List;

public class Blog {
	
	private List<Post> posts;
	
	
	public Blog(){
		posts = new ArrayList<Post>();
	}

	public void addPost(Post newPost) {
		posts.add(0, newPost);
	}

	public Post getLastPost() {
		if (!posts.isEmpty()){
			return posts.get(0);
		}
		return null;
	}

	public boolean deletePost(Post post) {
		if(posts.remove(post)){
			return true;
		}
		return false;
	}

	public int size() {
		return posts.size();
	}
	
	public boolean exists(Post post){
		return posts.contains(post);
	}
	
	public final List<Post> getAllPosts(){
		return posts;
	}

	public final List<Post> getLastestPosts(int count) {
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
