package com.ci6225.assignment.lms.dao;

import java.util.List;

import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Instructor;
import com.ci6225.assignment.lms.entity.Student;

public interface InstructorDAO {
	public int create(Instructor instructor);
	public void update(Instructor instructor);
	public List<Course> getInstructorCourses(int id);
	public void removeInstructor(String username);
	public Instructor validateInstructor(String username,String password);
	public Instructor getInstructor(int id);
}
