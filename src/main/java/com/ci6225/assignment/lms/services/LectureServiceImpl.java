package com.ci6225.assignment.lms.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ci6225.assignment.lms.dao.CourseDAO;
import com.ci6225.assignment.lms.dao.InstructorDAO;
import com.ci6225.assignment.lms.dao.LectureDAO;
import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Lecture;

@Service
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureDAO dao;

	public LectureDAO getDao() {
		return dao;
	}

	public void setDao(LectureDAO dao) {
		this.dao = dao;
	}




	@Override
	@Transactional
	public void save(Lecture lecture, MultipartFile file, int course_id) {
		Course course = dao.getCourse(course_id);
		String filename = dao.saveFile(file);
		
		

	    lecture.setLink(filename);
	    
	    
		Date date = new Date();
		lecture.setDate(date);
		lecture.setCourse(course);
		dao.save(lecture);
		
	}

	@Override
	@Transactional
	public void delete(int course_id, int lecture_id) {
		Lecture lecture = dao.getLecture(lecture_id);
		dao.deleteLecture(course_id, lecture);
		
	}
}
