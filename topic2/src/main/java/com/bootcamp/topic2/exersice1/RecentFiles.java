package com.bootcamp.topic2.exersice1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Stores the List of Recent Files opened
 * Stores the path to file not the file itself
 * (If the file is deleted, it can't open it from recent files list)
 * 
 */

public class RecentFiles {
	private final int DEFAULT_MAX_SIZE = 15;
	private int maxSize;
	
	
	/**
	 * Stores the path of the recent files opened
	 */
	List<String> pathList;
	
	
	/**
	 * Constructor
	 */
	public RecentFiles(){
		pathList = new ArrayList<String>();
		maxSize = DEFAULT_MAX_SIZE;
	}
	
	
	public int size(){
		return pathList.size();
	}
	
	public boolean isEmpty(){
		return pathList.isEmpty();
	}
	
	public boolean isFull(){
		return (pathList.size()==maxSize) ? true : false;
	}
	
	/**
	 * 
	 * @return the last entry path
	 */
	public String getLastRecent() {
		if(!pathList.isEmpty()){
			return pathList.get(0);
		}
		return null;
	}
	
	/**
	 * 
	 * @return the whole list
	 * can't be modified outside
	 */
	public final List<String> getElements(){
		return this.pathList;
	}
	
	/**
	 * Add a new entry
	 */
	public void add(String pathFile){
		if((!pathList.remove(pathFile)) && (this.isFull())){
			this.removeLastElements(1);
		}
		pathList.add(0,pathFile);
	}

	public void clear() {
		pathList.clear();
	}
	
	/**
	 * 
	 * @param newSize
	 * @return false if the newSize is < 0 / true if resize success
	 */
	public boolean resize(int newSize){
		if (newSize < 0 ){
			return false;
		}
		if(newSize < pathList.size()){
			int elementsRemove = pathList.size() - newSize;
			removeLastElements(elementsRemove);
		}
		maxSize = newSize;
		return true;
	}
	
	
	/**
	 * 
	 * @param elementsRemove counts of elements to remove
	 */
	private void removeLastElements(int elementsRemove) {
		if (elementsRemove < pathList.size()){
			for (int i = 1; i <= elementsRemove; i++){
				pathList.remove(pathList.size()-1);
			}
		}
	}
	
}
	