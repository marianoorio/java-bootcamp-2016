package com.bootcamp.topic4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JDBCConnectionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		HighSchoolAccess highSchool = new HighSchoolAccess();
		highSchool.listSchedulesOfTeacher(2);
		highSchool.listSchedulesOfTeacher(1);
		
		//HOW MUST BE AN ASSERT IN THIS CASE?
	}

}
