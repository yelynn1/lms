package com.ci6225.assignment.lms.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Lecture;

@Repository
public class LectureDAOImpl implements LectureDAO {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	public Course getCourse(int id) {
		Course course = (Course) hibernateTemplate.get(Course.class, id);
		return course;
	}
	
	@Override
	public int save(Lecture lecture) {
		int result = (int) hibernateTemplate.save(lecture);
		return result;
	}

	@Override
	public String saveFile(MultipartFile file) {
		String name = file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();

				File dir = new File("upload");
				if (!dir.exists())
					dir.mkdirs();

				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				String url = serverFile.getAbsolutePath();
				return url;
			} 
			catch (Exception e) {
				return null;
			}
	}

}
