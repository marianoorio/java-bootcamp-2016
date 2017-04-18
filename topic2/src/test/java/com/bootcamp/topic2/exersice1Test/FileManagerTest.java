package com.bootcamp.topic2.exersice1Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bootcamp.topic2.exersice1.FileManager;

/**
 * 
 * Unit test for FileManager class
 *
 */
//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class FileManagerTest {
	
	FileManager fileManager = FileManager.getFileManager();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		fileManager.clearRecentList();
	}
	
	@Test
	public final void WhenTheProgramIsRunForTheFirstTimeTheRecentListIsEmpty(){
		Assert.assertTrue(fileManager.getRecentFiles().isEmpty());
	}
	
	@Test
	public final void whenFileIsOpennedItIsAddedToTheRecentFileList(){
		fileManager = Mockito.spy(fileManager);
		try{
			Mockito.doReturn(null).when(fileManager).getBufferedReader(Mockito.any(File.class)); 
		}catch(FileNotFoundException e){
			Logger.getAnonymousLogger().severe(e.getMessage());
		}
		
		fileManager.openFile(new File("file0"));
		Assert.assertEquals("file0", fileManager.getRecentFiles().getLastRecent());
	}

}
