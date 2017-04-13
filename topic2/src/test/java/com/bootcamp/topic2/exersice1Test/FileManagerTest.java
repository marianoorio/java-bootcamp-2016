package com.bootcamp.topic2.exersice1Test;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bootcamp.topic2.exersice1.FileManager;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class FileManagerTest {
	
	FileManager fileManager = FileManager.getFileManager();
	
	@Before
	public void setUp() throws Exception {
		//spy the class because it's applying a singleton pattern and can't inject mock
		fileManager = Mockito.spy(fileManager);
		//Alternative when.then way
		Mockito.doReturn(null).when(fileManager).getBufferedReader(Mockito.any(File.class));
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
		 fileManager.openFile(new File("file0"));
		 Assert.assertEquals("file0", fileManager.getRecentFiles().getLastRecent());
	}

}
