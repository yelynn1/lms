package com.ci6225.assignment.lms.services;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ci6225.assignment.lms.dao.StudentDAO;
import com.ci6225.assignment.lms.entity.Login;
import com.ci6225.assignment.lms.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO dao;

	public StudentDAO getDao() {
		return dao;
	}

	public void setDao(StudentDAO dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public int save(Student student) {
		String hashed_pwd = DigestUtils.sha256Hex(student.getPassword());
		student.setPassword(hashed_pwd);
		return dao.create(student);
	}

	@Override
	@Transactional
	public List<Student> showAll() {
		List<Student> students = dao.listStudents();
		return students;
	}

	@Override
	public Student validateStudent(Login login) {
		String hashed_pwd = DigestUtils.sha256Hex(login.getPassword());
		Student student = dao.validateStudent(login.getUsername(),hashed_pwd);
		return student;
	}

}
