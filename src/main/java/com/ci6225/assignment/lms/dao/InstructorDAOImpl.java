package com.ci6225.assignment.lms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Instructor;
import com.ci6225.assignment.lms.entity.Student;

@Repository
public class InstructorDAOImpl implements InstructorDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public int create(Instructor instructor) {
		int result = (int) hibernateTemplate.save(instructor);
		return result;
	}

	@Override
	public void update(Instructor instructor) {
		// TODO Auto-generated method stub

	}





	@Override
	public void removeInstructor(String username) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Instructor validateInstructor(String username, String password) {
		System.out.println(username+password);
		String sql = "from Instructor it where it.email = ? and it.password = ?";
		List find = (List) hibernateTemplate.find(sql,username, password);
		//System.out.println(find);
		if (find.size() > 0 && find!=null) {
			List<Instructor> instructors = (List<Instructor>) find;
			return instructors.get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public List<Course> getInstructorCourses(int id) {
		Instructor instructor = (Instructor) hibernateTemplate.load(Instructor.class, id);
		List<Course> courses = instructor.getCourses();
		return courses;
	}

	@Override
	public Instructor getInstructor(int id) {
		Instructor instructor = (Instructor) hibernateTemplate.get(Instructor.class, id);
		return instructor;
	}

}
