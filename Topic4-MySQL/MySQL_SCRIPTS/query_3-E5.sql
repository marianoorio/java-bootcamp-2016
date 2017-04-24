USE high_school;

SELECT(
		(SELECT COUNT(*) FROM courses_students_exams WHERE (id_course = 0 AND exam_type = 'final' AND note >= 4))/
		(SELECT COUNT(*) FROM courses_students_exams WHERE (id_course = 0 AND exam_type = 'final'))*100);
