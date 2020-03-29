package com.ci6225.assignment.lms.dao;

import org.springframework.web.multipart.MultipartFile;

import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Lecture;

public interface LectureDAO {
	public int save(Lecture lecture);
	public Course getCourse(int id);
	public String saveFile(MultipartFile file);
	public void deleteLecture(int course_id, Lecture lecture);
	public Lecture getLecture(int id);
}
