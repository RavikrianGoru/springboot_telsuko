package com.example.webapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.webapp.model.Student;

@Controller
public class HomeController {
	// http://localhost:8080/home
	
	@RequestMapping("homedata")
	@ResponseBody
	public String homeData()
	{
		System.out.println("homedata: is called");
		return "homedata.....";
	}
	
	@RequestMapping("home")
	public String home() {
		System.out.println("home page: is called");
		return "home";//this jsp page--- pages/home.jsp
	}

	// http://localhost:8080/userpage?name=ravi
	@RequestMapping("userpage")
	public String userHome(HttpServletRequest req) {
		HttpSession session = req.getSession();
		System.out.println("userpage page: is called");
		String name = req.getParameter("name");// how to send this name to jsp page?
		// RequestDespature/Response.sendRedurect()
		System.out.println("Captured query param is " + name);
		// req.setAttribute("name", name);
		session.setAttribute("name", name);
		return "userpage";
	}

	// http://localhost:8080/usermypage?name=ravi
	@RequestMapping("usermypage")
	public void userMyHome(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		System.out.println("usermypage page: is called");
		String name = req.getParameter("name");// how to send this name to jsp page?
		// RequestDespature/Response.sendRedurect()
		System.out.println("Captured query param is " + name);
		// req.setAttribute("name", name);
		session.setAttribute("name", name);
		resp.sendRedirect("/pages/usermypage.jsp");
	}

	// http://localhost:8080/profile?name=ravi
	@RequestMapping("profile")
	public String userHome(@RequestParam("name") String name, HttpSession session) {
		System.out.println("profile page: is called");
		System.out.println("Captured query param is " + name);
		session.setAttribute("name", name);
		return "profile";
	}

	// http://localhost:8080/posts?name=Ravi
	@RequestMapping("posts")
	public ModelAndView getPosts(@RequestParam("name") String myName) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", myName);
		mv.setViewName("posts");
		return mv;
	}

	// http://localhost:8080/student?id=100&name=Ravi&avg=56.8d
	// http://localhost:8080/student?avg=56.8d&id=100&name=Ravi
	@RequestMapping("student")
	public ModelAndView getStudent(Student stuObj) {
		Student obj = new Student(100, "Ravi", 72.8d);
		ModelAndView mv = new ModelAndView();
		mv.addObject("stuObj", stuObj);
		mv.setViewName("student");
		return mv;
	}
}
