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
		SchedulesDAO highSchool = new SchedulesDAOimpl();
		highSchool.schedulesOfTeacher(2);
		highSchool.schedulesOfTeacher(1);
	}

}
