package com.bootcamp.topic2.exersice1Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bootcamp.topic2.exersice1.RecentFiles;

/**
 * 
 * Unit test for RecentFiles class
 *
 */
public class RecentFilesTest {
	
	RecentFiles recentFiles;
	
	@Before
	public void setUp() throws Exception {
		recentFiles = new RecentFiles();
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public final void whenAddExistingFileItIsNotDuplicated(){
		recentFiles.add("file0");
		recentFiles.add("file1");
		recentFiles.add("file2");
		recentFiles.add("file0");
		Assert.assertEquals(3, recentFiles.size());
	}
	
	@Test
	public final void whenAddExistingFileItIsDumpedToTheTopOfTheList(){
		recentFiles.add("file0");
		recentFiles.add("file1");
		recentFiles.add("file2");
		recentFiles.add("file0");
		Assert.assertEquals("file0", recentFiles.getLastRecent());
	}
	
	@Test
	public final void ifTheRecentFilesIsFullRemoveTheOlderAndAddTheNew(){
		for (int i=0; i < 15; i++){
			StringBuilder stringBuilder = new StringBuilder ("file");
			stringBuilder.append(i);
			recentFiles.add(stringBuilder.toString());
		}
		recentFiles.add("file15");
		
		/*
		Assert.assertEquals("file15", recentFiles.getLastRecent());
		Assert.assertEquals(15, recentFiles.size());
		*/
		
		//Better compare the whole list
		//Multiples asserts are not good practice
		List<String> compareList = new ArrayList<String>();
		for (int i=1; i < 16; i++){
			StringBuilder stringBuilder = new StringBuilder ("file");
			stringBuilder.append(i);
			compareList.add(0,stringBuilder.toString());
		}
		Assert.assertEquals(compareList, recentFiles.getElements());
	}
	
	@Test
	public final void whenResizeIfTheNewSizeIsLowerThanActualRemovesTheLastElements(){
		for (int i=0; i < 15; i++){
			StringBuilder stringBuilder = new StringBuilder ("file");
			stringBuilder.append(i);
			recentFiles.add(stringBuilder.toString());
		}
		recentFiles.resize(12);
		List<String> compareList = new ArrayList<String>();
		for (int i=3; i < 15; i++){
			StringBuilder stringBuilder = new StringBuilder ("file");
			stringBuilder.append(i);
			compareList.add(0,stringBuilder.toString());
		}
		Assert.assertEquals(compareList, recentFiles.getElements());
	}
	
	@Test
	public final void whenResizeIfTheNewSizeIsLowerThanZeroReturnFalse(){
		Assert.assertFalse(recentFiles.resize(-120));
	}
}
