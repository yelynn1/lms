package com.ci6225.assignment.lms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Instructor;
import com.ci6225.assignment.lms.entity.Lecture;
import com.ci6225.assignment.lms.entity.Student;
import com.ci6225.assignment.lms.services.LectureService;

@Controller
@SessionAttributes({"instructor","student"})
public class LectureController {
	
	@Autowired
	private LectureService service;

	public LectureService getService() {
		return service;
	}

	public void setService(LectureService service) {
		this.service = service;
	}

	@RequestMapping(value = "{course_id}/lectureCreation", method = RequestMethod.GET)
	public ModelAndView showcourseCreationPage(@ModelAttribute("instructor") Instructor instructor, ModelMap model, @PathVariable int course_id, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(instructor);
		if(instructor.getId() == 0) {
            modelAndView.setViewName("redirect:/instructorLogin");
			modelAndView.addObject("message","Please login to continue");
		}
		else {
			modelAndView.setViewName("lectureCreate");
			System.out.println("Showed course creation Page");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "{course_id}/createLecture", method = RequestMethod.POST)
	public ModelAndView createCourse(@ModelAttribute("instructor") Instructor instructor, @ModelAttribute("lecture") Lecture lecture, @RequestParam("file") MultipartFile  file, ModelMap model, @PathVariable int course_id, HttpServletRequest request) {
		if(instructor.getId() == 0) return new ModelAndView("instructorLogin");
		ModelAndView modelAndView = new ModelAndView();
		
		service.save(lecture,file, course_id);
		modelAndView.setViewName("redirect:instructorCoursePanel");
		return modelAndView;
	}
	
	@ModelAttribute("instructor")
	public Instructor getInstructorVisitor (HttpServletRequest request) {
		System.out.println("Got empty instructor");
		if((Instructor)request.getSession().getAttribute("instructor") != null) {
			return (Instructor)request.getSession().getAttribute("instructor");
		}
		else {
			return new Instructor();
		}
    }
	
	@ModelAttribute("student")
    public Student getVisitor (HttpServletRequest request) {
		if((Student)request.getSession().getAttribute("student") != null) {
			return (Student)request.getSession().getAttribute("student");
		}
		else {
			return new Student();
		}
    }
}
