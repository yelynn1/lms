package com.ci6225.assignment.lms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ci6225.assignment.lms.entity.Course;
import com.ci6225.assignment.lms.entity.Instructor;
import com.ci6225.assignment.lms.entity.Student;
import com.ci6225.assignment.lms.services.CourseService;

@Controller
@SessionAttributes({"instructor","student"})
public class CourseController {
	
	@Autowired
	private CourseService service;

	public CourseService getService() {
		return service;
	}

	public void setService(CourseService service) {
		this.service = service;
	}
	
	@RequestMapping("/showCourses")
	public ModelAndView listCourses() {
		List<Course> courses = service.showCourses();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("courses", courses);
		modelAndView.setViewName("allCourses");
		System.out.println("Showing all courses");
		return modelAndView;
		
	}
	
	@RequestMapping("/courseCreation")
	public ModelAndView showcourseCreationPage(@ModelAttribute("instructor") Instructor instructor, ModelMap model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(instructor);
		if(instructor.getId() == 0) {
            modelAndView.setViewName("redirect:/instructorLogin");
			modelAndView.addObject("message","Please login to continue");
			System.out.println("Set msg");
		}
		else {
			modelAndView.setViewName("courseCreate");
			modelAndView.addObject("instructor", instructor);
			System.out.println("Showed course creation Page");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "createCourse", method = RequestMethod.POST)
	public ModelAndView createCourse(@ModelAttribute("instructor") Instructor instructor, @ModelAttribute("course") Course course) {
		//if(instructor.getId() == 0) return new ModelAndView("instructorLogin");
		ModelAndView modelAndView = new ModelAndView();
		//course.setInstructor_id(instructor.getId());
		service.save(course,instructor);
		modelAndView.setViewName("redirect:/instructorHome");
		System.out.println(course);
		return modelAndView;
	}
	
	@RequestMapping(value = "registerCourse/{course_id}", method = RequestMethod.GET)
	public ModelAndView registerCourse(@ModelAttribute("student") Student student, @PathVariable int course_id, ModelMap model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		if(student.getId() != 0) {
			service.registerCourse(course_id, student);
			modelAndView.setViewName("redirect:/studentHome");
			modelAndView.addObject("student",student);
		}
		else {
			modelAndView.addObject("message","Invalid Credentials");
			modelAndView.setViewName("redirect:/studentLogin");
			System.out.println("Invalid login");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "{course_id}/instructorCoursePanel", method = RequestMethod.GET)
	public ModelAndView showInstructorCoursePage(@ModelAttribute("instructor") Instructor instructor, @PathVariable int course_id, ModelMap model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (instructor.getId() == 0) {
			modelAndView.setViewName("redirect:/instructorLogin");
			modelAndView.addObject("message","Please Login to Proceed");
			return modelAndView;
		}			
		else {
			
			modelAndView.addObject("course",service.getValidatedCourse(course_id, instructor));
			//modelAndView.addObject("instructor",instructor);
			modelAndView.setViewName("instructorCoursePanel");
			System.out.println("Showed Instructor Course Page");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "{course_id}/studentCoursePanel", method = RequestMethod.GET)
	public ModelAndView showStudentCoursePage(@ModelAttribute("student") Student student, @PathVariable int course_id, ModelMap model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (student.getId() == 0) {
			modelAndView.setViewName("redirect:/studentLogin");
			modelAndView.addObject("message","Please Login to Proceed");
			return modelAndView;
		}			
		else {
			
			modelAndView.addObject("course",service.getValidatedCourseStudent(course_id, student));
			modelAndView.setViewName("studentCoursePanel");
			System.out.println("Showed Student Course Page");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "{course_id}/studentList", method = RequestMethod.GET)
	public ModelAndView showRegisteredStudents(@ModelAttribute("instructor") Instructor instructor, @PathVariable int course_id, ModelMap model, HttpServletRequest request) throws LazyInitializationException {
		ModelAndView modelAndView = new ModelAndView();
		
		if (instructor.getId() == 0) {
			modelAndView.setViewName("redirect:/instructorLogin");
			modelAndView.addObject("message","Please Login to Proceed");
			return modelAndView;
		}			
		else {
			Course course = service.getValidatedCourse(course_id, instructor);
			modelAndView.addObject("course",course);
			modelAndView.addObject("students", service.getStudentList(course_id));
			modelAndView.setViewName("liststudent");
			System.out.println("Showed student list");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "{course_id}/removeStudent/{student_id}", method = RequestMethod.GET)
	public ModelAndView removeStudentFromCourse(@ModelAttribute("instructor") Instructor instructor, @PathVariable int course_id,@PathVariable int student_id, ModelMap model, HttpServletRequest request) throws LazyInitializationException {
		ModelAndView modelAndView = new ModelAndView();
		
		if (instructor.getId() == 0) {
			modelAndView.setViewName("redirect:/instructorLogin");
			modelAndView.addObject("message","Please Login to Proceed");
			return modelAndView;
		}			
		else {
			Course course = service.getValidatedCourse(course_id, instructor);
			modelAndView.addObject("course",course);
			service.removeStudent(student_id, course_id);
			modelAndView.setViewName("/liststudent");
			return modelAndView;
		}
	}
	
	@ModelAttribute("instructor")
	public Instructor getInstructorVisitor (HttpServletRequest request) {
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
