package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepo empRepo;
	
	
	//http://localhost:8080/e
	@RequestMapping("/e")
	@ResponseBody // It means returns data not view
	public String getEs()
	{
		return empRepo.findAll().toString();
	}
	
	//http://localhost:8080/e/100
	@RequestMapping("/e/{eid}")					//here {eid} is wildcard
	@ResponseBody // It means returns data not view name : DispatcherServlet understands
	public String getE(@PathVariable Integer eid)
	{
		return empRepo.findById(eid).get().toString();
	}
	
	//http://localhost:8080/em
	@RequestMapping(path="/em",produces = {"application/xml","application/json"})
	public Iterable<Employee> getEms()
	{
		return empRepo.findAll();
	}
	
	//http://localhost:8080/em/100
	@RequestMapping(path="/em/{eid}",produces = {"application/xml","application/json"})					//here {eid} is wildcard
	public Optional<Employee> getEmp(@PathVariable Integer eid)
	{
		return empRepo.findById(eid);
	}
	
	//http://localhost:8080/emp
	@GetMapping("/emp")
	public Iterable<Employee> getEmployees()
	{
		return empRepo.findAll();
	}
	
	//http://localhost:8080/emp/100
	@GetMapping("/emp/{eid}")
	public Optional<Employee> getEmployee(@PathVariable Integer eid)
	{
		return empRepo.findById(eid);
	}

	//http://localhost:8080/emp/
	@PostMapping(path ="/emp", consumes = {"application/xml","application/json"})
	public Employee addEmployee(@RequestBody Employee emp)
	{
		return empRepo.save(emp);
	}
	
	//http://localhost:8080/emp/100
	@DeleteMapping("/emp/{eid}")
	public Integer deleteEmployee(@PathVariable Integer eid)
	{
		if (empRepo.existsById(eid)) {
			empRepo.deleteById(eid);
			return eid;
		} else
			return 0;
	}
	
	@PutMapping(path="/emp", consumes = {"application/xml","application/json"})
	public Employee updateEmp(@RequestBody Employee emp)
	{
		if(empRepo.existsById(emp.getEid()))
			return empRepo.save(emp);
		else
			return null;
	}
}
