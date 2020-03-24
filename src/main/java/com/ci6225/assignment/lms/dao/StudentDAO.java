package com.ci6225.assignment.lms.dao;

import java.util.List;

import com.ci6225.assignment.lms.entity.Student;

public interface StudentDAO {
	public int create(Student student);
	public void update(Student student);
	public List<Student> listStudents();
	public Student getStudent(String username);
	public void removeStudent(String username);
	public Student validateStudent(String username, String password);
}
