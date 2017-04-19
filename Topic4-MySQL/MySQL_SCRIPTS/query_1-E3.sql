USE high_school;

SELECT	COURSE.course_name,
		CONCAT('Teacher: ', TEACHER.last_name,', ',TEACHER.first_name),
		CONCAT('Students: \n'),		
		GROUP_CONCAT(STUDENTS.last_name,', ',STUDENTS.first_name)
		FROM courses as COURSE
		JOIN teachers as TEACHER ON (COURSE.id_teacher = TEACHER.id_teacher)
		JOIN courses_students as COURSE_STUDENTS on (COURSE.id_course = COURSE_STUDENTS.id_course)
		JOIN students as STUDENTS ON (COURSE_STUDENTS.id_student = STUDENTS.id_student)
		WHERE COURSE.id_course = 2
		ORDER BY STUDENTS.last_name;
