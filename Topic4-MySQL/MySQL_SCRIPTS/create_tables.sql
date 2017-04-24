USE high_school;

CREATE TABLE IF NOT EXISTS students
(
	id_student INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, -- Estudents unique identifier 
	first_name VARCHAR(20) NOT NULL, -- Estudents first name
	last_name VARCHAR(20) NOT NULL, -- Estudents last name
	birthdate DATE NOT NULL -- Estudents date of birth
);


CREATE TABLE IF NOT EXISTS teachers
(
	id_teacher INT UNSIGNED NOT NULL PRIMARY KEY, -- teacher unique identifier
	first_name VARCHAR(20) NOT NULL, -- teacher first name
	last_name VARCHAR(20) NOT NULL, -- teacher last name
	birthdate DATE NOT NULL -- teacher date of birth
);

CREATE TABLE IF NOT EXISTS courses
(
	id_course INT UNSIGNED NOT NULL PRIMARY KEY, -- course unique identifier
	course_name VARCHAR(20) NOT NULL,  -- course name
	week_hours INT UNSIGNED NOT NULL DEFAULT 0, -- course duration(hours) in a week
	id_teacher INT UNSIGNED DEFAULT NULL, -- id of teacher assigned to the course
	FOREIGN KEY (id_teacher) REFERENCES teachers(id_teacher) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS courses_schedules
(
	id_course INT UNSIGNED NOT NULL, -- 
	day_of_week TINYINT(1) UNSIGNED NOT NULL,
	start_time TIME NOT NULL,
	end_time TIME NOT NULL,
	PRIMARY KEY (id_course, day_of_week, start_time, end_time),
	FOREIGN KEY (id_course) REFERENCES courses(id_course), 
	CHECK (day_of_week < 7)
);

CREATE TABLE IF NOT EXISTS courses_students
(
	id_course INT UNSIGNED NOT NULL,
	id_student INT UNSIGNED NOT NULL,
	PRIMARY KEY (id_course, id_student),
	FOREIGN KEY (id_course) REFERENCES courses(id_course),
	FOREIGN KEY (id_student) REFERENCES students(id_student)
);

CREATE TABLE IF NOT EXISTS courses_students_exams
(
	id_course INT UNSIGNED NOT NULL,
	id_student INT UNSIGNED NOT NULL,
	exam_type ENUM('partial_1','partial_2','partial_3','final') NOT NULL,	
	note FLOAT UNSIGNED NOT NULL,	
	PRIMARY KEY (id_course, id_student, exam_type),
	FOREIGN KEY (id_course) REFERENCES courses(id_course),
	FOREIGN KEY (id_student) REFERENCES students(id_student),
	CHECK (note <= 10)
);

