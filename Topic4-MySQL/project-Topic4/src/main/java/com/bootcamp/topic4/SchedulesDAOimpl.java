package com.bootcamp.topic4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.logging.Logger;

/**
 * 
 * This class performs consult query on the high_school data base
 *
 */
public class SchedulesDAOimpl implements SchedulesDAO{
	
	private JDBCConnection dbConnection = null;
	
	public SchedulesDAOimpl(){
	}
	
	@Override
	public void schedulesOfTeacher(int idTeacher){
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
			
			try (PreparedStatement statement = 
					dbConnection.getConnection().prepareStatement(statementBuilder.toString())){
				statement.setString(1, id.toString());
				ResultSet results = statement.executeQuery();
				showSchedulesOfTeacher(results);
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
				resultString.append(DayOfWeek.of(Integer.valueOf(results.getString("day_of_week"))));
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
}
