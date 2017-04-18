package com.bootcamp.topic2.exersice1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.logging.Logger;


/**
 * 
 * Files Manager class
 * uses singleton pattern
 *
 */
public class FileManager {
	
	private static FileManager fileManager= null;
	private RecentFiles recentFilesList;
	
	/**
	 * Create the instance of FileManager 
	 * private for apply singleton pattern
	 */
	private FileManager(){
		recentFilesList = new RecentFiles();
	}
	
	/**
	 * 
	 * @return the unique instance of FileManager
	 */
	public static FileManager getFileManager(){
		if(fileManager == null){
			fileManager = new FileManager();
		}
		return fileManager;
	}
	
	/**
	 * 
	 * @return the List of Recent Files
	 */
	public RecentFiles getRecentFiles(){
		return recentFilesList;
	}
	
	/**
	 * 
	 * @param file to open
	 * @return the BufferedReader of the file to opened / null if can not open the file
	 */
	public BufferedReader openFile(File file){
		BufferedReader bufferedReader = null;
		try{
			bufferedReader = getBufferedReader(file);
			recentFilesList.add(file.getPath());
		}catch(FileNotFoundException e){
			Logger.getAnonymousLogger().severe(e.getMessage());
		}
		return bufferedReader;
	}
	
	/**
	 * 
	 * @param file to open
	 * @return the buffered reader of a file
	 * @throws FileNotFoundException
	 */
	public BufferedReader getBufferedReader(File file) throws FileNotFoundException {
		BufferedReader bufferedReader;
		bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		return bufferedReader;
	}
	
	/**
	 * Clear the Recent Files List
	 */
	public void clearRecentList() {
		recentFilesList.clear();
	}
}
