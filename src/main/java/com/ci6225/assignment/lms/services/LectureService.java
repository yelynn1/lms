package com.ci6225.assignment.lms.services;


import org.springframework.web.multipart.MultipartFile;

import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Lecture;

public interface LectureService {
	public void save(Lecture lecture,MultipartFile file, int course_id);
	public void delete(int course_id, int lecture_id);
}
