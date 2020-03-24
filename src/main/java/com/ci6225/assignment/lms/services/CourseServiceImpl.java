package com.ci6225.assignment.lms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ci6225.assignment.lms.dao.CourseDAO;
import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Instructor;
import com.ci6225.assignment.lms.entity.Student;
import com.ci6225.assignment.lms.entity.StudentEnrollment;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO dao;
	
	
	public CourseDAO getDao() {
		return dao;
	}


	public void setDao(CourseDAO dao) {
		this.dao = dao;
	}


	@Override
	@Transactional
	public int save(Course course, Instructor instructor) {
		course.setInstructor(instructor);
		return dao.create(course);
	}


	@Override
	@Transactional
	public List<Course> showCourses() {
		List<Course> courses = dao.listCourses();
		return courses;
	}


	@Override
	@Transactional
	public void registerCourse(int courseId, Student student) {
		int studentId = student.getId();
		StudentEnrollment enrollment = new StudentEnrollment(studentId, courseId);
		int result = dao.registerCourse(enrollment);
		System.out.println(result + " : " + enrollment);
	}


	@Override
	@Transactional
	public Course getValidatedCourse(int course_id, Instructor instructor) {
		Course course = dao.getCourse(course_id);
		if(instructor.getId() == course.getInstructor().getId()) {
			return course;
		}
		else {
			return new Course();
		}
	}


	@Override
	@Transactional
	public Course getValidatedCourseStudent(int course_id, Student student) {
		Course course = dao.getCourse(course_id);
		return course;
	}


	@Override
	@Transactional
	public List<Student> getStudentList(int course_id) {
		List<Student> students = dao.getStudents(course_id);
		return students;
	}


	@Override
	@Transactional
	public void removeStudent(int student_id, int course_id) {
		StudentEnrollment enrollment = new StudentEnrollment(student_id, course_id);
		dao.removeEnrollment(enrollment);
		
	}

}
