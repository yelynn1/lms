package com.ci6225.assignment.lms.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ci6225.assignment.lms.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public int create(Student student) {
		// TODO Auto-generated method stub
		int result = (int) hibernateTemplate.save(student);
		return result;
	}

	@Override
	public void update(Student student) {
		hibernateTemplate.update(student);
	}

	@Override
	public List<Student> listStudents() {
		List<Student> list=new ArrayList<Student>();  
	    list=hibernateTemplate.loadAll(Student.class);  
	    return list;  
	}

	@Override
	public Student getStudent(int id) {
		Student student=(Student)hibernateTemplate.get(Student.class,id);  
	    return student; 
	}

	@Override
	public void removeStudent(String username) {
		hibernateTemplate.delete(username);
	}
	
	@Override
	public Student validateStudent(String username, String password) {
		String sql = "from Student where email = ? and password = ?";
		List find = (List) hibernateTemplate.find(sql,username, password);
		System.out.println(find);
		if (find.size() > 0 && find!=null) {
			List<Student> students = (List<Student>) find;
			return students.get(0);
		}
		else {
			return null;
		}
	}

}
