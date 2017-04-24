USE high_school;

INSERT INTO students(first_name,last_name,birthdate)
VALUES
('student_name0','student_lastname0','1992-01-19'),
('student_name1','student_lastname1','1992-01-19'),
('student_name2','student_lastname2','1992-01-19'),
('student_name3','student_lastname3','1992-01-19'),
('student_name4','student_lastname4','1992-01-19'),
('student_name5','student_lastname5','1992-01-19'),
('student_name6','student_lastname6','1992-01-19'),
('student_name7','student_lastname7','1992-01-19'),
('student_name8','student_lastname8','1992-01-19'),
('student_name9','student_lastname9','1992-01-19'),
('student_name10','student_lastname10','1992-01-19'),
('student_name11','student_lastname11','1992-01-19'),
('student_name12','student_lastname12','1992-01-19'),
('student_name13','student_lastname13','1992-01-19'),
('student_name14','student_lastname14','1992-01-19'),
('student_name15','student_lastname15','1992-01-19'),
('student_name16','student_lastname16','1992-01-19'),
('student_name17','student_lastname17','1992-01-19'),
('student_name18','student_lastname18','1992-01-19'),
('student_name19','student_lastname19','1992-01-19');

INSERT INTO teachers(id_teacher,first_name,last_name,birthdate)
VALUES
(0,'teacher_name0','teacher_lastname0','1985-10-23'),
(1,'teacher_name1','teacher_lastname1','1972-03-15'),
(2,'teacher_name2','teacher_lastname2','1977-08-12');

INSERT INTO courses(id_course,course_name,week_hours,id_teacher)
VALUES
(0,'course0',12,1),
(1,'course1',8,2),
(2,'course2',7,1);

INSERT INTO courses_schedules(id_course,day_of_week,start_time,end_time)
VALUES
(0,2,'18:00','20:00'),
(0,4,'14:00','18:00'),
(0,5,'18:00','20:00'),
(1,3,'14:00','18:00'),
(1,5,'14:00','18:00'),
(2,2,'15:00','16:30'),
(2,4,'15:00','16:30');

INSERT INTO courses_students(id_course,id_student)
VALUES
(0,3),
(0,6),
(0,4),
(0,12),
(0,20),
(0,16),
(0,9),
(0,11),
(0,14),
(0,5),
(1,2),
(1,7),
(1,11),
(1,1),
(1,19),
(1,13),
(1,10),
(1,5),
(1,14),
(1,6),
(2,14),
(2,11),
(2,10),
(2,15),
(2,13),
(2,18),
(2,9),
(2,19),
(2,3),
(2,7);

INSERT INTO courses_students_exams(id_course, id_student, exam_type,note)
VALUES
(0,3,'partial_1',3),(0,3,'partial_2',4),(0,3,'partial_3',2),
(0,6,'partial_1',4),(0,6,'partial_2',5),(0,6,'partial_3',4),(0,6,'final',2),
(0,4,'partial_1',6),(0,4,'partial_2',5),(0,4,'partial_3',5),(0,4,'final',7),
(0,12,'partial_1',8),(0,12,'partial_2',8),(0,12,'partial_3',9),(0,12,'final',7),
(0,20,'partial_1',6),(0,20,'partial_2',2),(0,20,'partial_3',2),
(0,16,'partial_1',6),(0,16,'partial_2',4),(0,16,'partial_3',5),(0,16,'final',6),
(0,9,'partial_1',9),(0,9,'partial_2',8),(0,9,'partial_3',7),(0,9,'final',9),
(0,11,'partial_1',2),(0,11,'partial_2',2),(0,11,'partial_3',0),
(0,14,'partial_1',8),(0,14,'partial_2',9),(0,14,'partial_3',8),(0,14,'final',9.75),
(0,5,'partial_1',10),(0,5,'partial_2',8),(0,5,'partial_3',10),(0,5,'final',10);

