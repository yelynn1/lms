package com.ci6225.assignment.lms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ci6225.assignment.lms.entity.Instructor;
import com.ci6225.assignment.lms.entity.Login;
import com.ci6225.assignment.lms.entity.Student;
import com.ci6225.assignment.lms.services.StudentService;

@Controller
@SessionAttributes({"student"})
public class StudentController {
	
	@Autowired
	private StudentService service;

	public StudentService getService() {
		return service;
	}

	public void setService(StudentService service) {
		this.service = service;
	}
	
	@RequestMapping("/studentRegisteration")
	public ModelAndView showRegistrationPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("studentLogin");
		System.out.println("Showed Registertion Page");
		return modelAndView;
	}
	
	@RequestMapping(value = "registerStudent", method = RequestMethod.POST)
	public ModelAndView registeredUser(@ModelAttribute("student") Student student, ModelMap model) {
		int result = service.save(student);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","Registeration success, please login");
		modelAndView.setViewName("studentLogin");
		System.out.println("inserted : " + student);
		modelAndView.addObject("result", student);
		return modelAndView;
	}
	
	
	@RequestMapping("/studentLogin")
	public ModelAndView showLoginPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("studentLogin");
		System.out.println("Showed Login Page");
		return modelAndView;
	}
	
	@RequestMapping(value = "loginStudent", method = RequestMethod.POST)
	public ModelAndView LoginStudent(@ModelAttribute("Login") Login login, ModelMap model, HttpServletRequest request){
		Student student = service.validateStudent(login);
		ModelAndView modelAndView = new ModelAndView();
		if(student != null) {
			modelAndView.setViewName("studentHome");
			request.getSession().setAttribute("student", student);
			modelAndView.addObject("student",student);
		}
		else {
			modelAndView.setViewName("studentLogin");
			modelAndView.addObject("message","Invalid Credentials");
			System.out.println("Invalid login");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "studentHome", method = RequestMethod.GET)
	public ModelAndView showInstructorHomePage(@ModelAttribute("student") Student student, ModelMap model, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (student.getId() == 0) {
			modelAndView.setViewName("studentLogin");
			modelAndView.addObject("message","Please Login to Proceed");
			return modelAndView;
		}			
		else {
			modelAndView.addObject("student",student);
			modelAndView.setViewName("studentHome");
			System.out.println("Showed Student's Home Page");
			return modelAndView;
		}
	}
	
	@RequestMapping(value = "logoutStudent", method = RequestMethod.GET)
	public ModelAndView logoutInstructor(@ModelAttribute("student") Student student, ModelMap model, HttpServletRequest request, SessionStatus sessionStatus) {
		ModelAndView modelAndView = new ModelAndView();
		sessionStatus.setComplete();
		request.getSession().invalidate();
		modelAndView.setViewName("studentLogin");
		modelAndView.addObject("message","Successfully logged out");
		return modelAndView;
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
