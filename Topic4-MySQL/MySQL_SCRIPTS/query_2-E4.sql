USE high_school;

SELECT 	CONCAT('Teacher: \n',TEACHER.last_name,',',TEACHER.first_name,'\n Schedules:'),
		GROUP_CONCAT(COURSE_SCHEDULE.day_of_week,'  ', COURSE_SCHEDULE.start_time,'-', COURSE_SCHEDULE.end_time,': ', COURSE.course_name)
		FROM teachers as TEACHER
		JOIN courses as COURSE ON (COURSE.id_teacher = TEACHER.id_teacher)
		JOIN courses_schedules as COURSE_SCHEDULE ON (COURSE_SCHEDULE.id_course = COURSE.id_course)
		WHERE TEACHER.id_teacher = 1
		ORDER BY COURSE_SCHEDULE.day_of_week;

