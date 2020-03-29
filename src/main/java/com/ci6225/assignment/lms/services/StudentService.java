package com.ci6225.assignment.lms.services;

import java.util.List;

import com.ci6225.assignment.lms.entity.Login;
import com.ci6225.assignment.lms.entity.Student;

public interface StudentService {
	int save(Student student);
	List<Student> showAll();
	Student validateStudent(Login login);
	Student getStudentUpdate(Student student);
}
