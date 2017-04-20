package com.bootcamp.topic4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class HighSchoolAccess {
	
	private JDBCConnection dbConnection = null;
	private ResultSet results = null;
	private PreparedStatement statement = null;
	
	public HighSchoolAccess(){
	}
	
	/**
	 * Gets and show on console the schedules of a given teacher
	 * 
	 * @param idTeacher identifier of teacher
	 * 
	 */
	public void listSchedulesOfTeacher(int idTeacher){
		Integer id = new Integer(idTeacher);
		dbConnection = JDBCConnection.getInstance();
		if(dbConnection != null && !dbConnection.isClosed()){
			StringBuilder statementBuilder = new StringBuilder("SELECT ");
			statementBuilder.append("TEACHER.last_name , TEACHER.first_name,");
			statementBuilder.append(" COURSE_SCHEDULE.day_of_week, COURSE_SCHEDULE.start_time, COURSE_SCHEDULE.end_time, COURSE.course_name");
			statementBuilder.append(" FROM teachers as TEACHER");
			statementBuilder.append(" JOIN courses as COURSE ON (COURSE.id_teacher = TEACHER.id_teacher)");
			statementBuilder.append(" JOIN courses_schedules as COURSE_SCHEDULE ON (COURSE_SCHEDULE.id_course = COURSE.id_course)");
			statementBuilder.append(" WHERE TEACHER.id_teacher = ?");
			statementBuilder.append(" ORDER BY COURSE_SCHEDULE.day_of_week;");
			try {
				statement = dbConnection.getConnection().prepareStatement(statementBuilder.toString());
				statement.setString(1, id.toString());
				results = statement.executeQuery();
				showSchedulesOfTeacher(results);
				statement.close();
				statement = null;
				results.close();
				results = null;
				dbConnection.closeConnection();
			} catch (SQLException e) {
				Logger.getAnonymousLogger().severe(e.getMessage());
			}
		}
		
	}
	
	/**
	 * Shows on console the results of the teacher's schedules query
	 * 
	 * @param results of the execute of query
	 * @throws SQLException
	 */
	private void showSchedulesOfTeacher(ResultSet results) throws SQLException{
		if(results != null){
			int iteration = 0;
			while(results.next()){
				StringBuilder resultString = new StringBuilder();
				if (iteration == 0){
					resultString.append("Teacher: ");
					resultString.append(System.getProperty("line.separator"));
					resultString.append(results.getString("last_name"));
					resultString.append(", ");
					resultString.append(results.getString("first_name"));
					resultString.append(System.getProperty("line.separator"));
					resultString.append("Schedules: ");
					resultString.append(System.getProperty("line.separator"));
					iteration ++;
				}
				resultString.append(intToDay(Integer.valueOf(results.getString("day_of_week"))).getName());
				resultString.append("		");
				resultString.append(results.getString("start_time").substring(0, 5));
				resultString.append(" - ");
				resultString.append(results.getString("end_time").substring(0, 5));
				resultString.append("	");
				resultString.append(results.getString("course_name"));
				System.out.println(resultString.toString());	
			}		
		}
	}
	
	/**
	 * 
	 * Enum for days of week
	 *
	 */
	private enum Day{
		SUNDAY(0,"Sunday"), 
		MONDAY(1,"Monday"),
		TUESDAY(2,"Tuesday"),
		WEDNESDAY(3,"Wednesday"),
		THURSDAY(4,"Thursday"),
		FRIDAY(5,"Friday"),
		SATURDAY(6, "Saturday");

	    int value;
	    String name;

	    private Day(int value, String name) {
	        this.value = value;
	        this.name = name;
	    }
	    
	    public String getName(){
	    	return this.name;
	    }
	    
	    public int getValue(){
	    	return this.value;
	    }
	}
	
	/**
	 * Return the day of an given index
	 * 
	 * @param dayValue index of day
	 * @return the day associated at index / null if the index is > 6
	 */
	private Day intToDay(int dayValue){
		Day dayReturn = null;
		if (dayValue == 0){
			dayReturn = Day.SUNDAY;
		}else if (dayValue == 1){
			dayReturn = Day.MONDAY;
		}else if (dayValue == 2){
			dayReturn = Day.TUESDAY;
		}else if (dayValue == 3){
			dayReturn = Day.WEDNESDAY;
		}else if (dayValue == 4){
			dayReturn = Day.THURSDAY;
		}else if (dayValue == 5){
			dayReturn = Day.FRIDAY;
		}else if (dayValue == 6){
			dayReturn = Day.SATURDAY;
		}
		return dayReturn;
	}
}
