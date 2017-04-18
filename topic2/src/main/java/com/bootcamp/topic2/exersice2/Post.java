package com.bootcamp.topic2.exersice2;

/**
 * 
 * Data Class for blog's entries
 *
 */
public class Post {
	
	private static int idCount = 0;
	
	public static void resetCount(){
		idCount = 0;
	}
	
	private int postId;
	private String author;
	private String header;
	private String body;
	
	public Post(String author, String header, String body){
		idCount++;
		this.postId = idCount;
		this.author = author;
		this.header = header;
		this.body = body;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + postId;
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Post other = (Post) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (body == null) {
			if (other.body != null) {
				return false;
			}
		} else if (!body.equals(other.body)) {
			return false;
		}
		if (header == null) {
			if (other.header != null) {
				return false;
			}
		} else if (!header.equals(other.header)) {
			return false;
		}
		if (postId != other.postId) {
			return false;
		}
		return true;
	}
}
