package com.bootcamp.topic4;

public interface SchedulesDAO {
	/**
	 * Gets the schedules of a given teacher
	 * 
	 * @param idTeacher
	 * identifier of teacher
	 * 
	 */
	public void schedulesOfTeacher(int idTeacher);
}
