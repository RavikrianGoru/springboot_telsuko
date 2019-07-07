package com.example.webapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.webapp.dao.AlienRepo;
import com.example.webapp.model.Alien;

@Controller
public class AlienController {

	@Autowired
	AlienRepo alienRepo;

	@RequestMapping("/")
	public String getHome() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien obj) {
		alienRepo.save(obj);
		return "home.jsp";
	}

	@RequestMapping("/updateAlien")
	public String updateAlien(Alien obj) {
		if (alienRepo.existsById(obj.getAid())) {
			System.out.println(obj.getAid() + " is available ");
			alienRepo.save(obj);
			System.out.println(obj.getAid() + " is Updated");
		} else {
			System.out.println(obj.getAid() + " is not available ");
		}
		return "home.jsp";
	}

	@RequestMapping("/deleteAlien")
	public String deleteAlien(Integer aid) {
		if (alienRepo.existsById(aid)) {
			System.out.println(aid + " is available ");
			Optional<Alien> opAlien = alienRepo.findById(aid);
			alienRepo.delete(opAlien.get());
			System.out.println(aid + " is Deleted");
		} else {
			System.out.println(aid + " is not available ");
		}
		return "home.jsp";
	}

	@RequestMapping("/showAlien")
	public ModelAndView showAlien(Integer aid)// @RequestParam Integer aid
	{
		ModelAndView mv = new ModelAndView("alien.jsp");
		Alien obj = null;

		if (alienRepo.existsById(aid)) {
			System.out.println(aid + " is available ");
			obj = alienRepo.findById(aid).get();//.orElse(new Alien())
		} else {
			System.out.println(aid + " is not available ");
			obj = new Alien();
		}
		mv.addObject("obj", obj);
		return mv;
	}

	//Non Primary property
	@RequestMapping("/showAlientsByName")
	public ModelAndView getAliensByName(@RequestParam String name)
	{
		ModelAndView mv =new ModelAndView("alienList.jsp");
		List<Alien> aList=alienRepo.findByAname(name);
		mv.addObject("alienList", aList);
		return mv;
	}
	//Non Primary property
	@RequestMapping("/showAlientsByTech")
	public ModelAndView getAliensByTech(@RequestParam String tech)
	{
		ModelAndView mv =new ModelAndView("alienList.jsp");
		List<Alien> aList=alienRepo.findByTech(tech);
		mv.addObject("alienList", aList);
		return mv;
	}
	//With Condition
	@RequestMapping("/showAlientsGreaterThanAid")
	public ModelAndView getAliensByName(@RequestParam Integer aid)
	{
		ModelAndView mv =new ModelAndView("alienList.jsp");
		List<Alien> aList=alienRepo.findByAidGreaterThan(aid);
		mv.addObject("alienList", aList);
		return mv;
	}
	
	//With custom qiery
	@RequestMapping("/showAlientsQury")
	public ModelAndView getAliens(@RequestParam String tech)
	{
		ModelAndView mv =new ModelAndView("alienList.jsp");
		List<Alien> aList=alienRepo.findByTechSorted(tech);
		mv.addObject("alienList", aList);
		return mv;
	}
	
}
