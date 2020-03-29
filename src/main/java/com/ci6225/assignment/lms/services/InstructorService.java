package com.ci6225.assignment.lms.services;

import java.util.List;

import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Instructor;
import com.ci6225.assignment.lms.entity.Login;

public interface InstructorService {
	int save(Instructor instructor);
	List<Instructor> showAll();
	Instructor validateInstructor(Login login);
	List<Course> getCourses(int id);
	Instructor getInstructorUpdate(Instructor instructor);
}
