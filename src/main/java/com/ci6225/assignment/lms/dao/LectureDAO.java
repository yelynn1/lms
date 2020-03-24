package com.ci6225.assignment.lms.dao;

import org.springframework.web.multipart.MultipartFile;

import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Lecture;

public interface LectureDAO {
	public int save(Lecture lecture);
	public Course getCourse(int id);
	public String saveFile(MultipartFile file);
}
