package com.ci6225.assignment.lms.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Student;
import com.ci6225.assignment.lms.entity.StudentEnrollment;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public int create(Course course) {
		return (int)hibernateTemplate.save(course);
	}

	@Override
	public List<Course> listCourses() {
		List<Course> courses = new ArrayList<Course>();
		courses = hibernateTemplate.loadAll(Course.class);
		return courses;
	}

	@Override
	public int registerCourse(StudentEnrollment enrollment) {
		int result = (int) hibernateTemplate.save(enrollment);
		return result;
	}

	@Override
	public Course getCourse(int id) {
		Course course = (Course) hibernateTemplate.get(Course.class, id);
		return course;
	}

	@Override
	public List<Student> getStudents(int course_id) {
		Course course = hibernateTemplate.load(Course.class,course_id);
		List<Student> students = new ArrayList<Student>(hibernateTemplate.load(Course.class,course_id).getStudents());
		return students;
	}

	@Override
	public void removeEnrollment(StudentEnrollment enrollment) {
		String query = "from StudentEnrollment where student_id = ? and course_id= ?";
		List<StudentEnrollment> find = (List<StudentEnrollment>)hibernateTemplate.find(query, enrollment.getStudent_id(),enrollment.getCourse_id());
		if (find.size() > 0 && find!=null) {
			StudentEnrollment enrol = find.get(0);
			hibernateTemplate.delete(enrol);
		}
	}

}
