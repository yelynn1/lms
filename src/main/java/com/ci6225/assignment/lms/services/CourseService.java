package com.ci6225.assignment.lms.services;

import java.util.List;

import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Instructor;
import com.ci6225.assignment.lms.entity.Student;

public interface CourseService {
	public int save(Course course, Instructor instructor);
	public List<Course> showCourses();
	public void registerCourse(int course_id, Student student);
	public Course getValidatedCourse(int course_id, Instructor instructor);
	public Course getValidatedCourseStudent(int course_id, Student student);
	public List<Student> getStudentList(int course_id);
	public void removeStudent(int student_id, int course_id);
}