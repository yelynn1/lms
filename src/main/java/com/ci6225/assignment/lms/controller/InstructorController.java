package com.ci6225.assignment.lms.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ci6225.assignment.lms.entity.Instructor;
import com.ci6225.assignment.lms.entity.Login;
import com.ci6225.assignment.lms.entity.Student;
import com.ci6225.assignment.lms.services.InstructorService;

@Controller
@SessionAttributes("instructor")
public class InstructorController {
		
		@Autowired
		private InstructorService service;


		
		public InstructorService getService() {
			return service;
		}

		public void setService(InstructorService service) {
			this.service = service;
		}

		@RequestMapping("/instructorRegisteration")
		public ModelAndView showRegistrationPage() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("instructorRegisteration");
			System.out.println("Showed Registertion Page");
			return modelAndView;
		}
		
		@RequestMapping(value = "registerInstructor", method = RequestMethod.POST)
		public ModelAndView registeredUser(@ModelAttribute("instructor") Instructor instructor) {
			int result = service.save(instructor);
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("instructorLogin");
			System.out.println("inserted : " + instructor);
			modelAndView.addObject("result", instructor);
			return modelAndView;
		}
		
		@RequestMapping("/listInstructor")
		public ModelAndView listInstructor() {
			List<Instructor> instructors = service.showAll();
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("intructorList");
			modelAndView.addObject("instrutors",instructors);
			System.out.println("instructor list: " + instructors);
			return modelAndView;
		}
		
		@RequestMapping("/instructorLogin")
		public ModelAndView showLoginPage() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("instructorLogin");
			System.out.println("Showed Login Page");
			return modelAndView;
		}
		
		@RequestMapping(value = "loginInstructor", method = RequestMethod.POST)
		public ModelAndView LoginInstructor(@ModelAttribute("Login") Login login, ModelMap model, HttpServletRequest request) {
			Instructor instructor = service.validateInstructor(login);
			ModelAndView modelAndView = new ModelAndView();
			if(instructor != null) {
				
				
				System.out.println("instructor logged in: " + instructor);
				System.out.println("courses::: " + service.getCourses(instructor.getId()));
				modelAndView.addObject("courses",service.getCourses(instructor.getId()));
				request.getSession().setAttribute("instructor", instructor);
				modelAndView.addObject("instructor",instructor);
				modelAndView.setViewName("instructorHome");
			}
			else {
				modelAndView.setViewName("instructorLogin");
				modelAndView.addObject("message","Invalid Credentials");
				System.out.println("Invalid login");
			}
			return modelAndView;
		}
		
		
		
		@RequestMapping(value = "/instructorHome", method = RequestMethod.GET)
		public ModelAndView showInstructorHomePage(@ModelAttribute("instructor") Instructor instructor, ModelMap model, HttpServletRequest request) {
			ModelAndView modelAndView = new ModelAndView();
			
			if (instructor.getId() == 0) {
				modelAndView.setViewName("instructorLogin");
				modelAndView.addObject("message","Please Login to Proceed");
				return modelAndView;
			}			
			else {
				modelAndView.addObject("courses",instructor.getCourses());
				//modelAndView.addObject("instructor",instructor);
				modelAndView.setViewName("instructorHome");
				System.out.println("Showed Instructor Home Page");
				return modelAndView;
			}
		}
		
		
		
		@RequestMapping(value = "logoutInstructor", method = RequestMethod.GET)
		public ModelAndView logoutInstructor(@ModelAttribute("instructor") Instructor instructor, ModelMap model, HttpServletRequest request, SessionStatus sessionStatus) {
			ModelAndView modelAndView = new ModelAndView();
			request.getSession().invalidate();
			sessionStatus.setComplete();
			modelAndView.setViewName("instructorLogin");
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

}
