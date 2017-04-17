package com.bootcamp.topic2.exersice2;

public class Post {
	
	private static int idCount = 0;
	
	public static void resetCount(){
		idCount = 0;
	}
	
	private int postId;
	private String author;
	private String header;
	private String body;
	
	public Post(){};
	
	public Post(String author, String header, String body){
		idCount++;
		this.postId = idCount;
		this.author = author;
		this.header = header;
		this.body = body;
	}
	
	protected void setPostId(int postId){
		this.postId = postId;
	}
	
	public int getPostId(){
		return this.postId;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
