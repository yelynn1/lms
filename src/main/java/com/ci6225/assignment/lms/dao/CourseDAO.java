package com.ci6225.assignment.lms.dao;

import java.util.List;

import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Student;
import com.ci6225.assignment.lms.entity.StudentEnrollment;

public interface CourseDAO {

	public int create(Course course);
	public List<Course> listCourses();
	public int registerCourse(StudentEnrollment enrollment);
	public Course getCourse(int id);
	public List<Student> getStudents(int course_id);
	public void removeEnrollment(StudentEnrollment enrollment);
}
