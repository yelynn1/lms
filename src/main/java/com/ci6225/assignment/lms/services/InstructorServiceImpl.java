package com.ci6225.assignment.lms.services;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ci6225.assignment.lms.dao.InstructorDAO;
import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Instructor;
import com.ci6225.assignment.lms.entity.Login;
import com.ci6225.assignment.lms.entity.Student;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDAO dao;
	
	public InstructorDAO getDao() {
		return dao;
	}

	public void setDao(InstructorDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public int save(Instructor instructor) {
		String hashed_pwd = DigestUtils.sha256Hex(instructor.getPassword());
		instructor.setPassword(hashed_pwd);
		return dao.create(instructor);
	}

	@Override
	public List<Instructor> showAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transactional
	public Instructor validateInstructor(Login login) {
		String hashed_pwd = DigestUtils.sha256Hex(login.getPassword());
		Instructor instructor = dao.validateInstructor(login.getUsername(),hashed_pwd);
		return instructor;
	}
	
	@Override
	@Transactional
	public List<Course> getCourses(int id) {
		return dao.getInstructorCourses(id);
	}

	@Override
	@Transactional
	public Instructor getInstructorUpdate(Instructor instructor) {
		return dao.getInstructor(instructor.getId());
	}

}
